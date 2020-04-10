package local.tin.tests.dao.impl;

import local.tin.tests.model.domain.exceptions.DAOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author benitodarder
 */
public class UnitDAOTest extends BaseDAOTest {

    protected static final String ABBREVIATION = "abbreviation";    
    private UnitDAO dao;
    private local.tin.tests.model.domain.product.Unit domainObject;
    private local.tin.tests.model.data.product.Unit dataObject;
    
    @Before
    public void setUp() {
        setUpBaseMocks();
        dao = new UnitDAO(mockedEntityManagerFactory);
        domainObject = new local.tin.tests.model.domain.product.Unit();
        dataObject = new local.tin.tests.model.data.product.Unit();
    }
            
    @Test
    public void updateDomainObjectDepth0Fields_assigns_fields() throws DAOException {
        dataObject.setAbbreviation(ABBREVIATION);
        dataObject.setEnabled(true);
        dataObject.setId(ID);
        dataObject.setName(NAME);
        
        dao.updateDomainObjectDepth0Fields(domainObject, dataObject);
        
        assertThat(domainObject.getAbbreviation(), equalTo(ABBREVIATION));
        assertThat(domainObject.getName(), equalTo(NAME));
    }
    
    @Test
    public void updateDataObjectDepth0Fields_assigns_fields() throws DAOException {
        domainObject.setAbbreviation(ABBREVIATION);
        domainObject.setEnabled(true);
        domainObject.setId(ID);
        domainObject.setName(NAME);
        
        dao.updateDataObjectDepth0Fields(domainObject, dataObject);
        
        assertThat(dataObject.getAbbreviation(), equalTo(ABBREVIATION));
        assertThat(dataObject.getName(), equalTo(NAME));
    }    

}
