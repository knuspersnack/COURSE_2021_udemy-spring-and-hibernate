package com.udemy.hibernate.demo;

import com.udemy.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            System.out.println("Creating new student object...");
            Student tempStudent1 = new Student("John", "Doe", "johnl@student.com");
            Student tempStudent2 = new Student("Mary", "Public", "mary@student.com");
            Student tempStudent3 = new Student("Bone", "Test", "bone@student.com");
            session.beginTransaction();

            System.out.println("Saving the student...");
            session.save(tempStudent1);
            session.save(tempStudent2);
            session.save(tempStudent3);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
