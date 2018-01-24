
public class Computer extends Player {
   public boolean playAgain() {
      if (getRoundScore() < 20) {
         return true;
      } else {
         return false;
      }
   }
}
