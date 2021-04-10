package com.udemy.hibernate.demo;

import com.udemy.hibernate.entity.Course;
import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;


public class FetchViaHqlDemo {
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

            //How to fetch an object including children (if LAZY fetching is enabled)
            Query<Instructor> query = session.createQuery(
                    "SELECT i FROM Instructor i "
                    + "JOIN FETCH i.courseList "
                    + "WHERE i.id=:theInstructorId",
                    Instructor.class
            );

            query.setParameter("theInstructorId", theId);

            Instructor tempInstructor = query.getSingleResult();

            System.out.println("--> Instructor: " + tempInstructor);

            //Fetching the Lazy data before the session is closed
            System.out.println("--> Courses: " + tempInstructor.getCourseList());

            session.getTransaction().commit();

            session.close();

            System.out.println("--> Closing the session\n");

            System.out.println("--> Courses: " + tempInstructor.getCourseList() + "\n");

            System.out.println("--> Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
