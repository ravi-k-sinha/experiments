package bookex.bggng.jee7.ch02;

import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.Random;

@EightDigits
public class IssnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    @Override
    public String generateNumber() {
        String issn = "8-" + Math.abs(new Random().nextInt());
        logger.info("Generated ISSN : " + issn);
        return issn;
    }
}
