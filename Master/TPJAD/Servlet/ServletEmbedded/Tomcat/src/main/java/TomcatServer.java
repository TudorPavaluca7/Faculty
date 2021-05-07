import Servlets.*;
import Servlets.Error;
import org.apache.catalina.Context;
import org.apache.catalina.startup.Tomcat;

import java.io.File;

public class TomcatServer {
    public static void main(String[] args) throws Exception {
        Tomcat server = new Tomcat();
        server.setPort(8081);
        Context ctx = server.addContext("", (new File(".")).getAbsolutePath());
        Tomcat.addServlet(ctx, "index", new Index());
        Tomcat.addServlet(ctx, "start", new StartServlet());
        Tomcat.addServlet(ctx, "game", new GameServlet());
        Tomcat.addServlet(ctx, "win", new Win());
        Tomcat.addServlet(ctx, "lose", new Lose());
        Tomcat.addServlet(ctx, "error", new Error());

        ctx.addServletMappingDecoded("","index");
        ctx.addServletMappingDecoded("/start-game","start");
        ctx.addServletMappingDecoded("/game-servlet","game");
        ctx.addServletMappingDecoded("/win","win");
        ctx.addServletMappingDecoded("/lose","lose");
        ctx.addServletMappingDecoded("/error","error");
        server.start();
        System.out.println("Start server Tomcat embedded");
        server.getServer().await();

    }
}
