package com.sameer.app.controller.unittest;
import com.sameer.app.controller.PatientController;
import com.sameer.app.model.Patient;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest{
        @InjectMocks
        private PatientController PatientController=new PatientController();

        @Test
        public void test_createPatient(){
            Student patient=new Patient("stud1", "123",12,"std7");
            Student result=PatientController.createPatient(patient);
            assertEquals(patient.getName(),result.getName());
            assertEquals(patient.getId(),result.getId());
            assertEquals(patient.getHospitalName(),result.getHospitalName());
            assertEquals(patient.getDisease(),result.getDisease());
        }

        @Test
        public void test_readeStudent(){
            Student student=new Student("stud1", "123",12,"std7");
            PatientController.createStudent(student);
            Student result=PatientController.readeStudent("stud1");
            assertEquals("stud1",result.getName());
            assertEquals("123",result.getRollNo());
            assertEquals("std7",result.getStd());
            assertEquals(12,result.getAge());
        }

        @Test
        public void test_updateStudent(){
            Student student=new Student("stud1", "123",12,"std7");
            PatientController.createStudent(student);
            Student result=PatientController.updateStudent("stud1",13);
            assertEquals("stud1",result.getName());
            assertEquals("123",result.getRollNo());
            assertEquals("std7",result.getStd());
            assertEquals(13,result.getAge());

        }

        @Test
        public void test_deleteStudent(){
            Student student=new Student();
            student.setAge(12);
            student.setName("stud1");
            student.setStd("std8");
            student.setRollNo("123");
            PatientController.createStudent(student);
            PatientController.deleteStudent("stud1");
            Student result=PatientController.readeStudent("stud1");
            assertNull(result);
        }
    }

}
