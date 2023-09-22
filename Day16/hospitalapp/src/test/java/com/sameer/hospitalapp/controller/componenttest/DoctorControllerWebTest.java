package com.sameer.hospitalapp.controller.componenttest;

import com.sameer.hospitalapp.controller.DoctorController;
import com.sameer.hospitalapp.model.Appointment;
import com.sameer.hospitalapp.model.Prescription;
import com.sameer.hospitalapp.repository.AppointmentRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest({DoctorController.class})
@ActiveProfiles(value = "test")

public class DoctorControllerWebTest {

        @Autowired
        private MockMvc mockMvc;

        @InjectMocks
        private DoctorController doctorController;

        @Mock
        private AppointmentRepository appointmentRepository;


        @Test
        public void test_getAppointments() throws Exception {

                Prescription prescription = new Prescription("11", "ID01", "suresh", "Mala", "fever");
                Appointment appointment=new Appointment("ID01","suresh","Mala","22/09/2023","prescription");
                when(appointmentRepository.getAppointments(anyString())).thenReturn(appointment);
                Appointment result = (Appointment) doctorController.getAppointments("Mala");
                assertEquals("ID01",result.getAppointmentId());
                assertEquals("suresh",result.getPatientName());
                assertEquals("Mala",result.getDoctorName());
                assertEquals("22/09/2023",result.getDate());
                assertEquals(prescription,result.getPrescription());
        }

        @Test
        public void saveAppointmentTest(){
                Prescription prescription = new Prescription();
                prescription.setPrescriptionId("11");
                prescription.setAppointmentId("ID01");
                prescription.setDescription("fever");
                prescription.setDoctorName("Mala");
                prescription.setPatientName("suresh");
                Appointment appointment=new Appointment();
                appointment.setAppointmentId("11");
                appointment.setPatientName("suresh");
                appointment.setDoctorName("Mala");
                appointment.setDate("22/09/2023");
                appointment.setPrescription("prescription");
                when(appointmentRepository.getAppointments(anyString())).thenReturn(appointment);
                Appointment result = doctorController.saveAppointment(appointment);
                assertEquals("ID01",result.getAppointmentId());
                assertEquals("suresh",result.getPatientName());
                assertEquals("Mala",result.getDoctorName());
                assertEquals("22/09/2023",result.getDate());
                assertEquals(prescription,result.getPrescription());

        }

        }
