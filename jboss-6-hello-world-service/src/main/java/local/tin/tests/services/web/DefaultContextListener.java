package local.tin.tests.services.web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class DefaultContextListener implements ServletContextListener {

    private static final Logger LOGGER = Logger.getLogger(DefaultContextListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOGGER.info("configuration-service: Context initialized!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("configuration-service: Context destroyed!");
    }
}
