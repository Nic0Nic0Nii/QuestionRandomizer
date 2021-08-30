package sig.components;

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
    public String[] DisplayAnswers() {
        int aCount = 0;
        StringBuilder finalStr = new StringBuilder("");
        StringBuilder finalStr2 = new StringBuilder("");
        while (answers.size()>0) {
            Answer a = answers.remove((int)(Math.random()*answers.size()));
            finalStr.append("\t");
            finalStr.append((char)('a'+(aCount)));
            finalStr.append(". ");
            finalStr.append(a.getText());
            finalStr.append("\n");
            if (a.isAnswer()) {
                finalStr2.append("✓");
            }
            finalStr2.append("\t");
            finalStr2.append((char)('a'+(aCount++)));
            finalStr2.append(". ");
            finalStr2.append(a.getText());
            finalStr2.append("\n");
        }
        return new String[]{finalStr.toString(),finalStr2.toString()};
    }
    public Question(String text,List<Answer> answers) {
        this.text = text;
        this.answers = answers;
    }
    @Override
    public String toString() {
        return "Question [answers=" + answers + ", text=" + text + "]";
    }
}
