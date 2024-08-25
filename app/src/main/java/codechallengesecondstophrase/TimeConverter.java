package codechallengesecondstophrase;

import java.util.Scanner;

public class TimeConverter {
    public static String convertSecondsToPhrase(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        if (seconds == 0) return "now";
        return minutes + " minute" + ((minutes > 1) ? "s" : "") + " and " + remainingSeconds + " second" + ((remainingSeconds > 1) ? "s" : "");
    }

    public static void main(String[] args) {
        
        try (Scanner scanner = new Scanner(System.in)) {
            int seconds = -1;

            while (seconds < 0) {
                System.out.println("Please enter a number of seconds (0 or positive): ");
                if (scanner.hasNextInt()) {
                    seconds = scanner.nextInt();
                    if(seconds < 0) {
                        System.out.println("The number must be zero or positive. Please try again.");
                    }
                }else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }
            }

            String timePhrase = convertSecondsToPhrase(seconds);
            System.out.println("Time in phrase format: " + timePhrase);
        }
    }
}