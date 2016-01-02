package bookex.bggng.jee7.ch02;

import org.slf4j.Logger;

import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;

@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    @Override
    public String generateNumber() {
        String mock = "MOCK-" + Math.abs(new Random().nextInt());
        logger.info("Generated Mock : " + mock);
        return mock;
    }
}
