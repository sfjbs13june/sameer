package com.sameer.hospitalapp.controller.componenttest;

import com.sameer.hospitalapp.controller.PrescriptionController;
import com.sameer.hospitalapp.model.Prescription;
import com.sameer.hospitalapp.repository.PrescriptionRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)

public class PrescriptionControllerWebTest {

    @InjectMocks
    private PrescriptionController prescriptionController;

    @Mock
    private PrescriptionRepository prescriptionRepository;

    @Mock
    private Prescription prescription;


    @Test
    public void saveprescription() {
        Prescription prescription = new Prescription();
        prescription.setPrescriptionId("11");
        prescription.setAppointmentId("ID01");
        prescription.setDescription("fever");
        prescription.setDoctorName("Mala");
        prescription.setPatientName("suresh");
        when(PrescriptionRepository.savePrescription(anyString()).thenReturn(prescription);
        Prescription result =PrescriptionController.savePrescription(prescription);
        assertEquals("11", result.getPrescriptionId());
        assertEquals("ID01", result.getAppointmentId());
        assertEquals("fever", result.getDescription());
        assertEquals("Mala", result.getPatientName());
        assertEquals("suresh", result.getDoctorName());
    }
    @Test
    public void getPrescriptionTest() {
        Prescription prescription = new Prescription("11", "ID01", "fever", "Mala", "suresh");
        when(PrescriptionRepository.getAllPrescriptions(anyString())).thenReturn(prescription);
        Prescription result = PrescriptionController.getAllPrescriptions("Mala");
        assertEquals("11", result.getPrescriptionId());
        assertEquals("ID01", result.getAppointmentId());
        assertEquals("fever", result.getDescription());
        assertEquals("Mala", result.getPatientName());
        assertEquals("suresh", result.getDoctorName());
    }



}

