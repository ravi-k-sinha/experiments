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
    @Path("/send/{id}")
    @Consumes("application/json")
    public Response consumeJSON(@PathParam("id") int id, Student student) {
        System.out.println("The id consumed along with Jackson arg is " + id);
        String output = student.toString();

        return Response.status(200).entity(output).build();
    }
}
