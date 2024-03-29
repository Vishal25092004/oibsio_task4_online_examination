import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class OnlineExamSystem {
    private static String username;
    private static String password;
    private static int timeLeft;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Login
        System.out.println("Welcome to Online Exam System");
        System.out.print("Enter Username: ");
        username = scanner.nextLine();
        System.out.print("Enter Password: ");
        password = scanner.nextLine();

        if (login(username, password)) {
            System.out.println("Login successful!");

            // Update Profile
            System.out.println("Update Profile");
            updateProfile();

            // Take Exam
            System.out.println("Exam Starting...");
            startExam();
        } else {
            System.out.println("Invalid username or password. Exiting...");
        }
    }

    private static boolean login(String username, String password) {
        // Dummy login logic - Replace with actual authentication logic
        return username.equals("admin") && password.equals("admin123");
    }

    private static void updateProfile() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        // Dummy update profile logic - Print the updated profile
        System.out.println("Profile Updated Successfully:");
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
    }

    private static void startExam() {
        // Set a timer for the exam
        timeLeft = 300; // 5 minutes for demo, change as needed
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (timeLeft > 0) {
                    System.out.println("Time Left: " + timeLeft + " seconds");
                    timeLeft--;
                } else {
                    System.out.println("Time's up! Auto-submitting your exam...");
                    submitExam();
                    timer.cancel();
                }
            }
        }, 0, 1000); // Timer ticks every second

        // Dummy MCQs
        System.out.println("Select answers for the following MCQs:");
        System.out.println("1. What is the capital of France?");
        System.out.println("   a) Paris");
        System.out.println("   b) Rome");
        System.out.println("   c) Madrid");
        System.out.println("   d) Berlin");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer (a, b, c, d): ");
        String answer1 = scanner.nextLine();

        System.out.println("2. What is the largest planet in our solar system?");
        System.out.println("   a) Jupiter");
        System.out.println("   b) Saturn");
        System.out.println("   c) Neptune");
        System.out.println("   d) Earth");

        System.out.print("Your answer (a, b, c, d): ");
        String answer2 = scanner.nextLine();

        // Dummy logic to calculate score
        int score = 0;
        if (answer1.equalsIgnoreCase("a")) {
            score++;
        }
        if (answer2.equalsIgnoreCase("a")) {
            score++;
        }

        System.out.println("Exam Completed!");
        System.out.println("Your Score: " + score);

        // Submit the exam
        submitExam();
    }

    private static void submitExam() {
        System.out.println("Exam Submitted Successfully!");
        System.out.println("Closing session...");

        // Logout
        logout();
    }

    private static void logout() {
        System.out.println("Logout successful. Goodbye!");
        System.exit(0);
    }
}
