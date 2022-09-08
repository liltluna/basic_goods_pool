
import javax.servlet.*;

public class DBListener implements ServletContextListener{
    public void contextInitialized(ServletContextEvent event){
        // code to initialize the database connection.
        // and store it as a context attribute.
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
        // code to close the database connection.
        
    }
}