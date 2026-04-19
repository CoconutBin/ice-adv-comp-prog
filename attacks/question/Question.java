package attacks.question;

import attacks.question.strategies.QuestionStrategy;
import game.IOHandler;

public class Question {
  private final QuestionStrategy strategy;
  private final String question;
  private String[] options;
  private final String answer;

  public Question(QuestionStrategy strategy, String question, String answer) {
    this.strategy = strategy;
    this.question = question;
    this.answer = answer;
  }

  public Question(QuestionStrategy strategy, String question, String[] options, String answer) {
    this.strategy = strategy;
    this.question = question;
    this.options = options;
    this.answer = answer;
  }

  public String askQuestion(IOHandler ioHandler) {
    return strategy.askQuestion(question, options, ioHandler);
  }

  public boolean isCorrect(String playerAnswer) {
    return strategy.isCorrect(question, options, answer, playerAnswer);
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
