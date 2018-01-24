import java.util.*;

/**
 * Player class
 * 
 * @author Nick Bishop
 *
 */
public abstract class Player {
   int dieOne, dieTwo;
   int totalScore = 0;
   int roundScore = 0;
   String answer = "";
   private boolean playAgain;
   Scanner scan = new Scanner(System.in);

   /**
    * Constructor
    */
   public Player() {
      playAgain = true;
   }

   public int getRoundScore() {
      return roundScore;
   }

   /**
    * Rolls two dice, stores then prints out the values
    * 
    * @return The dice values
    */
   private void roll() {
      dieOne = (int) (Math.random() * 6 + 1);
      dieTwo = (int) (Math.random() * 6 + 1);
      System.out.print("A " + dieOne + " and a " + dieTwo + " were rolled.\t");
   }

   public abstract boolean playAgain();

   /**
    * Takes two die rolls and returns round score; If two ones, resets all
    * scores to 0; If one one, resets round score to 0
    * 
    * @param a
    *           The first die
    * @param b
    *           The second die
    * @return The cumulative round score
    */
   private void computeRoundScore(int a, int b) {
      if (dieOne == 1 && dieTwo == 1) {
         roundScore = 0;
         totalScore = 0;
         playAgain = false;
         System.out.print("Sorry, you lost all of your points\t");
      } else if (dieOne == 1 || dieTwo == 1) {
         roundScore = 0;
         playAgain = false;
         System.out
               .print("Sorry, you lost all of your points for that round\t");
      } else {
         roundScore += (a + b);
      }
      System.out.println("Round score: " + roundScore);
   }

   /**
    * Main play method
    * 
    * @return The total score at the end of turn
    */
   public int play() {
      roundScore = 0;
      playAgain = true;
      System.out.println("Score at start of turn: " + totalScore + "\n");
      while (playAgain) {
         roll();
         computeRoundScore(dieOne, dieTwo);
         if (roundScore != 0)
            playAgain = playAgain();
      }
      totalScore += roundScore;
      System.out.println("\nScore at end of turn: " + totalScore);
      return totalScore;
   }
}