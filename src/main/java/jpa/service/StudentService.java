package jpa.service;

import jpa.dao.StudentDAO;
import jpa.entitymodels.Course;
import jpa.entitymodels.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;


public class StudentService implements StudentDAO {

    @Override
    public Student getStudentByEmail(String email) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Student stEmail = session.find(Student.class, email);
        session.close();
        System.out.println(stEmail);
        return stEmail;
    }

    @Override
    public boolean validateStudent(String sEmail, String sPassword) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Student st = session.find(Student.class, sEmail);
        if (st == null) {
            System.out.println("\nthis student cannot be found ");
            return false; //
        } else if (st.getsPass().contentEquals(sPassword)) {
            System.out.println("\nThis student is verified");
            return true; // checking to see if student has the right creds
        } else {
            session.close();
            System.out.println("You have entered the wrong credentials");
            return false; //

        }
    }

    @Override
    public boolean registerStudentToCourse(int cId, String sEmail) {
        SessionFactory ss = new Configuration().configure().buildSessionFactory();
        Session session = ss.openSession();
        Transaction t = session.beginTransaction();
        Student st = session.find(Student.class, sEmail); // finding student and joining with the course where student semail = semail
        List<Course> sCourse = st.getsCourses(); // returning student course in as a list
        for (Course course : sCourse) {
            if (cId == course.getCid()) {
                System.out.println("Error! You are already registered to the course");
                return false; // running through the student course and checking if they are already registered
            }
        }

        Course c = session.find(Course.class, cId); // finding course by course id = cid
        sCourse.add(c); // adding the course
        st.setsCourses(sCourse);
        session.save(st); // saving the course
        session.getTransaction().commit(); // committing the query after it's completed
        session.close();
        System.out.println("Congrats! You have successfully registered");
        return true;

    }

    @Override
    public List<Course> getStudentCourses(String sEmail) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        Student stuEmail = session.find(Student.class, sEmail);
        List<Course> stuCourses = stuEmail.getsCourses();
        System.out.println(stuCourses);
        return stuCourses;

    }

    @Override
    public List getAllStudents() {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session session = sf.openSession();
        List students = session.createQuery("select s from Student s").getResultList();// running a query to get all student and returning them as a list
        session.close();
        return students;
    }
}


