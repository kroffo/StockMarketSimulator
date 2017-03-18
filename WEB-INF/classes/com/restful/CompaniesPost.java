package com.restful;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.simulator.Company;
import org.json.JSONObject;
import org.json.JSONException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.IOException;

@Path("/companies")
    public class CompaniesPost {

	@POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    public Response postCompany(InputStream data) {
	    String json = "";
	    try {
		BufferedReader in = new BufferedReader(new InputStreamReader(data));
		String line = null;
		while((line = in.readLine()) != null)
		    json += line;
		
		JSONObject obj = new JSONObject(json);
		String name = obj.getString("name");
		String symbol = obj.getString("symbol");

		// Attempt to add the company
		// If it fails, return a server error
		if(!com.simulator.Company.addCompany(name, symbol)) {
		    return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
		}

	    } catch(IOException | JSONException e) { // bad json format
		return Response.status(Response.Status.BAD_REQUEST).build();
	    }
	    return Response.ok(json, MediaType.APPLICATION_JSON).build();
	}
	
    }