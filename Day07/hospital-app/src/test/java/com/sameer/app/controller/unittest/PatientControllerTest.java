package com.sameer.app.controller.unittest;
import com.sameer.app.controller.PatientController;
import com.sameer.app.model.Patient;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@RunWith(MockitoJUnitRunner.class)
public class PatientControllerTest{
        @InjectMocks
        private PatientController patientController=new PatientController();

        @Test
        public void test_createPatient(){
            Patient patient=new Patient("abc", 12,"TATA","cancer");
            Patient result=patientController.createPatient(patient);
            assertEquals(patient.getName(),result.getName());
            assertEquals(patient.getAge(),result.getAge());
            assertEquals(patient.getHospitalName(),result.getHospitalName());
            assertEquals(patient.getDisease(),result.getDisease());
        }

        @Test
        public void test_readPatient(){
            Patient patient=new Patient("abc", 12,"TATA","cancer");
            patientController.createPatient(patient);
            Patient result=patientController.readPatient("abc");
            assertEquals("abc",result.getName());
            assertEquals(12,result.getAge());
            assertEquals("TATA",result.getHospitalName());
            assertEquals("cancer",result.getDisease());
        }

        @Test
        public void test_updatePatient(){
            Patient patient=new Patient("abc", 12,"TATA","cancer");
            patientController.createPatient(patient);
            Patient result=patientController.updatePatient("abc",13);
            assertEquals("abc",result.getName());
            assertEquals(13,result.getAge());
            assertEquals("TATA",result.getHospitalName());
            assertEquals("cancer",result.getDisease());
        }
        @Test
        public void test_deletePatient(){
            Patient patient=new Patient();
            patient.setAge(13);
            patient.setName("abc");
            patient.setHospitalName("TATA");
            patient.setDisease("cancer");
            patientController.createPatient(patient);
            patientController.deletePatient("abc");
            Patient result=patientController.readPatient("abc");
            assertNull(result);
        }
    }


