
public class Human extends Player {
   public boolean playAgain() {
      System.out.print("Do you want to play again? (y/n)");
      answer = scan.next();
      if(answer.equalsIgnoreCase("y")){
         return true;
      }
      else{
         return false;
      }
   }
}
