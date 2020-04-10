package local.tin.tests.service.crud.impl;

import local.tin.tests.dao.impl.AbstractDAO;
import local.tin.tests.service.crud.abstracts.AbstractCRUD;



/**
 *
 * @author benito.darder
 */
public class Assembly extends AbstractCRUD<local.tin.tests.model.domain.product.Assembly> {
    
    public Assembly(AbstractDAO dao) {
        super(dao);
    }
    
}
