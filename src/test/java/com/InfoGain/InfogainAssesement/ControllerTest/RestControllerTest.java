package com.InfoGain.InfogainAssesement.ControllerTest;


import com.InfoGain.InfogainAssesement.root.RestController;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Ignore
@RunWith(MockitoJUnitRunner.class)
public class RestControllerTest {

    private final String REST_CALL = "/v1/getCustomerList";
    private final String LIST_CALL = "/v1/getCustomerPoints/1";

    private MockMvc mvc;

    @InjectMocks
    private RestController restController;

    @Before
    public void setUp() {
        mvc = MockMvcBuilders.standaloneSetup(restController).build();
    }
    @Test
    public void testCustomerList() throws Exception{
        // HttpHeaders headers; if necessary
        mvc.perform(MockMvcRequestBuilders.get(REST_CALL)).andExpect(status().isOk());
    }

    @Test
    public void getCustomerRewards() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get(LIST_CALL)).andExpect(status().isOk());
    }

}
