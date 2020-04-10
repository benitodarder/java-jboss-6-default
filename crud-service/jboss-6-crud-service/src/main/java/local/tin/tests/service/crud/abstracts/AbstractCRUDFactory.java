package local.tin.tests.service.crud.abstracts;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import local.tin.tests.dao.impl.AbstractDAO;
import local.tin.tests.dao.impl.AbstractDAOFactory;
import local.tin.tests.model.domain.exceptions.DAOException;
import local.tin.tests.model.domain.exceptions.ServiceException;
import local.tin.tests.service.abstracts.AbstractServiceConfiguration;

import org.apache.log4j.Logger;

/**
 *
 * @author benito.darder
 */
public abstract class AbstractCRUDFactory {

    private final AbstractDAOFactory baseDAOFactory;
    private final AbstractServiceConfiguration baseServiceConfiguration;

    protected AbstractCRUDFactory(AbstractDAOFactory baseDAOFactory, AbstractServiceConfiguration baseServiceConfiguration) {
        this.baseDAOFactory = baseDAOFactory;
        this.baseServiceConfiguration = baseServiceConfiguration;
    }

    protected abstract Logger getLogger(); 

    public AbstractCRUD getCRUD(Class klass) throws ServiceException {
        try {
            String crudFullName = getCRUDFullName(klass);
            Class<?> daoClass = Class.forName(crudFullName);
            Constructor<?> constructor = daoClass.getDeclaredConstructor(AbstractDAO.class);
            AbstractDAO abstractDAO = baseDAOFactory.getDAO(klass);
            return (AbstractCRUD) constructor.newInstance(abstractDAO);
        } catch (DAOException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException | NoSuchMethodException | SecurityException | ClassNotFoundException ex) {
            throw new ServiceException("Could not instantiate CRUD for class: " + klass.getSimpleName(), ex);
        }
    }

    private String getCRUDFullName(Class klass) throws ServiceException {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(baseServiceConfiguration.getCRUDBasePackage()).append(".").append(klass.getSimpleName());
        return stringBuilder.toString();
    }
    
    public AbstractCRUD getCRUD(String className) throws ServiceException {
        Class klass;
        try {
            klass = Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new ServiceException("Could not instantiate CRUD for class: " + className, ex);
        }
        return getCRUD(klass);
    }    
}
