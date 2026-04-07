package attacks.question;

public interface QuestionStrategy {
    abstract String askQuestion();
    abstract boolean checkAnswer(String answer);
    abstract String correctAnswer();
    abstract String wrongAnswer();
}