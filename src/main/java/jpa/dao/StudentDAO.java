package jpa.dao;

import java.util.List;

import jpa.entitymodels.Course;
import jpa.entitymodels.Student;

public interface StudentDAO {
    public Student getStudentByEmail(String sEmail);
    public boolean validateStudent(String sEmail, String sPassword);
    public boolean registerStudentToCourse(int id, String sEmail);
    public List<Course>  getStudentCourses(String sEmail);
    public List<Student> getAllStudents();
}