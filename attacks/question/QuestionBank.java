package attacks.question;

import attacks.question.strategies.*;

// THIS IS A TEMPORARY CLASS TO HOLD QUESTIONS. IT WILL BE REPLACED WITH A PROPER QUESTION BANK USING JSON LATER (We might not do json).
public class QuestionBank {
    private static QuestionBank instance;
    private Question[] questions;
    
    private QuestionBank(){
        questions = new Question[] {
            new Question(new MultipleChoiceQuestionStrategy(), "What is the capital of France?", new String[] {"Berlin", "Madrid", "Paris", "Rome"}, "Paris"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is 2 + 2?", new String[] {"3", "4", "5", "6"}, "4"),
            new Question(new MultipleChoiceQuestionStrategy(), "What is the largest planet in our solar system?", new String[] {"Earth", "Mars", "Jupiter", "Saturn"}, "Jupiter"),
            new Question(new MultipleChoiceQuestionStrategy(), "What standards use a 2.4 Ghz frequency according to the wifi alliance?", new String[] {"802.11a", "802.11b", "802.11k", "802.11n"}, "802.11b"),
            new Question(new WrittenQuestionStrategy(), "Assuming a interface called Loggable, fill in the blank:\nclass Player ______ Loggable", "implements"),
            new Question(new TrueFalseQuestionStrategy(), "True or False: Physics and Electronics for Engineers is the most fun class in ICE", "False")
        };
        // Questions are also ai generated btw
    }

    public static QuestionBank getInstance() {
        if (instance == null) {
            instance = new QuestionBank();
        }
        return instance;
    }

    public Question[] getQuestions() {
        return questions;
    }

    public Question getRandomQuestion() {
        int randomIndex = (int) (Math.random() * questions.length);
        return questions[randomIndex];
    }
}
