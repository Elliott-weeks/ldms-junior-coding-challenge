package com.example.challenge.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import static org.hamcrest.Matchers.is;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(BisectionMethodController.class)
@DisplayName("Unit :: Controller :: Bisection Method Controller")
@AutoConfigureRestDocs(outputDir = "target/docs")
public class BisectionMethodControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("Should find an acceptable root if when a valid a and b parameter is passed ")
    public void performValidRequest() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/BisectionMethodService?a=1&b=2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(jsonPath("$.root", is(1.5213804244995117))).andDo(document("BisectionMethodSuccess")); 


    }

    @Test
    @DisplayName("Should return 422 when a and b are identical")
    public void invalidRequestSameParms() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/BisectionMethodService?a=2&b=2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity()).andExpect(jsonPath("$.error", is("Illegal parameters a must be smaller than b"))).andDo(document("BisectionMethodInvalidSameParms"));


    }
    @Test
    @DisplayName("Should return 422 when a is b bigger than b")
    public void invalidRequestA_isBiggerThanB() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/BisectionMethodService?a=4&b=2")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity()).andExpect(jsonPath("$.error", is("Illegal parameters a must be smaller than b"))).andDo(document("BisectionMethodInvalidAbiggerthanBParms"));


    }
    @Test
    @DisplayName("Should return 422 when a and b are greater than doubles")
    public void invalidRequestToLargeParmsToBeDouble() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders
                .get("/BisectionMethodService?a=-9999999999999999999999&b=9999999999999999999999999999")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isUnprocessableEntity()).andExpect(jsonPath("$.error", is("The provided arguments resulted in no root being found within the max interval specified."))).andDo(document("BisectionMethodInvalidParamToLarge"));


    }

}
