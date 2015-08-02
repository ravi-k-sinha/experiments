package self.rks.servlet.async;

import javax.annotation.Resource;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns={"/sseasync"}, asyncSupported=true)
public class SSEAsyncServlet extends HttpServlet {

    @Resource
    private ManagedExecutorService managedExecutorService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        // set content type
        res.setContentType("text/event-stream");
        res.setCharacterEncoding("UTF-8");

        final String msg = req.getParameter("msg");

        // start async
        final AsyncContext ac = req.startAsync();

        final PrintWriter writer = res.getWriter();
        Runnable runnable = () -> {
            // echo msg 5 times
            for (int i = 0; i < 5; i++) {
                if (i == 4) { // last
                    // SSE event field
                    writer.write("event: close\n");
                }
                // SSE data field
                // last field with blank new line
                writer.write("data: " + msg + "\n\n");
                writer.flush();

                try {
                    Thread.sleep(2000);
                } catch(InterruptedException iex) {
                    iex.printStackTrace();
                }
            }

            // complete async
            ac.complete();
        };

        // submit the runnable to managedExecutorService
        managedExecutorService.submit(runnable);
    }
}