import java.util.Scanner;

public class TestApplication {
    private static final String ADMIN_PASSWORD = "1111";

    private static final String[] QUESTIONS = {
            "1. What time ___ you usually get up?\n(a) do\n(b) does\n(c) did\n(d) are",
            "2. My sister ___ to music every day.\n(a) listen\n(b) listens\n(c) listened\n(d) listening",
            "3. He ___ coffee in the morning.\n(a) drink\n(b) drinks\n(c) drank\n(d) drinking",
            "4. They ___ tennis every Sunday.\n(a) play\n(b) plays\n(c) played\n(d) playing",
            "5. ___ you like ice cream?\n(a) Are\n(b) Do\n(c) Did\n(d) Does"
    };

    private static final String[] ANSWERS = {
            "b",
            "b",
            "b",
            "a",
            "b"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isAdmin = false;

        System.out.println("Welcome to the Present Simple Test!");

        while (true) {
            System.out.println("Please enter 's' to start the test or 'q' to quit:");

            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                break;
            } else if (input.equalsIgnoreCase("s")) {
                int score = startTest(scanner);
                double percentage = (double) score / QUESTIONS.length * 100;
                System.out.println("Your score: " + score + "/" + QUESTIONS.length + " (" + percentage + "%)");
            } else if (input.equalsIgnoreCase("admin")) {
                System.out.println("Enter the admin password:");
                String password = scanner.nextLine();
                if (password.equals(ADMIN_PASSWORD)) {
                    isAdmin = true;
                    System.out.println("Admin mode activated.");
                } else {
                    System.out.println("Incorrect password. Access denied.");
                }
            } else if (isAdmin && input.equalsIgnoreCase("view answers")) {
                System.out.println("Correct answers:");
                for (int i = 0; i < QUESTIONS.length; i++) {
                    System.out.println(QUESTIONS[i] + "\nCorrect answer: " + ANSWERS[i]);
                }
            } else {
                System.out.println("Invalid input. Please try again.");
            }
        }
    }

    private static int startTest(Scanner scanner) {
        int score = 0;

        for (int i = 0; i < QUESTIONS.length; i++) {
            System.out.println(QUESTIONS[i]);
            String answer = scanner.nextLine();

            if (answer.equalsIgnoreCase(ANSWERS[i])) {
                score++;
            } else if (answer.equalsIgnoreCase("q")) {
                break;
            } else {
                System.out.println("Incorrect answer.");
            }
        }

        return score;
    }
}
