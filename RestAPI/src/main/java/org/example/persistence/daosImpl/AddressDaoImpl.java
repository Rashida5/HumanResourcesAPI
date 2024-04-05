package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.example.persistence.daos.AddressDao;
import org.example.persistence.entities.Address;
import org.example.persistence.entities.Position;
import org.example.service.servicesImp.PositionServiceImpl;

public class AddressDaoImpl implements AddressDao {

    private static AddressDaoImpl instance;
    @Override
    public Address add(Address entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println("Address Added "+entity.getId());
        return entity;
    }
    public Address getAddressByEmployeeId(int id, EntityManager em){
        String jpql = "SELECT e FROM Address e WHERE e.employee.id = :id";
        TypedQuery<Address> query= em.createQuery(jpql, Address.class);
        query.setParameter("id",id);
        Address address;
        try{
         address = query.getSingleResult();}
        catch (Exception e){
            address = null;
        }
        return address;
    }

    @Override
    public Address getById(int id, EntityManager em) {
        return null;
    }

    @Override
    public boolean update(Address entity, EntityManager em) {

        return false;
    }
    public boolean updateAddressOfEmployee(Address address, int employeeId, EntityManager em) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();

            // Update query to update the address fields for the specified customer ID
            int updatedRows = em.createQuery(
                            "UPDATE Address a SET a.city = :city, a.street = :street, a.apartmentNumber = :apartmentNumber " +
                                    "WHERE a.employee.id = :EmployeeId")
                    .setParameter("city", address.getCity())
                    .setParameter("street", address.getStreet())
                    .setParameter("apartmentNumber", address.getApartmentNumber())
                    .setParameter("EmployeeId", employeeId)
                    .executeUpdate();
            transaction.commit();
            return updatedRows > 0;
        } catch (Exception e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public boolean delete(Address entity, EntityManager em) {
        return false;
    }
    public static AddressDaoImpl getInstance(){
        if(instance==null)
            instance = new AddressDaoImpl();
        return instance;
    }
}
