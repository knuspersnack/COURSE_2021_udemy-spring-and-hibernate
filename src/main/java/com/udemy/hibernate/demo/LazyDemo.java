package com.udemy.hibernate.demo;

import com.udemy.hibernate.entity.Course;
import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class LazyDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {

            session.beginTransaction();

            int theId = 1;
            Instructor tempInstructor = session.get(Instructor.class, theId);
            System.out.println("--> Instructor: " + tempInstructor);

            // Fetching the lazy data before the session is closed
            System.out.println("--> Courses: " + tempInstructor.getCourseList());

            session.getTransaction().commit();

            session.close();
            System.out.println("--> Closing the session\n");

            // Since the data is already fetched, we can access it (otherwise we would get a nasty error)
            System.out.println("--> Courses: " + tempInstructor.getCourseList() + "\n");

            System.out.println("--> Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
