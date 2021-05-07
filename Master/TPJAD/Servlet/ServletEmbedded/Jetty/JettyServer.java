import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;

public class JettyServer {

    public static void main(String[] args) throws Exception {

        Server server = new Server(8082);
        ServletContextHandler handler = new ServletContextHandler(ServletContextHandler.SESSIONS);
        server.setHandler(handler);
        handler.addServlet(Servlets.Index.class, "");
        handler.addServlet(Servlets.StartServlet.class, "/start-game");
        handler.addServlet(Servlets.GameServlet.class, "/game-servlet");
        handler.addServlet(Servlets.Win.class, "/win");
        handler.addServlet(Servlets.Lose.class, "/lose");
        handler.addServlet(Servlets.Error.class, "/error");

        System.out.println("Start server jetty embedded");
        server.start();
        server.join();

    }
}
