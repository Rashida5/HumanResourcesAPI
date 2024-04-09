package org.example;


import org.example.service.dto.employee.EmployeeGet;
import org.example.service.dto.project.ProjectGet;
import org.example.service.dto.project.ProjectPost;
import org.example.service.mapping.project.EmployeeGetMapper;
import org.example.service.servicesImp.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ProjectPost projectPost = new ProjectPost();
//        projectPost.setProjectID(1);
//        projectPost.setProjectName("new Cairo");
//       projectPost.setStartDate("2021-08-11");
//        projectPost.setEndDate("2023-09-11");
//        projectPost.setDepartmentId(1);
//        boolean added = ProjectServiceImpl.getInstance().addProject(projectPost);
//        System.out.println(added);

//        List<ProjectGet> projects = EmployeeServiceImpl.getInstance().getProjectEmployeeWorkOn(1);
//        for(ProjectGet projectGet:projects){
//            System.out.println(projectGet);
//        }
        List<EmployeeGet> list = DepartmentServiceImpl.getInstance().getEmployeesInDepartment(1);
        for(EmployeeGet emp:list){
            System.out.println(emp);
        }

      //   boolean updated = ProjectServiceImpl.getInstance().updateProject(projectPost);
        // List<EmployeeProjectGet> employeeGets = ProjectServiceImpl.getInstance().getEmployeeWorkOnProject(1);
      //EmployeeGet employeeGetData = EmployeeServiceImpl.getInstance().getEmployeeById(2);

//        boolean deleted = ProjectServiceImpl.getInstance().deleteEmployeeFromProject(1,1);
//        System.out.println(deleted);
//         for(EmployeeProjectGet employeeGet:employeeGets){
//             System.out.println(employeeGet);
//         }
//         System.out.println(employeeGetData);

        // boolean added = ProjectServiceImpl.getInstance().addEmployeeToProject(2,1);
     //  ProjectGet projectGet= ProjectServiceImpl.getInstance().getProject(1);
        // System.out.println(updated);
         //System.out.println(projectGet);
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

//        EmployeeService employeeService = EmployeeServiceImpl.getInstance();
//        boolean deleted =employeeService.deleteEmployee(1);
//        System.out.println(deleted);


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

//        DepartmentPost departmentPost = new DepartmentPost();
//        departmentPost.setDepartmentName("ITI System");
//        departmentPost.setMangerId(2);
//        LocalTime localTime = LocalTime.now();
//        System.out.println(localTime);
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
//        String formattedTime = localTime.format(formatter);
//        System.out.println("Current Time (Formatted): " + formattedTime);

        //boolean added = DepartmentServiceImpl.getInstance().addDepartment(departmentPost);
        //boolean addedEmployee = EmployeeServiceImpl.getInstance().addEmployee(new EmployeePost("Rashida","Mohamed",2,1,"Shebin","TallatHarab","5","012345678914","Rashida@gmail.com"));
       //boolean updated= DepartmentServiceImpl.getInstance().updateDepartment(new DepartmentPost(2,"JETS",2));
      //  boolean deleted = DepartmentServiceImpl.getInstance().deleteDepartmentById(2);
       // System.out.println(deleted);

        LocalTime localTime = LocalTime.now();
        LocalDate date = LocalDate.now();
        System.out.println(localTime);
        System.out.println(date);
      //  boolean added =AttendanceServiceImpl.getInstance().markArrive(1, localTime, date);
        //boolean added = AttendanceServiceImpl.getInstance().markLeave(1, localTime, date);
//        boolean added = AttendanceServiceImpl.getInstance().markLeave(1, localTime, date);
//        List<AttendanceGet> get = AttendanceServiceImpl.getInstance().getAttendanceDataOfEmployee(1,5,2024);
//        if(get!=null){
//            for(AttendanceGet attendanceGet:get){
//                System.out.println(attendanceGet.toString());
//            }
//        }

    }
}