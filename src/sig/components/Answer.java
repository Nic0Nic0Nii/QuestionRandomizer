package sig.components;

public class Answer {
    String text;
    boolean answer=false;
    public Answer(String text,boolean answer) {
        this.text = text;
        this.answer=answer;
    }

    public Answer(String text) {
        this(text,false);
    }

    public String getText() {
        return text;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Answer [answer=" + answer + ", text=" + text + "]";
    }
}
