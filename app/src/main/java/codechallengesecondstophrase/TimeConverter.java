package codechallengesecondstophrase;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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
    
        List<String> timeParts = new ArrayList<>();
    
        if (years > 0) {
            timeParts.add(years + " year" + (years > 1 ? "s" : ""));
        }
        if (months > 0) {
            timeParts.add(months + " month" + (months > 1 ? "s" : ""));
        }
        if (days > 0) {
            timeParts.add(days + " day" + (days > 1 ? "s" : ""));
        }
        if (hours > 0) {
            timeParts.add(hours + " hour" + (hours > 1 ? "s" : ""));
        }
        if (minutes > 0) {
            timeParts.add(minutes + " minute" + (minutes > 1 ? "s" : ""));
        }
        if (remainingSeconds > 0) {
            timeParts.add(remainingSeconds + " second" + (remainingSeconds > 1 ? "s" : ""));
        }
    
        if (timeParts.isEmpty()) {
            return "now";
        } else {
            if (timeParts.size() == 1) {
                return timeParts.get(0);
            }
            String lastPart = timeParts.remove(timeParts.size() - 1);
            return String.join(", ", timeParts) + " and " + lastPart;
        }
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