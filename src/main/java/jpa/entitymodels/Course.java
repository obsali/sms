package jpa.entitymodels;

import javax.persistence.*;

@Entity
@Table(name="Course")
public class Course {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column(nullable=false,  unique=true, name="id")
    private int cid;
    @Column(length=50, nullable=false, name="name")
    private String cName;
    @Column(length=50, nullable=false, name="instructor")
    private String cInstructorName;

    public Course() {
    }

    public Course(int cid, String cName, String cInstructorName) {
        this.cid = cid;
        this.cName = cName;
        this.cInstructorName = cInstructorName;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcInstructorName() {
        return cInstructorName;
    }

    public void setcInstructorName(String cInstructorName) {
        this.cInstructorName = cInstructorName;
    }
}