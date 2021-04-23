package com.udemy.springboot.crud_demo.repository;

import com.udemy.springboot.crud_demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
public class EmployeeRepositoryHibernateImpl implements EmployeeRepository {

    private EntityManager entityManager;

    //Constructor injections
    @Autowired
    public EmployeeRepositoryHibernateImpl(EntityManager injectedEntityManager) {
        entityManager = injectedEntityManager;
    }

    @Override
    //Using native hibernate to retrieve the data
    public List<Employee> findAll() {
        //get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        //create a query
        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);

        //execute query and get results
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);

        return currentSession.get(Employee.class, id);
    }

    @Override
    public void save(Employee employee) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query query = currentSession.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
