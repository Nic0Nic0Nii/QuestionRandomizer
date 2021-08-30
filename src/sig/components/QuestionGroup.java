package sig.components;

import java.util.ArrayList;
import java.util.List;

public class QuestionGroup {
    List<Question> questions = new ArrayList<Question>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public QuestionGroup(List<Question>questions) {
        this.questions=questions;
    }

    @Override
    public String toString() {
        return "QuestionGroup [questions=" + questions + "]";
    }
    
}
