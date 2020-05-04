package local.tin.tests.service.abstracts;

import local.tin.tests.model.domain.exceptions.ServiceException;
import local.tin.tests.services.configuration.AbstractConfiguration;
/**
 *
 * @author benito.darder
 */
public abstract class AbstractServiceConfiguration extends AbstractConfiguration {
    
    public static final String CRUD_BASE_PACKAGE = "crud.base.package";    
    public static final String MODEL_DOMAIN_PACKAGE = "model.domain.package";    

    /**
     * Set model domain package string to (un)marshal classes
     *
     * @param modelDomainPackage
     */    
    public void setModelDomainPackage(String modelDomainPackage) {
        getConfigurationMap().put(MODEL_DOMAIN_PACKAGE, modelDomainPackage);
    }
    
    /**
     * Get base package string to (un)marshal classes
     *
     * @return String
     * @throws local.tin.tests.model.domain.exceptions.ServiceException
     */    
    public String getModelDomainPackage() throws ServiceException {
        String crudBasePackage = getConfigurationMap().get(MODEL_DOMAIN_PACKAGE);
        if (crudBasePackage == null || crudBasePackage.isEmpty()) {
            throw new ServiceException("Model domain base package not configured: base package + . + class simple name");
        }
        return crudBasePackage;        
    }  
    
    /**
     * Set base package string for CRUD classes:
     *
     * @param basePackage
     */
    public void setCRUDBasePackage(String basePackage) {
        getConfigurationMap().put(CRUD_BASE_PACKAGE, basePackage);
    }

    /**
     * Get base package string for CRUD classes:
     *
     * @return String
     * @throws local.tin.tests.model.domain.exceptions.ServiceException
     */    
    public String getCRUDBasePackage() throws ServiceException {
        String crudBasePackage = getConfigurationMap().get(CRUD_BASE_PACKAGE);
        if (crudBasePackage == null || crudBasePackage.isEmpty()) {
            throw new ServiceException("CRUD base package not configured: base package + . + class simple name");
        }
        return crudBasePackage;
    }    
}
