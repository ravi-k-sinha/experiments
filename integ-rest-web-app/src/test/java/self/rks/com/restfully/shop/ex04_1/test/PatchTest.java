package self.rks.com.restfully.shop.ex04_1.test;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.Assert;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * @author <a href="mailto:bill@burkecentral.com">Bill Burke</a>
 * @version $Revision: 1 $
 */
public class PatchTest
{
    private static class HttpPatch extends HttpPost
    {
        public HttpPatch(String s)
        {
            super(s);
        }

        public String getMethod()
        {
            return "PATCH";
        }
    }

    @Test
    public void testCustomerResource1() throws Exception
    {
        System.out.println("*** Create a new Customer ***");
        // Create a new customer
        String newCustomer = "<customer>"
                + "<first-name>Bill</first-name>"
                + "<last-name>Burke</last-name>"
                + "<street>256 Clarendon Street</street>"
                + "<city>Boston</city>"
                + "<state>MA</state>"
                + "<zip>02115</zip>"
                + "<country>USA</country>"
                + "</customer>";

        DefaultHttpClient client = new DefaultHttpClient();

        HttpPost post = new HttpPost("http://localhost:8080/integ-rest-web-app/rapi/ex04_1/customers");
        StringEntity entity = new StringEntity(newCustomer);
        entity.setContentType("application/xml");
        post.setEntity(entity);
        HttpClientParams.setRedirecting(post.getParams(), false);
        HttpResponse response = client.execute(post);

        Assert.assertEquals(201, response.getStatusLine().getStatusCode());
        String returnedLocation = response.getLastHeader("Location").getValue();
        System.out.println("Location: [" + returnedLocation + "]");
        //response.getEntity().consumeContent();
        EntityUtils.consume(response.getEntity());

        HttpPatch patch = new HttpPatch(returnedLocation);

        // Update the new customer.  Change Bill's name to William
        String patchCustomer = "<customer>"
                + "<first-name>William</first-name>"
                + "</customer>";
        entity = new StringEntity(patchCustomer);
        entity.setContentType("application/xml");
        patch.setEntity(entity);
        response = client.execute(patch);

        Assert.assertEquals(204, response.getStatusLine().getStatusCode());

        // Show the update
        System.out.println("**** After Update ***");
        HttpGet get = new HttpGet(returnedLocation);
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

        System.out.println("Content-Type: " + response.getEntity().getContentType());
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(response.getEntity().getContent()));

        String line = reader.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = reader.readLine();
        }

        reader.close();
        client.close();
    }

    //@Test
    public void testCustomerResource2() throws Exception
    {
        System.out.println("*** Create a new Customer ***");
        // Create a new customer
        String newCustomer = "<customer>"
                + "<first-name>Bill</first-name>"
                + "<last-name>Burke</last-name>"
                + "<street>256 Clarendon Street</street>"
                + "<city>Boston</city>"
                + "<state>MA</state>"
                + "<zip>02115</zip>"
                + "<country>USA</country>"
                + "</customer>";

        URL postUrl = new URL("http://localhost:8080/integ-rest-web-app/rapi/ex04_1/customers");
        HttpURLConnection connection = (HttpURLConnection) postUrl.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/xml");
        OutputStream os = connection.getOutputStream();
        os.write(newCustomer.getBytes());
        os.flush();
        Assert.assertEquals(HttpURLConnection.HTTP_CREATED, connection.getResponseCode());
        System.out.println("Location: " + connection.getHeaderField("Location"));
        connection.disconnect();

        /**
        DefaultHttpClient client = new DefaultHttpClient();

        HttpPost post = new HttpPost("http://localhost:8080/integ-rest-web-app/rapi/ex04_1/customers");
        StringEntity entity = new StringEntity(newCustomer);
        entity.setContentType("application/xml");
        post.setEntity(entity);
        HttpClientParams.setRedirecting(post.getParams(), false);
        HttpResponse response = client.execute(post);

        Assert.assertEquals(201, response.getStatusLine().getStatusCode());
        System.out.println("Location: " + response.getLastHeader("Location"));
        */

        // Update the new customer.  Change Bill's name to William
        String patchCustomer = "<customer>"
                + "<first-name>William</first-name>"
                + "</customer>";

        URL patchUrl = new URL("http://localhost:8080/integ-rest-web-app/rapi/ex04_1/customers");
        connection = (HttpURLConnection) patchUrl.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("PATCH");
        connection.setRequestProperty("Content-Type", "application/xml");
        os = connection.getOutputStream();
        os.write(patchCustomer.getBytes());
        os.flush();
        Assert.assertEquals(HttpURLConnection.HTTP_CREATED, connection.getResponseCode());
        System.out.println("Location: " + connection.getHeaderField("Location"));
        connection.disconnect();

        /**
        HttpPatch patch = new HttpPatch("http://localhost:8080/integ-rest-web-app/rapi/ex04_1/customers");

        entity = new StringEntity(patchCustomer);
        entity.setContentType("application/xml");
        patch.setEntity(entity);
        response = client.execute(patch);

        Assert.assertEquals(204, response.getStatusLine().getStatusCode());
        */

        // Show the update
        System.out.println("**** After Update ***");

        URL getUrl = new URL(connection.getHeaderField("Location"));
        connection = (HttpURLConnection) getUrl.openConnection();
        connection.setDoOutput(true);
        connection.setInstanceFollowRedirects(false);
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/xml");
        os = connection.getOutputStream();
        os.write(patchCustomer.getBytes());
        os.flush();
        Assert.assertEquals(HttpURLConnection.HTTP_OK, connection.getResponseCode());
        System.out.println("Location: " + connection.getHeaderField("Location"));

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line = reader.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = reader.readLine();
        }

        connection.disconnect();

        /**
        HttpGet get = new HttpGet("http://localhost:8080/integ-rest-web-app/rapi/ex04_1/customers/1");
        response = client.execute(get);
        Assert.assertEquals(200, response.getStatusLine().getStatusCode());

        System.out.println("Content-Type: " + response.getEntity().getContentType());
        BufferedReader reader = new BufferedReader(new
                InputStreamReader(response.getEntity().getContent()));

        String line = reader.readLine();
        while (line != null)
        {
            System.out.println(line);
            line = reader.readLine();
        }
        */
    }
}