//package nodBotirov.Production;
//
//import java.util.Random;
//import java.util.Scanner;
//
//
//public class Main {
//    public static void main(String[] args) {
//        System.out.println(" Rock Paper Scissors Game!");
//
//        Scanner input = new Scanner(System.in);
//        Random random = new Random();
//
//        while (true) {
//
//
//            int userScore = 0;
//            int computerScore = 0;
//
//            for (int round = 1; round <= 5; round++) {
//
//
//                System.out.println("\n=== Round " + round + " ===");
//                System.out.println("1 = Rock");
//                System.out.println("2 = Paper");
//                System.out.println("3 = Scissors");
//
//                System.out.print("Choose: ");
//                int userChoice = input.nextInt();
//
//                if (userChoice < 1 || userChoice > 3) {
//                    System.out.println("Invalid choice!");
//                    round--;
//                    continue;
//                }
//
//                int computerChoice = random.nextInt(3) + 1;
//
//                String userWord = convert(userChoice);
//                String computerWord = convert(computerChoice);
//
//                System.out.println("You chose: " + userWord);
//                System.out.println("Computer chose: " + computerWord);
//
//                if (userChoice == computerChoice) {
//                    System.out.println("Draw!");
//                } else if ((userChoice == 1 && computerChoice == 3) ||
//                        (userChoice == 2 && computerChoice == 1) ||
//                        (userChoice == 3 && computerChoice == 2)) {
//
//                    System.out.println("You Win This Round!");
//                    userScore++;
//                } else {
//                    System.out.println("Computer Win This Round!");
//                    computerScore++;
//                }
//
//                System.out.println("Score: you " + userScore + " - " + computerScore + " Computer");
//            }
//
//                System.out.println("\n=== Final Result ===");
//
//                if (userScore > computerScore) {
//                    System.out.println("\uD83C\uDF89 You Won The Game!");
//                }
//                else if (computerScore > userScore) {
//                    System.out.println("\uD83D\uDCBB Computer Won The Game!");
//                }
//                else {
//                    System.out.println("🤝 Overall Draw!");
//                }
//
//                System.out.println("\nDo you want to play again? (y/n): ");
//                char again = input.next().charAt(0);
//
//                if (again != 'y' && again != 'Y') {
//                    System.out.println("Thanks for playing!");
//                    break;
//                }
//            }
//        }
//
//
//    //Method (clean code)
//    private static String convert(int userChoice) {
//        if (userChoice == 1) return "Rock";
//        else if (userChoice == 2) return "Paper";
//        else return "Scissors";
//    }
//}