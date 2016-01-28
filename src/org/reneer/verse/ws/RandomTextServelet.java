package org.reneer.verse.ws;

import java.io.IOException;
import javax.servlet.http.*;
import org.reneer.verse.*;

@SuppressWarnings("serial")
public class RandomTextServelet extends HttpServlet {
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.setContentType("text/html");

        resp.getWriter().println(RandomScriptureVerse.verses());
    }
}
