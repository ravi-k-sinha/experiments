package self.rks.example1;

import javax.ws.rs.*;
import javax.ws.rs.core.Response;

@Path("rapi/json-eg-1/jsonServices")
public class RESTEasyJSONServices {

    @GET
    @Path("/print/{name}")
    @Produces("application/json")
    public Student produceJSON(@PathParam("name") String name) {
        Student student = new Student(name, "Marco", 19, 12);
        return student;
    }

    @POST
    @Path("/send")
    @Consumes("application/json")
    public Response consumeJSON(Student student) {
        String output = student.toString();

        return Response.status(200).entity(output).build();
    }
}
