package self.rks.com.restfully.shop.ex04_1.services;

import self.rks.com.restfully.shop.ex04_1.domain.Customer;
import self.rks.com.restfully.shop.ex04_1.org.ieft.annotations.PATCH;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.StreamingOutput;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.URI;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Path("/rapi/ex04_1/customers")
public class CustomerResource
{
    private Map<Integer, Customer> customerDB = new ConcurrentHashMap<>();
    private AtomicInteger idCounter = new AtomicInteger();

    public CustomerResource()
    {
    }

    @POST
    @Consumes("application/xml")
    public Response createCustomer(InputStream is)
    {
        Customer customer = readCustomer(is);
        customer.setId(idCounter.incrementAndGet());
        customerDB.put(customer.getId(), customer);
        System.out.println("Created customer " + customer.getId());
        return Response.created(URI.create("/rapi/ex04_1/customers/" + customer.getId())).build();

    }

    @GET
    @Path("{id}")
    @Produces("application/xml")
    public StreamingOutput getCustomer(@PathParam("id") int id)
    {
        final Customer customer = customerDB.get(id);
        if (customer == null)
        {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }

        return outputStream -> outputCustomer(outputStream, customer);
    }

    @PUT
    @Path("{id}")
    @Consumes("application/xml")
    public void updateCustomer(@PathParam("id") int id, InputStream is)
    {
        Customer update = readCustomer(is);
        Customer current = customerDB.get(id);
        if (current == null) throw new WebApplicationException(Response.Status.NOT_FOUND);

        if (update.getFirstName() != null)
        {
            current.setFirstName(update.getFirstName());
        }
        if (update.getLastName() != null)
        {
            current.setLastName(update.getLastName());
        }
        if (update.getStreet() != null)
        {
            current.setStreet(update.getStreet());
        }
        if (update.getState() != null)
        {
            current.setState(update.getState());
        }
        if (update.getZip() != null)
        {
            current.setZip(update.getZip());
        }
        if (update.getCountry() != null)
        {
            current.setCountry(update.getCountry());
        }
    }


    @PATCH
    @Path("{id}")
    @Consumes("application/xml")
    public void patchCustomer(@PathParam("id") int id, InputStream is)
    {
        updateCustomer(id, is);
    }


    protected void outputCustomer(OutputStream os, Customer cust) throws IOException
    {
        PrintStream writer = new PrintStream(os);
        writer.println("<customer id=\"" + cust.getId() + "\">");
        writer.println("   <first-name>" + cust.getFirstName() + "</first-name>");
        writer.println("   <last-name>" + cust.getLastName() + "</last-name>");
        writer.println("   <street>" + cust.getStreet() + "</street>");
        writer.println("   <city>" + cust.getCity() + "</city>");
        writer.println("   <state>" + cust.getState() + "</state>");
        writer.println("   <zip>" + cust.getZip() + "</zip>");
        writer.println("   <country>" + cust.getCountry() + "</country>");
        writer.println("</customer>");
    }

    protected Customer readCustomer(InputStream is)
    {
        try
        {
            DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            Document doc = builder.parse(is);
            Element root = doc.getDocumentElement();
            Customer cust = new Customer();
            if (root.getAttribute("id") != null && !root.getAttribute("id").trim().equals(""))
                cust.setId(Integer.valueOf(root.getAttribute("id")));
            NodeList nodes = root.getChildNodes();
            for (int i = 0; i < nodes.getLength(); i++)
            {
                Element element = (Element) nodes.item(i);
                if (element.getTagName().equals("first-name"))
                {
                    cust.setFirstName(element.getTextContent());
                }
                else if (element.getTagName().equals("last-name"))
                {
                    cust.setLastName(element.getTextContent());
                }
                else if (element.getTagName().equals("street"))
                {
                    cust.setStreet(element.getTextContent());
                }
                else if (element.getTagName().equals("city"))
                {
                    cust.setCity(element.getTextContent());
                }
                else if (element.getTagName().equals("state"))
                {
                    cust.setState(element.getTextContent());
                }
                else if (element.getTagName().equals("zip"))
                {
                    cust.setZip(element.getTextContent());
                }
                else if (element.getTagName().equals("country"))
                {
                    cust.setCountry(element.getTextContent());
                }
            }
            return cust;
        }
        catch (Exception e)
        {
            throw new WebApplicationException(e, Response.Status.BAD_REQUEST);
        }
    }
}