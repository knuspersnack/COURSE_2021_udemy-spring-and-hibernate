package com.udemy.hibernate.demo;

import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            Instructor tempInstructor = new Instructor("Chad", "Darby", "darvy@luv2code.com");
            InstructorDetail tempInstructorDetail = new InstructorDetail("Youtube Luv2Code", "Luv2Code!");

            tempInstructor.setInstructorDetail(tempInstructorDetail);

            session.beginTransaction();

            //Since CascadeType.All the associated object will be saved as well
            session.save(tempInstructor);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            factory.close();
        }
    }
}
