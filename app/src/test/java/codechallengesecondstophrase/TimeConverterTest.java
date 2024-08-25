package codechallengesecondstophrase;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class TimeConverterTest {

    @Test
    void testConvertSecondsToPhrase() {
        assertEquals("now", new TimeConverter().convertSecondsToPhrase(0));
        assertEquals("1 minute and 2 seconds", new TimeConverter().convertSecondsToPhrase(62));
        // assertEquals("1 minute", new TimeConverter().convertSecondsToPhrase(60));
        // assertEquals("2 minutes", new TimeConverter().convertSecondsToPhrase(120));
    }
}
