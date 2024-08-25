package codechallengesecondstophrase;

public class TimeConverter {
    public String convertSecondsToPhrase(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;

        if (seconds == 0) return "now";
        return minutes + " minute" + ((minutes > 1) ? "s" : "") + " and " + remainingSeconds + " second" + ((remainingSeconds > 1) ? "s" : "");
    }

    public static void main(String[] args) {
        
        System.out.println(new TimeConverter().convertSecondsToPhrase(0));
    }
}