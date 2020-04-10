package local.tin.tests.service.impl.product;

import local.tin.tests.dao.impl.ProductDAOFactory;
import local.tin.tests.model.domain.exceptions.DAOException;



/**
 *
 * @author benito.darder
 */
public class ServiceFactory {
    
    private ServiceFactory() {
    }
    
    public static ServiceFactory getInstance() {
        return ServiceFactoryHolder.INSTANCE;
    }
    
    private static class ServiceFactoryHolder {

        private static final ServiceFactory INSTANCE = new ServiceFactory();
    }
    
    public ProductService newConfigurationService() throws DAOException {
        ProductService configurationService = new ProductService(ProductDAOFactory.getInstance());
        return configurationService;
    }
}
