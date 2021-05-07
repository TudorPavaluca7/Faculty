package com.example.EjbJpaLab.Util;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Utils {

    public static void displayError(HttpServletResponse resp, int errorType) throws IOException
    {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html><head><title>Error</title></head>");
        if (errorType==1)
            out.println("<body><h2>Please fill out all the fields</h2>");
        else if (errorType==2)
            out.println("<body><h2>The user name or password is incorrect</h2>");
        else
            out.println("<body><h2>The chosen book doesn't exist</h2>");
        out.println("</body>");
        out.println("</html>");
    }

}
