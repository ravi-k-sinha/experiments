package self.rks.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns={"/simplesse"})
public class SSEEchoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws IOException, ServletException {

        // set content type
        res.setContentType("text/event-stream");
        res.setCharacterEncoding("UTF-8");

        String msg = req.getParameter("msg");
        System.out.println("Received another message");

        PrintWriter writer = res.getWriter();

        // send SSE
        writer.write("retry: 10000\n");
        writer.write("data: " + msg + "\n");
        writer.write("data: echoed\n\n");
    }
}
