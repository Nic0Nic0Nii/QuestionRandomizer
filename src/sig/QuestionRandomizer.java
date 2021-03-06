package sig;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import sig.components.Answer;
import sig.components.Question;
import sig.components.QuestionGroup;

public class QuestionRandomizer {

    public static String[] readFromFile(String filename) {
        File file = new File(filename);
        //System.out.println(file.getAbsolutePath());
        List<String> contents= new ArrayList<String>();
        if (file.exists()) {
            try(
                    FileReader fw = new FileReader(filename);
                    BufferedReader bw = new BufferedReader(fw);)
                {
                    String readline = bw.readLine();
                    do {
                        if (readline!=null) {
                            //System.out.println(readline);
                            contents.add(readline);
                            readline = bw.readLine();
                        }} while (readline!=null);
                    fw.close();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return contents.toArray(new String[contents.size()]);
    }
    public static void logToFile(String message, String filename) {
        File file = new File(filename);
            try {

                if (!file.exists()) {
                    file.createNewFile();
                }
                OutputStream out = new FileOutputStream(file,true);
                Writer writer = new OutputStreamWriter(out, StandardCharsets.UTF_8);
                PrintWriter pw = new PrintWriter(writer);

                pw.println(message);
                pw.flush();
                pw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static boolean containsLetter(String s) {
        int marker = 0;
        if ((s.charAt(marker)=='X'&&s.charAt(++marker)=='.')||((s.charAt(marker)>='a'&&s.charAt(marker)<='z')&&s.charAt(++marker)=='.')) {
            return true;
        } else {
             return false;
         }
    }

    public static void main(String[] args) {
        new File("answers.txt").delete();
        new File("output.txt").delete();

        List<QuestionGroup> groups = new ArrayList<QuestionGroup>();

        String[] data = readFromFile("questions");
        Mode m = Mode.QUESTION;
        List<Question> q = new ArrayList<Question>();
        QuestionGroup g = new QuestionGroup(q);
        Question qq = null;
        List<Answer> a = null;
        for (String d : data) {
            if (d.length()==0) {
                q = new ArrayList<Question>();
                groups.add(g);
                g = new QuestionGroup(q);
                continue;
            }
            if (d.split(Pattern.quote(".")).length==0) {
                m=Mode.QUESTION;
            } else {
                if (isNumeric(d.split(Pattern.quote("."))[0])) {
                    m=Mode.QUESTION;
                    a = new ArrayList<Answer>();
                    qq = new Question("",a);
                    q.add(qq);
                } else 
                if (containsLetter(d)){
                    m=Mode.ANSWER;
                }
            }
            if (m==Mode.QUESTION) {
                qq.setText((qq.getText().length()>0?(qq.getText()+" "):"")+(d.indexOf('.')!=-1?d.substring(d.indexOf('.')+1):d));
            } else {
                a.add(new Answer(d.substring(d.indexOf('.')+1),d.charAt(0)=='X'));
            }
        }
        if (a!=null) {
            qq.setAnswers(a);
        }
        groups.add(g);

        //System.out.println(groups);

        int qCount = 1;

        for (QuestionGroup qg : groups) {
            while (qg.getQuestions().size()>0) {
                Question qqq = qg.getQuestions().remove((int)(Math.random()*qg.getQuestions().size()));
                String[] questions = qqq.DisplayAnswers();
                String output = (qCount)+". "+qqq.getText()+"\n"+questions[0];
                String outputAnswerGuide = (qCount++)+". "+qqq.getText()+"\n"+questions[1];
                System.out.println(output);
                logToFile(output,"output.txt");
                logToFile(outputAnswerGuide,"answers.txt");
            }
        }
    }

}