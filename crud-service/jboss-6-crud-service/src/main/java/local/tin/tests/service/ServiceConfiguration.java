package local.tin.tests.service;

import java.util.HashMap;
import java.util.Map;
import local.tin.tests.service.abstracts.AbstractServiceConfiguration;

import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class ServiceConfiguration extends AbstractServiceConfiguration {
    
    private static final Logger LOGGER = Logger.getLogger(ServiceConfiguration.class);    
    private static final Object LOCK = new Object();
    private static boolean initialized = false;
    private static Map<String, String> configurationMap;
    
    private ServiceConfiguration() {
    }
    
    public static ServiceConfiguration getInstance() {
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

    @Override
    public Map<String, String> getConfigurationMap() {
        return configurationMap;
    }

    @Override
    public Logger getLogger() {
        return LOGGER;
    }


    
    private static class DAOConfigurationConfigurationHolder {

        private static final ServiceConfiguration INSTANCE = new ServiceConfiguration();
        
        private DAOConfigurationConfigurationHolder() {}
    }

      
}
