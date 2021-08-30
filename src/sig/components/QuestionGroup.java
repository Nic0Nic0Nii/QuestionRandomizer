package sig.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuestionGroup {
    List<Question> questions = new ArrayList<Question>();

    public List<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(List<Question> questions) {
        this.questions = questions;
    }

    public QuestionGroup(Question[]questions) {
        this.questions=new ArrayList<Question>(Arrays.asList(questions));
    }
    
}
