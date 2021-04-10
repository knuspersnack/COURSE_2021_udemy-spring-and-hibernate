package com.udemy.hibernate.demo;

import com.udemy.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class UpdateStudentDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            int studentId = 1;
            session.beginTransaction();

            System.out.println("Getting the student...");
            Student myStudent = session.get(Student.class, studentId);
            System.out.println("Get complete:  " + myStudent);

            System.out.println("Updating student...");
            myStudent.setFirstName("Scooby2");

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
