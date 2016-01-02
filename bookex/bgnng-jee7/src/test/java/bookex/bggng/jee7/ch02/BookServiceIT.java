package bookex.bggng.jee7.ch02;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class BookServiceIT {

    @Test
    public void shouldCheckNumberIsMOCK() {

        Weld weld = new Weld();
        WeldContainer container = weld.initialize();
        BookService service = container.instance().select(BookService.class).get();
        Book book = service.createBook("H2G2", 12.5f, "Geeky Scifi Book");

        assertTrue(book.getNumber().startsWith("MOCK"));

        weld.shutdown();
    }
}
