package com.udemy.springboot.crud_demo.repository;

import com.udemy.springboot.crud_demo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeRepositoryJPAImpl implements EmployeeRepository {
    private EntityManager entityManager;

    //Constructor injections
    @Autowired
    public EmployeeRepositoryJPAImpl(EntityManager injectedEntityManager) {
        entityManager = injectedEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        Query query = entityManager.createQuery("from Employee");
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Employee updatedEmployee = entityManager.merge(employee);
        employee.setId(updatedEmployee.getId());
    }

    @Override
    public void deleteById(int id) {
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
