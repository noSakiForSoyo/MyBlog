import javax.servlet.FilterChain;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class listenerTest implements ServletContextListener {
    private static int people;
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("");
        people++;
        System.out.println(people);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }
}
