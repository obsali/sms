package jpa.entitymodels;
import javax.persistence.*;
import java.util.List;
@Entity
@Table (name= "Student")
public class Student {
    @Id
    @Column(length=50, nullable=false, unique=true, name="email")
    private String sEmail;
    @Column(length=50, nullable=false, name="name")
    private String sName;
    @Column(length=50, nullable=false, name="password")
    private String sPass;
    @ManyToMany(targetEntity=Course.class, fetch=FetchType.EAGER)
    private List<Course> sCourses;

    public Student() {
    }

    public Student (String sEmail, String sName, String sPass, List<Course> sCourses) {
        this.sEmail = sEmail;
        this.sName = sName;
        this.sPass = sPass;
        this.sCourses = sCourses;
    }

    public String getsEmail() {
        return sEmail;
    }

    public void setsEmail(String sEmail) {
        this.sEmail = sEmail;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPass() {
        return sPass;
    }

    public void setsPass(String sPass) {
        this.sPass = sPass;
    }

    public List<Course> getsCourses() {
        return sCourses;
    }

    public void setsCourses(List<Course> sCourses) {
        this.sCourses = sCourses;
    }


}




