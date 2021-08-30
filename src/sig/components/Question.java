package sig.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question {
    List<Answer> answers = null;
    String text;
    public List<Answer> getAnswers() {
        return answers;
    }
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }
    public String getText() {
        return text;
    }
    public void setText(String text) {
        this.text = text;
    }
    public String DisplayAnswers() {
        int aCount = 0;
        StringBuilder finalStr = new StringBuilder("");
        while (answers.size()>0) {
            Answer a = answers.remove((int)(Math.random()*answers.size()));
            finalStr.append("\t");
            finalStr.append((char)('a'+(aCount++)));
            finalStr.append(". ");
            finalStr.append(a.getText());
        }
        return finalStr.toString();
    }
    public Question(String text,Answer[] answers) {
        this.text = text;
        this.answers = new ArrayList<Answer>(Arrays.asList(answers));
    }
}
