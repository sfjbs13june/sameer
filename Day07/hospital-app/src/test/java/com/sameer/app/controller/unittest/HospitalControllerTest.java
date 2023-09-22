package com.sameer.app.controller.unittest;
import com.sameer.app.controller.HospitalController;
import com.sameer.app.model.Hospital;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;


@RunWith(MockitoJUnitRunner.class)
public class HospitalControllerTest{
    @InjectMocks
    private HospitalController hospitalController=new HospitalController();

    @Test
    public void test_createHospital(){
        Hospital hospital=new Hospital(123,"TATA","Pune");
        Hospital result=hospitalController.createHospital(hospital);
        assertEquals(hospital.getId(),result.getId());
        assertEquals(hospital.getHospitalName(),result.getHospitalName());
        assertEquals(hospital.getAddress(),result.getAddress());
    }

    @Test
    public void test_readHospital(){
        Hospital hospital=new Hospital(123,"TATA","Pune");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.readHospital("TATA");
        assertEquals(123,result.getId());
        assertEquals("TATA",result.getHospitalName());
        assertEquals("Pune",result.getAddress());
    }

    @Test
    public void test_updateHospital(){
        Hospital hospital=new Hospital(123,"TATA","Pune");
        hospitalController.createHospital(hospital);
        Hospital result=hospitalController.readHospital("TATA");
        assertEquals(123,result.getId());
        assertEquals("TATA",result.getHospitalName());
        assertEquals("Pune",result.getAddress());
    }
    @Test
    public void test_deleteHospital(){
        Hospital hospital=new Hospital();
        hospital.getId();
        hospital.setHospitalName("TATA");
        hospital.setAddress("Pune");
        hospitalController.createHospital(hospital);
        hospitalController.deleteHospital("TATA");
        Hospital result=hospitalController.readHospital("TATA");
        assertNull(result);
    }
}


