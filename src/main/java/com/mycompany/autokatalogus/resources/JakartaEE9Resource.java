package com.mycompany.autokatalogus.resources;

import controller.XmlRead;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
<<<<<<< Updated upstream
=======
import java.util.ArrayList;
import org.json.JSONArray;
import static model.convert.StringToCar;
import model.user;
import org.json.JSONObject;
>>>>>>> Stashed changes

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
        
        String elsos = szetszedve[0];
        String masodiks = szetszedve[1];
        
        /*long alvaz = Integer.valueOf(elsos);
        int motor = Integer.valueOf(masodiks);
        
        elsos = "12345678901234567";
        masodiks = "1234";*/
        XmlRead read = new XmlRead();
        return Response.ok(read.carValaszt(elsos,masodiks).toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("UserRead")
    public Response UserRead(){
        XmlRead read = new XmlRead();
        ArrayList <user> users = read.UserRead();
        JSONArray out = new JSONArray();
        JSONObject temp = new JSONObject();
        for (int i = 0; i < users.size(); i++){
            temp.put("Name",users.get(i).getName());
            temp.put("Id",users.get(i).getId());
            temp.put("Phone",users.get(i).getPhone());
            temp.put("Email",users.get(i).getEmail()) ;
            temp.put("Cim",users.get(i).getCim()) ;
            temp.put("Szul",users.get(i).getSzul());
            out.put(temp);
        }
        
        return Response.ok(out.toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
}
