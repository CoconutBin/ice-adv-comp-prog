package attacks.question;

import attacks.question.strategies.QuestionStrategy;
import game.IOHandler;

public class Question {
    private QuestionStrategy strategy;
    private String question;
    private String[] options;
    private String answer;

    public Question(QuestionTypes type, String question, String answer) {
        this.question = question;
        this.answer = answer;
        determineStrategy(type);
    }

    public Question(QuestionTypes type, String question, String[] options, String answer) {
        this.question = question;
        this.options = options;
        this.answer = answer;
        determineStrategy(type);
    }

    private void determineStrategy(QuestionTypes type) throws IllegalArgumentException {
        switch (type) {
            case MULTIPLE_CHOICE:
                this.strategy = new attacks.question.strategies.MultipleChoiceQuestionStrategy();
                break;
            case WRITTEN:
                this.strategy = new attacks.question.strategies.WrittenQuestionStrategy();
                break;
            case TRUE_FALSE:
                this.strategy = new attacks.question.strategies.TrueFalseQuestionStrategy();
                break;
            default:
                throw new IllegalArgumentException("Invalid question type: " + type);
        }
    }

    public String askQuestion(IOHandler ioHandler) {
        return strategy.askQuestion(this, ioHandler);
    }

    public String getQuestion() {
        return question;
    }

    public String[] getOptions() {
        return options;
    }

    public String getAnswer() {
        return answer;
    }
}
