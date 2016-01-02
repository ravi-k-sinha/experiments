package bookex.bggng.jee7.ch02;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {

    public static void main(String[] args) {
        Weld weld = new Weld();
        WeldContainer container = weld.initialize();

        BookService bookService = container.instance().select(BookService.class).get();

        Book book = bookService.createBook("H2G2", 12.5f, "Geeky Sci-Fi Book");
        System.out.println(book);
        weld.shutdown();
    }
}
