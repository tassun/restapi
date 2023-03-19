package com.test;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

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
     */
	//curl http://localhost:8080/myresource
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getIt() {
        return "Got it!";
    }
    
	//curl http://localhost:8080/myresource/json
    @GET
    @Path("/json")
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
    	Map<String,String> map = new HashMap<>();
    	map.put("message","Got it!");
        return JSONObject.toJSONString(map);
    }
    
	//curl http://localhost:8080/myresource/hi?name=John
    @GET
    @Path("/hi")
    @Produces(MediaType.APPLICATION_JSON)
    public String hi(@QueryParam("name") String name) {
    	Map<String,String> map = new HashMap<>();
    	map.put("message","Hi, "+name);
        return JSONObject.toJSONString(map);    	
    }

	//curl http://localhost:8080/myresource/hello/John
    @GET
    @Path("/hello/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String hello(@PathParam("name") String name) {
    	Map<String,String> map = new HashMap<>();
    	map.put("message","Hello, "+name);
        return JSONObject.toJSONString(map);    	
    }

	//curl -X POST http://localhost:8080/myresource/greeting -d "name=John&surname=Doe"
    @POST
    @Path("/greeting")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public String greeting(MultivaluedMap<String, String> params) {
    	System.out.println("params="+params);
    	String name = params.getFirst("name");
    	String surname = params.getFirst("surname");
    	Map<String,String> map = new HashMap<>();
    	map.put("message","Greeting, "+name+" "+surname);
        return JSONObject.toJSONString(map);    	    	
    }

	//curl -X POST http://localhost:8080/myresource/bonjour -d "John Doe"
    @POST
    @Path("/bonjour")
    @Produces(MediaType.APPLICATION_JSON)
    public String bonjour(String params) {
    	System.out.println("params="+params);
    	Map<String,String> map = new HashMap<>();
    	map.put("message","Bonjour, "+params);
        return JSONObject.toJSONString(map);    	    	
    }
    
	//curl -X POST -H "Content-Type: application/json" http://localhost:8080/myresource/xinchao -d "{\"name\":\"John\",\"surname\":\"Doe\"}"
    @POST
    @Path("/xinchao")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public String xinchao(String params) {
    	System.out.println("params="+params);
    	Map<String,String> map = new HashMap<>();
    	map.put("message","Xin chao, ");
    	try {
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject)parser.parse(params);
    		String name = (String)json.get("name");
    		String surname = (String)json.get("surname");
        	map.put("message","Xin chao, "+name+" "+surname);    		
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
        return JSONObject.toJSONString(map);    	    	    	    	
    }
    
	//curl -X POST -H "Content-Type: application/json" http://localhost:8080/myresource/sabaidi -d "{\"name\":\"John\",\"surname\":\"Doe\"}"
    @POST
    @Path("/sabaidi")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response sabaidi(String params) {
    	Greet greet = new Greet("Sabaidi, ");
    	try {
    		JSONParser parser = new JSONParser();
    		JSONObject json = (JSONObject)parser.parse(params);
    		String name = (String)json.get("name");
    		String surname = (String)json.get("surname");
    		greet.setMessage("Sabaidi, "+name+" "+surname);
    	} catch(Exception ex) {
    		ex.printStackTrace();
    	}
        return Response.ok(greet).build();    	    	    	
    }
    
	//curl -X POST -H "Content-Type: application/json" http://localhost:8080/myresource/nihao -d "{\"name\":\"John\",\"surname\":\"Doe\"}"
    @POST
    @Path("/nihao")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Greet nihao(Account account) {
    	System.out.println("account="+account);
        return new Greet("Nihao, "+account.getFullName());   	    	    	    	    	    	
    }
    
    
	//curl -X POST -H "Content-Type: application/json" http://localhost:8080/myresource/hallo -d "{\"name\":\"John\",\"surname\":\"Doe\"}"
    @POST
    @Path("/hallo")
    @Produces(MediaType.APPLICATION_XML)
    @Consumes(MediaType.APPLICATION_JSON)
    public Hello hallo(Account account) {
    	System.out.println("account="+account);
        return new Hello("Hallo, "+account.getFullName());   	    	    	    	    	    	
    }
    
}
