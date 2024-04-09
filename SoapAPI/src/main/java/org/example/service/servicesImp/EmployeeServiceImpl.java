package org.example.service.servicesImp;

import jakarta.persistence.EntityManager;
import org.example.persistence.daosImpl.AddressDaoImpl;
import org.example.persistence.daosImpl.ContactDaoImp;
import org.example.persistence.daosImpl.EmployeeDaoImpl;
import org.example.persistence.daosImpl.ProjectEmployeeDaoImpl;
import org.example.persistence.entities.Address;
import org.example.persistence.entities.Contact;
import org.example.persistence.entities.Employee;
import org.example.persistence.entities.Project;
import org.example.persistence.util.JpaUtil;
import org.example.service.dto.employee.EmployeeGetDetail;
import org.example.service.dto.employee.EmployeePost;
import org.example.service.dto.employee.MonthlyEmployeeTracking;
import org.example.service.dto.project.ProjectGet;
import org.example.service.mapping.employee.EmployeeDetailGetMapper;
import org.example.service.mapping.employee.EmployeePostMapper;
import org.example.service.mapping.employee.EmployeeUpdateMapper;
import org.example.service.mapping.project.GetProjectMapping;
import org.example.service.services.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {

    private static EmployeeServiceImpl instance;
    @Override
    public boolean addEmployee(EmployeePost employeePost) {

        EntityManager em = JpaUtil.createEntityManager();

        Employee employee = EmployeePostMapper.getInstance().convertModelToEntity(employeePost);
        LocalDate currentDate = LocalDate.now();

        employee.setStartDate(currentDate);
        employee.setEndDate(currentDate);
        employee.setIsActive(true);

        Employee employeeAdded = EmployeeDaoImpl.getInstance().add(employee, em);
        if(employeeAdded==null){
            em.close();
            return false;
        }
        else {
            Address address = new Address();
            address.setCity(employeePost.getCity());
            address.setStreet(employeePost.getStreet());
            address.setApartmentNumber(employeePost.getApartmentNumber());
            address.setEmployee(employee);

            Contact contact = new Contact();
            contact.setMobilePhone(employeePost.getMobilePhone());
            contact.setEmail(employeePost.getEmail());
            contact.setEmployee(employee);

            Contact contactAdded = ContactDaoImp.getInstance().add(contact,em);
            Address addressAdded = AddressDaoImpl.getInstance().add(address, em);

            em.close();
            if(contactAdded != null && addressAdded!=null){
                return true;
            }else{
                return false;
            }

        }
    }

    @Override
    public EmployeeGetDetail getEmployeeById(int id) {
        EntityManager em = JpaUtil.createEntityManager();
        Employee employee = EmployeeDaoImpl.getInstance().getById(id,em);
        if(employee==null){
            em.close();
            return new EmployeeGetDetail();
        }else{
            EmployeeGetDetail employeeGet = EmployeeDetailGetMapper.getInstance().convertEntityToModel(employee);
            Address address = AddressDaoImpl.getInstance().getAddressByEmployeeId(employee.getId(), em);
            Contact contact = ContactDaoImp.getInstance().getContactByEmployeeId(employee.getId(), em);
            if(address!=null) {
                employeeGet.setAddress(address.getCity() + " " + address.getStreet() + " " + address.getApartmentNumber());
            }
            if(contact!=null) {
                employeeGet.setEmail(contact.getEmail());
                employeeGet.setPhoneNumber(contact.getMobilePhone());
            }
            em.close();
            return employeeGet;
        }

    }

    @Override
    public boolean updateEmployee(EmployeePost employeePost) {
        if(employeePost.getEmployeeId()==0){
            return false;
        }
        EntityManager em = JpaUtil.createEntityManager();

        Employee employee = EmployeeDaoImpl.getInstance().getById(employeePost.getEmployeeId(), em);

        employee = EmployeeUpdateMapper.getInstance().convertModelToEntity(employeePost, employee);
        boolean updated = EmployeeDaoImpl.getInstance().update(employee, em);

        Address address = AddressDaoImpl.getInstance().getAddressByEmployeeId(employee.getId(), em);
        Contact contact = ContactDaoImp.getInstance().getContactByEmployeeId(employee.getId(), em);

        boolean changeHappenInAddress= false;
        boolean changeHappenInContact = false;
        if(address==null){ //employee not have address create address for him
            address = new Address();
        }
        if(contact==null){
            contact = new Contact();
        }
        if(employeePost.getCity()!=null){
                address.setCity(employeePost.getCity());
                changeHappenInAddress = true;
        }
        if(employeePost.getStreet()!=null){
            address.setStreet(employeePost.getStreet());
            changeHappenInAddress = true;
        }
        if(employeePost.getApartmentNumber()!=null){
            address.setApartmentNumber(employeePost.getApartmentNumber());
            changeHappenInAddress = true;
        }
        if(employeePost.getEmail()!=null){
            contact.setEmail(employeePost.getEmail());
            changeHappenInContact = true;
        }
        if(employeePost.getMobilePhone()!=null){
            contact.setMobilePhone(employeePost.getMobilePhone());
            changeHappenInContact = true;
        }

        if(changeHappenInAddress) { //check if already asked to change in address
            if (address.getEmployee() == null) { //add Address if not exist
                address.setEmployee(employee);
                Address address1 = AddressDaoImpl.getInstance().add(address, em);
                if (address1 == null) {
                    updated = false;
                }
            } else { //address already exist just update it
                updated = AddressDaoImpl.getInstance().updateAddressOfEmployee(address, employee.getId(), em);
            }
        }
        if(changeHappenInContact) { //check if already asked to change in contact
            if (contact.getEmployee() == null) {
                contact.setEmployee(employee);
                Contact contact1 = ContactDaoImp.getInstance().add(contact, em);
                if (contact1 == null) {
                    updated = false;
                }
            } else {
                updated = ContactDaoImp.getInstance().updateContactOfEmployee(contact, employee.getId(), em);
            }
        }
        em.close();
        return updated;
    }

    @Override
    public boolean deleteEmployee(int id) {
        EntityManager em = JpaUtil.createEntityManager();
        Employee employee = EmployeeDaoImpl.getInstance().getById(id,em);
        boolean deleted = EmployeeDaoImpl.getInstance().delete(employee,em);
        em.close();
        return deleted;
    }

    @Override
    public MonthlyEmployeeTracking getMonthlyEmployeeTracking(int id, int month, int year) {
        return null;
    }

    private EmployeeServiceImpl(){

    }
    public static EmployeeServiceImpl getInstance(){
        if(instance==null)
            instance = new EmployeeServiceImpl();
        return instance;
    }
    @Override
    public List<ProjectGet> getProjectEmployeeWorkOn(int id) {
        EntityManager em = JpaUtil.createEntityManager();
        Employee employee = EmployeeDaoImpl.getInstance().getById(id, em);
        if(employee==null){
            List<ProjectGet> projectGets = null;
            em.close();
            return projectGets;
        }
        List<Project> projects = ProjectEmployeeDaoImpl.getInstance().getProjectsThatEmployeeWorksOn(id, em);
        if(projects==null){
            em.close();
            return new ArrayList<>();
        }
        List<ProjectGet> list = new ArrayList<>();
        for(Project project:projects){
            ProjectGet projectGet = GetProjectMapping.getInstance().convertEntityToModel(project);
            list.add(projectGet);
        }
        em.close();
        return list;
    }

}
