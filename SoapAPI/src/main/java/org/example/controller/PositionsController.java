package org.example.controller;

import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import org.example.service.dto.position.PositionGet;
import org.example.service.dto.position.PositionPost;
import org.example.service.servicesImp.PositionServiceImpl;

@WebService
public class PositionsController {
    public PositionsController(){

    }
   @WebResult(name="getPositionByID")
    public PositionGet getPositionByID(@WebParam(name="Id") int id){
        PositionGet positionGet =PositionServiceImpl.getInstance().getPositionById(id);
        return positionGet;
    }
 @WebResult(name="addPosition")
    public String addPosition(PositionPost positionPost){
        boolean added =PositionServiceImpl.getInstance().addPosition(positionPost.getName(), positionPost.getSalary());
      if(added){
          return "Position added successfully";
      }else{
          return "Failed To added";
      }
    }
  @WebResult
  public PositionGet getPositionByName(@WebParam(name="name") String name){
        PositionGet positionGet = PositionServiceImpl.getInstance().getPositionByName(name);
        return positionGet;
  }
}
