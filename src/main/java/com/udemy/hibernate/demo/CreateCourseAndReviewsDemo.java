package com.udemy.hibernate.demo;

import com.udemy.hibernate.entity.Course;
import com.udemy.hibernate.entity.Instructor;
import com.udemy.hibernate.entity.InstructorDetail;
import com.udemy.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class CreateCourseAndReviewsDemo {
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

            Course tempCourse = new Course("Pacman - How to score one million points");

            tempCourse.addReview(new Review("Great course.. loved it"));
            tempCourse.addReview(new Review("Wooo!"));
            tempCourse.addReview(new Review("Learned a lot!"));

            session.save(tempCourse);

            session.getTransaction().commit();

            System.out.println("Done!");

        } finally {
            session.close();
            factory.close();
        }
    }
}
