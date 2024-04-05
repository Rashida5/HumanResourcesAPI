package org.example;


import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.dto.position.PositionGet;
import org.example.service.services.EmployeeService;
import org.example.service.services.PositionsService;
import org.example.service.servicesImp.EmployeeServiceImpl;
import org.example.service.servicesImp.PositionServiceImpl;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
//            PositionsService positionsService = PositionServiceImpl.getInstance();
//
//       //    boolean added= positionsService.addPosition("Software Engineer", 20000);
//        PositionGet positionGet = positionsService.getPositionById(1);
//
//        System.out.println(positionGet);
//
//       PositionGet positionGet1 = positionsService.getPositionByName("Software Engineer");
//
//      //  System.out.println(positionGet1);
//        //   System.out.println(added);

        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
        boolean deleted =employeeService.deleteEmployee(1);
        System.out.println(deleted);
//            EmployeePost employeePost = new EmployeePost();
//            employeePost.setFirstName("Reem");
//
//        //EmployeePost employeePost = new EmployeePost("Rawda","Tolba",1,1,"Shebin","tallatHarab","6","01005525768","Rawda@gmail.com");
//        employeePost.setEmployeeId(1);
//        boolean updated = employeeService.updateEmployee(employeePost);
//        System.out.println(updated);

//        EmployeePost employeePost1 = new EmployeePost();
//       // employeePost1.setEmployeeId();
//        // boolean added= employeeService.addEmployee(employeePost);
//
//        EmployeeGet employeeGet = employeeService.getEmployeeById(2);
//      System.out.println(employeeGet);


    }
}