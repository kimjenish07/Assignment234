/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/JerseyClient.java to edit this template
 */
package Client;

import javax.ws.rs.ClientErrorException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 * Jersey REST client generated for REST resource:JakartaEE8Resource [rest]<br>
 * USAGE:
 * <pre>
 *        MyClient client = new MyClient();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author jeshanpatel1510
 */
public class MyClient {

    private WebTarget webTarget;
    private Client client;
    
    private static final String BASE_URI = "http://localhost:8080/Assignment2/resources";

    public MyClient() {
        client = javax.ws.rs.client.ClientBuilder.newClient();
        webTarget = client.target(BASE_URI).path("rest");
    }

    public <T> T searchMovies(Class<T> responseType, String theaterid) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("movies/search/{0}", new Object[]{theaterid}));
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T getAllTheaters(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("theaters");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public <T> T deleteMovie(Class<T> responseType,String movieid) throws ClientErrorException {
       
        /*WebTarget resource = webTarget;
        resource = resource.path(java.text.MessageFormat.format("movies/delete/{0}", new Object[]{movieid}));
        return resource.get(responseType);*/
        return null;
    }

    public void addMovie(Object requestEntity) throws ClientErrorException {
        webTarget.path("movies/add").request(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(javax.ws.rs.client.Entity.entity(requestEntity, javax.ws.rs.core.MediaType.APPLICATION_JSON));
    }

    public <T> T getAllMovies(Class<T> responseType) throws ClientErrorException {
        WebTarget resource = webTarget;
        resource = resource.path("movies");
        return resource.request(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(responseType);
    }

    public void close() {
        client.close();
    }
    
}
