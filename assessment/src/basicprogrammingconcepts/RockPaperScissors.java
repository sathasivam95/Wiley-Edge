import java.util.Random;
import java.util.Scanner;

public final class RockPaperScissors {

    public static void overallResults(int tie, int wins, int loss) {

        System.out.println("----------------------------------------------------");
        System.out.println("Player Wins: " + wins+ " Computer Wins: " + loss+ " Ties: " + tie);
        System.out.println("----------------------------------------------------");

        if (wins > loss) {
            System.out.println("Overall Winner: Player!");
        } else if (loss > wins) {
            System.out.println("Overall Winner: Computer!");
        } else {
            System.out.println("Overall Winner: Its a Tie!");
        }
    }
    public static void main(final String[] arg) {

        String playAgain;
        int rounds;
        int playerMove;
        int computerMove;
        boolean game = true;

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        while(game) {

            int tie = 0;
            int wins = 0;
            int loss = 0;

            System.out.println("---------------Rock---Paper---Scissors--------------");
            System.out.print("How many rounds do you want to play? (1-10): ");
            rounds = sc.nextInt();

            if (rounds < 1 || rounds >= 10) {
                System.out.println("Invalid!");
                break; // break the program if it's out of range
            }

            for (int i = 1; i <= rounds; i++) {

                System.out.println("----------------------------------------------------");
                System.out.println("Round: " + i);
                System.out.println("Select (0) Rock " + "(1) Paper " + "(2) Scissors ");
                System.out.println("----------------------------------------------------");
                // player move
                System.out.print("Enter your move: ");
                playerMove = sc.nextInt();

                // Invalid Move Only
                while (!(playerMove == 0 || playerMove == 1 || playerMove == 2)) {
                    System.out.println("Invalid Input!");
                    System.out.println("Select (0) Rock " + "(1) Paper " + "(2) Scissors ");
                    playerMove = sc.nextInt();
                }
                    computerMove = random.nextInt(3);
                    // playerMove compares with computerMove
                    // player's perspective
                    if (computerMove == playerMove) {
                        switch (computerMove) {
                            case 0:
                                System.out.println("Computer plays: Rock");
                                break;
                            case 1:
                                System.out.println("Computer plays: Paper");
                                break;
                            case 2:
                                System.out.println("Computer plays: Scissors");
                                break;
                        }
                        System.out.println("Its a tie!");
                        tie += 1;
                    } else if (computerMove == 0) {
                        System.out.println("Computer plays: Rock");
                        if (playerMove == 1) {
                            // paper wins rock
                            System.out.println("Player wins");
                            wins += 1;
                        } else {
                            // rocks wins scissors
                            System.out.println("Computer wins");
                            loss += 1;
                        }
                    } else if (computerMove == 1) {
                        System.out.println("Computer plays: Paper");
                        if (playerMove == 2) {
                            System.out.println("Player wins");
                            wins += 1;
                        } else {
                            System.out.println("Computer wins");
                            loss += 1;
                        }
                    }
                    // computer plays scissors
                    else {
                        System.out.println("Computer plays: Scissors");
                        if (playerMove == 0) {
                            System.out.println("Player wins");
                            wins += 1;
                        } else {
                            System.out.println("Computer wins");
                            loss += 1;
                        }
                    }
                }

                // call function
                overallResults(tie, wins, loss);
                System.out.println("----------------------------------------------------");
                System.out.println("Do you want to play again? Yes/No");
                playAgain = sc.next();

                if (playAgain.equals("NO") || playAgain.equals("no")) {
                    System.out.print("Thanks for playing!");
                    game = false;
                }
        }
    }
}



