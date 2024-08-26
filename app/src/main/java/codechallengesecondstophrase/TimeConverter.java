package codechallengesecondstophrase;

import java.util.Scanner;

public class TimeConverter {
    public String convertSecondsToPhrase(int seconds) {
        int years = seconds / (365 * 24 * 60 * 60);
        seconds %= 365 * 24 * 60 * 60;

        int months = seconds / (30 * 24 * 60 * 60);
        seconds %= 30 * 24 * 60 * 60;

        int days = seconds / (24 * 60 * 60);
        seconds %= 24 * 60 * 60;

        int hours = seconds / (60 * 60);
        seconds %= 60 * 60;

        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        StringBuilder result = new StringBuilder();

        if (years > 0) {
            result.append(years).append(" year").append(years > 1 ? "s" : "");
        }
        if (months > 0) {
            if (result.length() > 0)
                result.append(", ");
            result.append(months).append(" month").append(months > 1 ? "s" : "");
        }
        if (days > 0) {
            if (result.length() > 0)
                result.append(", ");
            result.append(days).append(" day").append(days > 1 ? "s" : "");
        }
        if (hours > 0) {
            if (result.length() > 0)
                result.append(", ");
            result.append(hours).append(" hour").append(hours > 1 ? "s" : "");
        }
        if (minutes > 0) {
            if (result.length() > 0)
                result.append(", ");
            result.append(minutes).append(" minute").append(minutes > 1 ? "s" : "");
        }
        if (remainingSeconds == 0 && result.length() == 0) {
            result.append("now");
        }
        if (remainingSeconds > 0 || result.length() == 0) {
            if (result.length() > 0)
                result.append(" and ");
            result.append(remainingSeconds).append(" second").append(remainingSeconds > 1 ? "s" : "");
        }
        
        return result.toString();
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            int seconds = -1;

            while (seconds < 0) {
                System.out.println("Please enter a number of seconds (0 or positive): ");
                if (scanner.hasNextInt()) {
                    seconds = scanner.nextInt();
                    if (seconds < 0) {
                        System.out.println("The number must be zero or positive. Please try again.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a valid number.");
                    scanner.next();
                }
            }

            String timePhrase = new TimeConverter().convertSecondsToPhrase(seconds);
            System.out.println("Time in phrase format: " + timePhrase);
        }
    }
}