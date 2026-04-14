package attacks.question;

import attacks.question.strategies.QuestionStrategy;
import game.IOHandler;

public class Question {
  private QuestionStrategy strategy;
  private String question;
  private String[] options;
  private String answer;

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
    return strategy.askQuestion(question, options, answer, ioHandler);
  }

  public boolean isCorrect(String player_answer) {
    return strategy.isCorrect(question, options, answer, player_answer);
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
