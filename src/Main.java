import java.util.Objects;
import java.util.Scanner;
public class Main {
    static int origin = 0;
    static int bound = 100;
    static int attempts = 10;
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Guess the Number Game!");
        welcomeMessage();

    }

    public static void welcomeMessage() {
        System.out.println("\n");
        System.out.println("1. Start a new game.");
        System.out.println("2. Change origin (0).");
        System.out.println("3. Change bound (100).");
        System.out.println("4. Change attempts amount (10).");
        System.out.println("5. Quit.");
        System.out.println("\n");

        int response = Integer.parseInt(scanner.nextLine());
        gameLoop(response);
    }

    public static void gameLoop(int response) {
        // this is where the actual game play will happen!
        switch (response) {
            case 1:
                System.out.printf("Guess the number between %d and %d.\n", origin, bound);
                System.out.printf("%d attempts left.\n", attempts);

                for (int i = attempts; i > 0; i--) {
                    int currNumber = Integer.parseInt(scanner.nextLine());
                    int randomInt = origin + (int) (Math.random() * (bound - origin));
                    if (currNumber == randomInt) {
                        System.out.printf("You won! computer selected: %d and u selected: %d\n", randomInt, currNumber);
                        welcomeMessage();
                        break;
                    } else if (currNumber < randomInt) {
                        --attempts;
                        System.out.printf("The number (%d) is greater than yours!\n", randomInt);
                        System.out.printf("%d attempts left.\n", i-1);
                    } else {
                        System.out.printf("The number (%d) is less than yours!\n", randomInt);
                        System.out.printf("%d attempts left.\n", i-1);
                    }
                }
                System.out.println("Would you like to play again, (Yes or No)?");
                String answer = scanner.nextLine();
                if (Objects.equals(answer.toLowerCase(), "yes") || Objects.equals(answer.toLowerCase(), "y")) {
                    startNewGame();
                } else {
                    gameLoop(5);
                }
            case 2:
                // change the origin and start the game from beginning!
                System.out.println("Enter new origin you would like: ");
                origin = Integer.parseInt(scanner.nextLine());
                startNewGame();
                break;
            case 3:
                System.out.println("Enter the new bound: ");
                bound = Integer.parseInt(scanner.nextLine());
                startNewGame();
                break;
            case 4:
                System.out.println("Enter the new amount of attempts: ");
                attempts = Integer.parseInt(scanner.nextLine());
                startNewGame();
                break;
            case 5:
                System.out.println("Thank you for playing!");
                break;
            default:
                // nothing for now!
        }
    }

    public static void startNewGame() {
        gameLoop(1);
    }

}
