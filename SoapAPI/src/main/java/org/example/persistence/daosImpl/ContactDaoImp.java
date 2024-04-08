package org.example.persistence.daosImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.example.persistence.daos.ContactDao;
import org.example.persistence.entities.Contact;

public class ContactDaoImp implements ContactDao {

    private static ContactDaoImp instance;
    @Override
    public Contact add(Contact entity, EntityManager em) {
        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        if(em.getTransaction().getRollbackOnly()){
            return null;
        }
        System.out.println("Contact Added "+ entity.getId());
        return entity;
    }

    public Contact getContactByEmployeeId(int id , EntityManager em){
        String jpql = "SELECT e FROM Contact e WHERE e.employee.id = :id";
        TypedQuery<Contact> query= em.createQuery(jpql, Contact.class);
        query.setParameter("id",id);

        Contact contacts;
        try{
            contacts = query.getSingleResult();
        }
        catch (Exception e){
            contacts = null;
        }
        return contacts ;
    }
    public boolean updateContactOfEmployee(Contact contact, int employeeId, EntityManager em) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();

            // Update query to update the address fields for the specified customer ID
            int updatedRows = em.createQuery(
                            "UPDATE Contact a SET a.mobilePhone = :phone, a.email = :email " +
                                    "WHERE a.employee.id = :EmployeeId")
                    .setParameter("phone",contact.getMobilePhone() )
                    .setParameter("email", contact.getEmail())
                    .setParameter("EmployeeId",employeeId)
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
    public Contact getById(int id, EntityManager em) {
        return null;
    }

    @Override
    public boolean update(Contact entity, EntityManager em) {
        return false;
    }

    @Override
    public boolean delete(Contact entity, EntityManager em) {
        return false;
    }

    private ContactDaoImp(){

    }
    public static ContactDaoImp getInstance(){
        if(instance==null)
            instance = new ContactDaoImp();
        return instance;
    }
}
