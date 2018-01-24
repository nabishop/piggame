/**
 * Contains the main method for the game of PIG. Repeatedly plays the human
 * player followed by the computer player until someone wins the game.
 */
public class PigGame {
    public static void main(String[] args) {
        int score1 = 0;
        int score2 = 0;
        Player p1 = new Human();
        Player p2 = new Computer();
        while (score1 < 100 && score2 < 100) {
            System.out.println(
                    "\n**********************Your turn!**********************");
            score1 = ((Human) p1).play();
            if (score1 < 100) {
                System.out.println("\n" + "**********************Computer's"
                        + " turn!**********************");
                score2 = ((Computer) p2).play();
            }
        }
        System.out.println(" Thanks for playing. Game over.");
    }
}
