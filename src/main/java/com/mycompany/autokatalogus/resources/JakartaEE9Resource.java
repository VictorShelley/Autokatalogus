package com.mycompany.autokatalogus.resources;

import controller.XmlRead;
import controller.XmlWrite;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import static model.convert.StringToCar;
import model.user;
import org.json.JSONObject;


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
        String[] szetszedve = be.split("-",2);
       
        String alvaz = szetszedve[0];
        String motor = szetszedve[1];
        XmlRead read = new XmlRead();
        
        return Response.ok(read.carValaszt(alvaz, motor).toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    @POST
    @Path("AddCar")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response AddCar(String be){
        
        JSONArray ki = new JSONArray();
        ki = StringToCar(be);

        XmlRead read = new XmlRead();
        XmlWrite write = new XmlWrite();
        boolean siker = write.CarAdd(ki);
        return Response.ok(read.carRead().toString())
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
    
    
    @POST
    @Path("AddUser")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN) //postman teszthez
    public Response AddUser(String be){
        JSONObject userData = new JSONObject(be);
        XmlRead read = new XmlRead();
        XmlWrite write = new XmlWrite();
        ArrayList <user> list = read.UserRead();
        user tmp = new user(userData.get("Name").toString(),userData.get("Id").toString(),userData.get("Phone").toString(),userData.get("Email").toString(),userData.get("Cim").toString(),userData.getLong("Szul"));
        list.add(tmp);
        write.UserWhite(list);
        return Response.ok("Neve: "+userData.get("Name").toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("SellRead")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response SellRead(){
        //done.get(i+1).toString();
        XmlRead read = new XmlRead();
        return Response.ok(read.EladasRead().toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
    @GET
    @Path("SellReadFull")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response SellReadFull(){
        XmlRead read = new XmlRead();
        JSONArray eddig = new JSONArray();
        eddig = read.EladasRead();
        JSONArray ki = new JSONArray();

        for (int i=0; i < eddig.length(); i++) {
            JSONObject eladas = eddig.getJSONObject(i);
            JSONObject carData = new JSONObject();
            
            carData.put("eladasId" ,eladas.get("id").toString());
            carData.put("userId", eladas.get("szem").toString()); //Ide j??nne a v??laszthat?? User read. valami valami .toString()) todo
            carData.put("userData", read.oneUserRead(eladas.get("szem").toString()));
            carData.put("carData", read.carValaszt(eladas.get("alvaz").toString(), eladas.get("motor").toString()));
            
            ki.put(carData);
        }
       
        return Response.ok(ki.toString())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
    
}
