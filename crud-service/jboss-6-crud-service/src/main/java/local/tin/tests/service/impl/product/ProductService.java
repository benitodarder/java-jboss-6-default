package local.tin.tests.service.impl.product;


import local.tin.tests.dao.impl.ProductDAOFactory;
import local.tin.tests.dao.impl.ProductDAO;
import local.tin.tests.model.domain.exceptions.DAOException;
import local.tin.tests.model.domain.product.Product;
import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public class ProductService {

    private static final Logger LOGGER = Logger.getLogger(ProductService.class);
    private final ProductDAOFactory daoFactory;

    public ProductService(ProductDAOFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public Product doService(Integer productId) throws DAOException {
        long t0 = System.currentTimeMillis();
        Product product;
        try {
            ProductDAO productDAO = (ProductDAO) daoFactory.getDAO(Product.class);
            product = productDAO.retrieve(productId);
        } finally {
            LOGGER.debug("Product retrieved in: " + (System.currentTimeMillis() - t0));
        }
        return product;
    }
 
}
