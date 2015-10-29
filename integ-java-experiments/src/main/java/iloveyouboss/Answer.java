package iloveyouboss;

public class Answer {
   private int index;
   private Question question;

   public Answer(Question question, int index) {
      this.question = question;
      this.index = index;
   }

   public Answer(Question question, String matchingValue) {
      this.question = question;
      this.index = question.indexOf(matchingValue);
   }
   
   public String getQuestionText() {
      return question.getText();
   }

   @Override
   public String toString() {
      return String.format("%s %s", question.getText(), question.getAnswerChoice(index));
   }

   public boolean match(int expected) {
      return question.match(expected, index);
   }

   public boolean match(Answer otherAnswer) {
      return question.match(index, otherAnswer.index);
   }

   public Question getQuestion() {
      return question;
   }
}