import java.util.Scanner;

public class TestApplication1 {
    private static final String ADMIN_PASSWORD = "1111";

    private static final String[] QUESTIONS = {
            "1. Which modal verb is used to express a strong obligation?\n(a) Must\n(b) Have to\n(c) Should\n(d) Could",
            "2. Which modal verb is used to express a general obligation?\n(a) Must\n(b) Have to\n(c) Should\n(d) Could",
            "3. Which modal verb is used to give advice?\n(a) Must\n(b) Have to\n(c) Should\n(d) Could",
            "4. Which modal verb is used to talk about past obligations?\n(a) Must\n(b) Have to\n(c) Should\n(d) Could",
            "5. Which modal verb is used to talk about possibility or ability in the past?\n(a) Must\n(b) Have to\n(c) Should\n(d) Could"
    };

    private static final String[] ANSWERS = {
            "a",
            "b",
            "c",
            "b",
            "d"
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean isAdmin = false;

        System.out.println("Welcome to the Modal Verbs Test!");

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
