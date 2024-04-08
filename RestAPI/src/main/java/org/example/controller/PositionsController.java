package org.example.controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.example.service.dto.position.PositionGet;
import org.example.service.dto.position.PositionPost;
import org.example.service.servicesImp.PositionServiceImpl;

@Path("positions")
public class PositionsController {
    public PositionsController(){

    }
    @GET
    @Path("getPositionByID")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPositionByID(@QueryParam("Id") int id){
        PositionGet positionGet =PositionServiceImpl.getInstance().getPositionById(id);
        return Response.ok(positionGet).build();
    }
    @POST
    @Path("addPosition")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPosition(PositionPost positionPost){
        boolean added =PositionServiceImpl.getInstance().addPosition(positionPost.getName(), positionPost.getSalary());
       return Response.ok(added).build();
    }
  @GET
  @Path("getPositionByName")
  @Produces(MediaType.APPLICATION_JSON)
  public Response getPositionByName(@QueryParam("name") String name){
        PositionGet positionGet = PositionServiceImpl.getInstance().getPositionByName(name);
        return Response.ok(positionGet).build();
  }
}
