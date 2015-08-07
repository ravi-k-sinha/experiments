package self.rks.com.restfully.shop.ex14_1.services;

import javax.ws.rs.HEAD;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
@Path("rapi/ex14_1/shop")
public interface StoreResource
{
   @HEAD
   Response head(@Context UriInfo uriInfo);
}
