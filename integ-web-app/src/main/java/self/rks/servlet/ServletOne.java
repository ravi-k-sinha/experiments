package self.rks.servlet;

import self.rks.util.DummyUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletOne extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        DummyUtil.getDummyName();

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("<h1>Hello</h1>");
        out.println("<h2>");
        out.println("The value from DummyUtil.getDummyName() is " + DummyUtil.getDummyName());
        out.println("<h2>");
        out.println("</body>");
        out.println("</html>");

    }
}
