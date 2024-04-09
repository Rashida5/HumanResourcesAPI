package org.example.service.servicesImp;

import jakarta.persistence.EntityManager;
import org.example.persistence.daosImpl.DepartmentDaoImpl;
import org.example.persistence.entities.Department;
import org.example.persistence.entities.Employee;
import org.example.persistence.util.JpaUtil;
import org.example.service.dto.department.DepartmentGet;
import org.example.service.dto.department.DepartmentPost;
import org.example.service.dto.employee.EmployeeGet;
import org.example.service.mapping.department.DepartmentGetMapper;
import org.example.service.mapping.department.DepartmentPostMapper;
import org.example.service.mapping.project.EmployeeGetMapper;
import org.example.service.services.DepartmentService;

import java.util.ArrayList;
import java.util.List;

public class DepartmentServiceImpl implements DepartmentService {

    private static DepartmentServiceImpl instance;

    private DepartmentServiceImpl(){

    }
    public static DepartmentServiceImpl getInstance(){
        if(instance==null)
            instance = new DepartmentServiceImpl();
        return instance;
    }


    @Override
    public boolean addDepartment(DepartmentPost departmentPost) {
        Department department = DepartmentPostMapper.getInstance().convertModelToEntity(departmentPost);
        EntityManager em = JpaUtil.createEntityManager();
       Department departmentAdded= DepartmentDaoImpl.getInstance().add(department, em);
       em.close();
        return departmentAdded!=null;
    }

    @Override
    public boolean updateDepartment(DepartmentPost departmentPost) {
        if(departmentPost.getDepartmentID()==0)
            return false;
        EntityManager em = JpaUtil.createEntityManager();
        Department department = DepartmentDaoImpl.getInstance().getById(departmentPost.getDepartmentID(),em);
        if(department==null){
            em.close();
            return false;
        }
        if(departmentPost.getDepartmentName()!=null){
            department.setDepartmentName(departmentPost.getDepartmentName());
        }
        if(departmentPost.getMangerId()!=0){
            Employee employee = new Employee();
            employee.setId(departmentPost.getMangerId());
            department.setManager(employee);
        }

        boolean updated  = DepartmentDaoImpl.getInstance().update(department, em);
        em.close();
        return updated;
    }

    @Override
    public DepartmentGet getDepartment(int id) {
        EntityManager em = JpaUtil.createEntityManager();
        Department department = DepartmentDaoImpl.getInstance().getById(id,em);
        DepartmentGet departmentGet;
        if(department==null){
            departmentGet =new DepartmentGet();
        }else{
             departmentGet = DepartmentGetMapper.getInstance().convertEntityToModel(department);
        }
        em.close();
        return departmentGet;
    }
    @Override
    public List<EmployeeGet> getEmployeesInDepartment(int deptId) {
        EntityManager em = JpaUtil.createEntityManager();
        Department department = DepartmentDaoImpl.getInstance().getById(deptId, em);
        if(department==null)
            return null;
        List<Employee> employees = DepartmentDaoImpl.getInstance().getEmployeeOfDepartment(deptId, em);
        if(employees==null){
            em.close();
            return new ArrayList<>();}
        List<EmployeeGet> employeeGetList = new ArrayList<>();
        for(Employee employee1: employees){
            EmployeeGet employeeGet = EmployeeGetMapper.getInstance().convertEntityToModel(employee1);
            employeeGetList.add(employeeGet);
        }
        em.close();
        return employeeGetList;
    }

//    @Override
//    public boolean deleteDepartmentById(int id) {
//        EntityManager em = JpaUtil.createEntityManager();
//        Department department = new Department();
//        department.setId(id);
//        boolean deleted = DepartmentDaoImpl.getInstance().delete(department, em);
//        List<Employee> employees = DepartmentDaoImpl.getInstance().getEmployeeOfDepartment(id, em);
//        //we need to loop and delete and employee work on this department
//        for(Employee employee:employees){
//            EmployeeDaoImpl.getInstance().delete(employee, em);
//        }
//        em.close();
//        return deleted;
//    }
}
