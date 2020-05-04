package local.tin.tests.service.crud.impl;

import local.tin.tests.dao.impl.AbstractDAO;
import local.tin.tests.service.crud.abstracts.AbstractCRUD;



/**
 *
 * @author benito.darder
 */
public class Component extends AbstractCRUD<local.tin.tests.model.domain.product.Component> {
    
    public Component(AbstractDAO dao) {
        super(dao);
    }
    
}
