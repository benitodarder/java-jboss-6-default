package local.tin.tests.service.crud.abstracts;

import java.util.ArrayList;
import java.util.Collection;
import local.tin.tests.dao.impl.AbstractDAO;
import local.tin.tests.model.domain.abstracts.AbstractIdentifiable;
import local.tin.tests.model.domain.exceptions.DAOException;
import local.tin.tests.model.domain.exceptions.ServiceException;

/**
 *
 * @author benito.darder
 * @param <C>
 */
public abstract class AbstractCRUD<C extends AbstractIdentifiable> {

    private final AbstractDAO dao;

    public AbstractCRUD(AbstractDAO dao) {
        this.dao = dao;
    }

    public C create(C c) throws ServiceException {
        C result = null;
        try {
            result = (C) dao.create(c);
        } catch (DAOException ex) {
            throw new ServiceException("Could not create: " + ex.getLocalizedMessage(), ex);
        }
        return result;
    }

    public C retrieve(Object id) throws ServiceException {
        try {
            return (C) dao.retrieve(id);
        } catch (DAOException ex) {
            throw new ServiceException("Could not update: " + ex.getLocalizedMessage(), ex);
        }
    }

    public C update(C c) throws ServiceException {
        C result = null;
        try {
            result = (C) dao.update(c);
        } catch (DAOException ex) {
            throw new ServiceException("Could not update: " + ex.getLocalizedMessage(), ex);
        }
        return result;
    }

    public void delete(C c) throws ServiceException {
        try {
            dao.delete(c);
        } catch (DAOException ex) {
            throw new ServiceException("Could not delete: " + ex.getLocalizedMessage(), ex);
        }
    }

    public Collection<C> retrieveAll() throws ServiceException {
        Collection<C> result = new ArrayList<>();
        try {
            result = dao.retrieveAll();
        } catch (DAOException ex) {
            throw new ServiceException("Could not retrieve: " + ex.getLocalizedMessage(), ex);
        }
        return result;
    }

}
