package attacks.question;

// THIS IS A TEMPORARY CLASS TO HOLD QUESTIONS. IT WILL BE REPLACED WITH A PROPER QUESTION BANK USING JSON LATER.
public class QuestionBank {
    public static Question[] questions = new Question[] {
        new Question(QuestionTypes.MULTIPLE_CHOICE, "What is the capital of France?", new String[] {"Berlin", "Madrid", "Paris", "Rome"}, "Paris"),
        new Question(QuestionTypes.MULTIPLE_CHOICE, "What is 2 + 2?", new String[] {"3", "4", "5", "6"}, "4"),
        new Question(QuestionTypes.MULTIPLE_CHOICE, "What is the largest planet in our solar system?", new String[] {"Earth", "Mars", "Jupiter", "Saturn"}, "Jupiter")
    };
    // Questions are also ai generated btw
}
