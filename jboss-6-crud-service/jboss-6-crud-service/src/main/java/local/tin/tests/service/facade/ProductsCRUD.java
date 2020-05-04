package local.tin.tests.service.facade;

import javax.ws.rs.Path;
import local.tin.tests.service.ServiceConfiguration;
import local.tin.tests.service.crud.impl.ProductCRUDFactory;
import local.tin.tests.service.facade.abstracts.AbstractCRUDFacade;


/**
 *
 * @author benito.darder
 */
@Path("/crud")
public class ProductsCRUD extends AbstractCRUDFacade {

    public ProductsCRUD() {
        super(ServiceConfiguration.getInstance(), ProductCRUDFactory.getInstance());
    }

    
}
