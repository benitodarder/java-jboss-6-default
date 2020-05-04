package local.tin.tests.service.crud.impl;

import local.tin.tests.dao.impl.ProductDAOFactory;
import local.tin.tests.service.ServiceConfiguration;
import local.tin.tests.service.crud.abstracts.AbstractCRUDFactory;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class ProductCRUDFactory extends AbstractCRUDFactory {

    private static final Logger LOGGER = Logger.getLogger(ProductCRUDFactory.class);

    private ProductCRUDFactory() {
        super(ProductDAOFactory.getInstance(), ServiceConfiguration.getInstance());
    }

    public static ProductCRUDFactory getInstance() {
        return CRUDFactoryHolder.INSTANCE;
    }

    @Override
    protected Logger getLogger() {
        return LOGGER;
    }

    private static class CRUDFactoryHolder {

        private static final ProductCRUDFactory INSTANCE = new ProductCRUDFactory();
    }
   
}
