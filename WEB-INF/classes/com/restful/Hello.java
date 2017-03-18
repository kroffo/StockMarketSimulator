package com.restful;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.simulator.Company;

// Plain old Java Object it does not extend as class or implements
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation.
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML.

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
    public class Hello {
	com.simulator.Company[] c = com.simulator.Company.getCompanies();

	// This method is called if TEXT_PLAIN is request
	@GET
	    @Produces(MediaType.TEXT_PLAIN)
	    public String sayPlainTextHello() {
	    return c[0].getName();
	}
	
	// This method is called if XML is request
	@GET
	    @Produces(MediaType.TEXT_XML)
	    public String sayXMLHello() {
	    return "<?xml version=\"1.0\"?>" + "<hello> " + c[0].getName() + "</hello>";
	}
	
	// This method is called if HTML is request
	@GET
	    @Produces(MediaType.TEXT_HTML)
	    public String sayHtmlHello() {
	    return "<html> " + "<title>" + c[0].getName() + "</title>"
		+ "<body><h1>" + c[0].getName() + "</body></h1>" + "</html> ";
	}
	
    }