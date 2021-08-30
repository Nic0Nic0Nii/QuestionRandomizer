package sig;

import java.util.ArrayList;
import java.util.List;

import sig.components.Answer;
import sig.components.Question;
import sig.components.QuestionGroup;

public class QuestionRandomizer {

    public static void main(String[] args) {
        List<QuestionGroup> groups = new ArrayList<QuestionGroup>();

        groups.add(new QuestionGroup(new Question[]{
                new Question("Question 1", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
                new Question("Question 2", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
                new Question("Question 3", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
                new Question("Question 4", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
            }
        ));
        groups.add(new QuestionGroup(new Question[]{
                new Question("Question 1", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
                new Question("Question 2", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
                new Question("Question 3", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
                new Question("Question 4", new Answer[]{
                    new Answer("Answer 1"),
                    new Answer("Answer 2"),
                    new Answer("Answer 3"),
                    new Answer("Answer 4"),
                }),
            }
        ));

        int qCount = 1;

        for (QuestionGroup qg : groups) {
            while (qg.getQuestions().size()>0) {
                Question q = qg.getQuestions().remove((int)(Math.random()*qg.getQuestions().size()));
                System.out.println((qCount++)+". "+q.getText()+"\n"+
                q.DisplayAnswers()+"\n\n");
            }
        }
    }

}