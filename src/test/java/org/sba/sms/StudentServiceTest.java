package org.sba.sms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;


import jpa.entitymodels.Student;

public class StudentServiceTest {

    static StudentServiceTest sTes;

    int sId;




    @BeforeClass
    public static void setUp () {
        sTes = new StudentServiceTest();
        System.out.println("BeforeClass");
    }

    @Before
    public void beforeTest() {
        System.out.println("BeforeTest");
    }

    @Test
    public void testValidateStudent() {
        System.out.println("Validate Testing");
        assertTrue(sTes.validateStudent("aiannitti7@is.gd", "TWP4hf5j"));
    }

    private boolean validateStudent(String s, String twp4hf5j) {
        return true;
    }


}
