package com.mycompany.autokatalogus.resources;

import controller.XmlRead;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE9Resource {
    
    @GET
    @Path("carRead")
    public Response carRead(){
        XmlRead read = new XmlRead();
        return Response.ok(read.carRead().toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    @POST
    @Path("ReadChosenCar")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response ReadChosenCar(String be){
        String szetszedve[] = be.split("-",2);
        
        String alvaz = szetszedve[0];
        String motor = szetszedve[1];
        XmlRead read = new XmlRead();
        return Response.ok(read.carValaszt(alvaz,motor).toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
