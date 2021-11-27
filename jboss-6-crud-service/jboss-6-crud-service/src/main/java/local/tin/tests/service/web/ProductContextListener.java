package local.tin.tests.service.web;

import java.io.IOException;
import java.util.Properties;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import local.tin.tests.dao.ProductDAOConfiguration;
import local.tin.tests.service.ServiceConfiguration;
import local.tin.tests.service.utils.ResourcesUtils;

import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class ProductContextListener implements ServletContextListener {

    public static final String COULD_NOT_LOAD_CONFIGURATIONSERVICEPROPER = "Could not load configuration-service.properties: ";
    private static final Logger LOGGER = Logger.getLogger(ProductContextListener.class);
    
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        try {
            LOGGER.info("ProductContextListener: Context initialized!");
            Properties properties = ResourcesUtils.getInstance().getPropertiesFile(ProductContextListener.class, "products-service.properties");
            ProductDAOConfiguration.getInstance().setDAOBasePackage(properties.getProperty(ProductDAOConfiguration.DAO_BASE_PACKAGE));
            ProductDAOConfiguration.getInstance().setPersistenceUnit(properties.getProperty(ProductDAOConfiguration.DAO_PERSISTENCE_UNIT));            
            ServiceConfiguration.getInstance().setCRUDBasePackage(properties.getProperty(ServiceConfiguration.CRUD_BASE_PACKAGE));
            ServiceConfiguration.getInstance().setModelDomainPackage(properties.getProperty(ServiceConfiguration.MODEL_DOMAIN_PACKAGE));
        } catch (IOException ex) {
            LOGGER.error(COULD_NOT_LOAD_CONFIGURATIONSERVICEPROPER + ex.getLocalizedMessage());
            LOGGER.debug(COULD_NOT_LOAD_CONFIGURATIONSERVICEPROPER, ex);
        } 
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOGGER.info("ProductContextListener: Context destroyed!");
    }
}
