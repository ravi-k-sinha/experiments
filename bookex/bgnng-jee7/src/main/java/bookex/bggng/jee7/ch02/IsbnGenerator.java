package bookex.bggng.jee7.ch02;

import org.slf4j.Logger;

import javax.inject.Inject;
import java.util.Random;

@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

    @Inject
    private Logger logger;

    @Loggable
    @Override
    public String generateNumber() {
        String isbn = "13-84356" + Math.abs(new Random().nextInt());
        logger.info("Generated ISBN : " + isbn);
        return isbn;
    }
}
