package com.udemy.hibernate.demo;

import com.udemy.hibernate.entity.Course;
import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetail;
import com.udemy.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class DeleteCourseAndReviewsDemo {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory();

        Session session = factory.getCurrentSession();

        try {
            session.beginTransaction();
            int courseId = 10;
            Course tempCourse = session.get(Course.class, courseId);

            System.out.println(tempCourse);
            System.out.println(tempCourse.getReviewList());

            System.out.println("Deleteing the course...");
            session.delete(tempCourse);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
