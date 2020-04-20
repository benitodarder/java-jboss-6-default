package local.tin.tests.service.facade.abstracts;

import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import local.tin.tests.model.domain.abstracts.AbstractIdentifiable;
import local.tin.tests.model.domain.errors.CommonError;
import local.tin.tests.model.domain.exceptions.CommonException;
import local.tin.tests.model.domain.exceptions.ServiceException;
import local.tin.tests.model.domain.messaging.Request;
import local.tin.tests.service.abstracts.AbstractServiceConfiguration;
import local.tin.tests.service.crud.abstracts.AbstractCRUDFactory;
import local.tin.tests.service.crud.abstracts.AbstractCRUD;

/**
 *
 * @author benito.darder
 */
public abstract class AbstractCRUDFacade {

    private final AbstractServiceConfiguration baseConfiguration;
    private final AbstractCRUDFactory baseCrudFactory;

    protected AbstractCRUDFacade(AbstractServiceConfiguration baseConfiguration, AbstractCRUDFactory baseCrudFactory) {
        this.baseConfiguration = baseConfiguration;
        this.baseCrudFactory = baseCrudFactory;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response create(Request parameter) {
        try {
            AbstractCRUD crud = baseCrudFactory.getCRUD(getNormalizedClassName(parameter.getItem().getClass().getSimpleName()));
            AbstractIdentifiable iIdentifiableObject = (AbstractIdentifiable) crud.create(parameter.getItem());
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(true);
            response.addResponse(iIdentifiableObject);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (ServiceException se) {
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(false);
            CommonError commonError = new CommonError();
            commonError.setErrorMessage(se.getLocalizedMessage());
            response.setError(commonError);
            return Response.status(Response.Status.CONFLICT).entity(commonError).build();
        }
    }

    @POST
    @Path("/retrieve")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response retrieve(Request parameter) {
        try {
            AbstractCRUD crud = baseCrudFactory.getCRUD(getNormalizedClassName(parameter.getItem().getClass().getSimpleName()));
            AbstractIdentifiable iIdentifiableObject = crud.retrieve(parameter.getItem().getId());
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(true);
            response.addResponse(iIdentifiableObject);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (ServiceException se) {
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(false);
            CommonError commonError = new CommonError();
            commonError.setErrorMessage(se.getLocalizedMessage());
            response.setError(commonError);
            return Response.status(Response.Status.CONFLICT).entity(commonError).build();
        }
    }

    @POST
    @Path("/update")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response update(Request parameter) {
        try {
            AbstractCRUD crud = baseCrudFactory.getCRUD(getNormalizedClassName(parameter.getItem().getClass().getSimpleName()));
            AbstractIdentifiable iIdentifiableObject = (AbstractIdentifiable) crud.update(parameter.getItem());
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(true);
            response.addResponse(iIdentifiableObject);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (ServiceException se) {
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(false);
            CommonError commonError = new CommonError();
            commonError.setErrorMessage(se.getLocalizedMessage());
            response.setError(commonError);
            return Response.status(Response.Status.CONFLICT).entity(commonError).build();
        }
    }

    @POST
    @Path("/delete")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_XML)
    public Response delete(Request parameter) {
        try {
            AbstractCRUD crud = baseCrudFactory.getCRUD(getNormalizedClassName(parameter.getItem().getClass().getSimpleName()));
            crud.delete(parameter.getItem());
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(true);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (ServiceException se) {
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(false);
            CommonError commonError = new CommonError();
            commonError.setErrorMessage(se.getLocalizedMessage());
            response.setError(commonError);
            return Response.status(Response.Status.CONFLICT).entity(commonError).build();
        }
    }

    @GET
    @Path("/{klass}/retrieveAll")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response retrieveAll(@PathParam("klass") String klass) {
        try {
            AbstractCRUD crud = baseCrudFactory.getCRUD(getNormalizedClassName(klass));
            Collection<AbstractIdentifiable> iIdentifiableObject = crud.retrieveAll();
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(true);
            response.setResponses(iIdentifiableObject);
            return Response.status(Response.Status.OK).entity(response).build();
        } catch (CommonException se) {
            local.tin.tests.model.domain.messaging.Response response = new local.tin.tests.model.domain.messaging.Response();
            response.setSuccess(false);
            CommonError commonError = new CommonError();
            commonError.setErrorMessage(se.getLocalizedMessage());
            response.setError(commonError);
            return Response.status(Response.Status.CONFLICT).entity(commonError).build();
        }

    }

    private String getNormalizedClassName(String klass) throws ServiceException {
        String fullyQualifiedClassName = baseConfiguration.getModelDomainPackage() + "." + (klass.substring(0, 1).toUpperCase() + klass.substring(1).toLowerCase());
        return fullyQualifiedClassName;
    }
}
