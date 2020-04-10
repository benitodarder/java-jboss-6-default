package local.tin.tests.dao;

import java.util.HashMap;
import java.util.Map;
import local.tin.tests.dao.AbstractDAOConfiguration;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class ProductDAOConfiguration extends AbstractDAOConfiguration {
    
    private static final Logger LOGGER = Logger.getLogger(ProductDAOConfiguration.class);    
    private static final Object LOCK = new Object();
    private static boolean initialized = false;
    private static Map<String, String> configurationMap;
    
    private ProductDAOConfiguration() {
    }
    
    public static ProductDAOConfiguration getInstance() {
        if (!initialized) {
            synchronized (LOCK) {
                if (!initialized) {
                    configurationMap = new HashMap<>();
                    initialized = true;
                }
            }
        }        
        return DAOConfigurationConfigurationHolder.INSTANCE;
    }

    private static class DAOConfigurationConfigurationHolder {

        private static final ProductDAOConfiguration INSTANCE = new ProductDAOConfiguration();
        
        private DAOConfigurationConfigurationHolder() {}
    }
  
    @Override
    public Map<String, String> getConfigurationMap() {
        return configurationMap;
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }
    
}
