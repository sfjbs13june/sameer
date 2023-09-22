package com.sameer.app.controller.componenttest;
import com.google.gson.Gson;
import com.sameer.app.controller.HospitalController;
import com.sameer.app.model.Hospital;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import com.fasterxml.jackson.databind.ObjectMapper;

import static junit.framework.TestCase.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest({HospitalController.class})
@ActiveProfiles(value = "test")
public class HospitalControllerWebTest {
    @Autowired
    private MockMvc mockMvc;

    @Value("${patient.create.url}")
    String create_url;
    @Value("${patient.read.url}")
    String read_url;
    @Value("${patient.update.url}")
    String update_url;
    @Value("${patient.delete.url}")
    String delete_url;


    @Test
    public void test_createHospital() throws Exception {
        Hospital hospital = new Hospital(123, "TATA", "Pune");
        ResultActions resultActions=mockMvc.perform(post(create_url).contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals(123,result.getId());
        assertEquals("TATA",result.getHospitalName());
        assertEquals("Pune",result.getAddress());
    }

    @Test
    public void test_readHospital() throws Exception {
        Hospital hospital = new Hospital(123, "TATA", "Pune");
        ResultActions resultActions_create=mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(get("/read").param("hospitalName","TATA").accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals(123,result.getId());
        assertEquals("TATA",result.getHospitalName());
        assertEquals("Pune",result.getAddress());
    }

    @Test
    public void test_updateHospital() throws Exception {
        Hospital hospital = new Hospital(123, "TATA", "Pune");
        ResultActions resultActions_create=mockMvc.perform(post("/create").contentType(MediaType.APPLICATION_JSON)
                .content(asJsonString(hospital)).accept(MediaType.APPLICATION_JSON));
        resultActions_create.andExpect(status().isOk());
        ResultActions resultActions=mockMvc.perform(put("/update")
                .param("hospital","TATA")
                .param("id","124")
                .accept(MediaType.APPLICATION_JSON));
        resultActions.andExpect(status().isOk());
        String result_string=resultActions.andReturn().getResponse().getContentAsString();
        assertNotNull(result_string);
        Gson g = new Gson();
        Hospital result = g.fromJson(result_string, Hospital.class);
        assertEquals(123,result.getId());
        assertEquals("TATA",result.getHospitalName());
        assertEquals("Pune",result.getAddress());
    }

    @Test
    public void test_deleteHospital() {

    }

    private String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
