package com.example;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * Root resource (exposed at "myresource" path)
 */
@Path("myresource")
public class MyResource {

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     * @throws JsonProcessingException 
     */
	
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
	@Path("/getPojo")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getPojo() throws JsonProcessingException {
    	ObjectMapper om = new ObjectMapper();
    	String result = om.writeValueAsString(new Pojo("propiedad", 10, false));
    	return result;
    }
    
	
	@Path("/getName/{user_name}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getName(@PathParam("user_name") String user_name) {
    	return (user_name.equals("estuardolh")?"estuardo":"unknow");
    }
}
