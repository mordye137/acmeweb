package com.acme.statusmgr;

import com.acme.decorators.ServerStatusDecorator;
import com.acme.detailed.IDetails;
import com.acme.detailed.MockSystemDetails;
import com.acme.detailed.SystemDetails;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import static org.hamcrest.Matchers.is;

@SpringBootTest
@AutoConfigureMockMvc
public class ServerStatusFacadeTests {

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    public static void setup() {
        ServerStatusDecorator.detailsSetter(new MockSystemDetails());
    }

    @Test
    public void mock_detailed_no_name() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?details=availableProcessors"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Anonymous"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there are 4 processors available"));
    }

    @Test
    public void mock_detailed_name() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?name=Mordy&details=availableProcessors"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Mordy"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there are 4 processors available"));
    }

    @Test
    public void mock_all_fake_details() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?name=Mordy&details=availableProcessors,freeJVMMemory,totalJVMMemory,jreVersion,tempLocation"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Mordy"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there are 4 processors available," +
                        " and there are 127268272 bytes of JVM memory free," +
                        " and there is a total of 159383552 bytes of JVM memory," +
                        " and the JRE version is 15.0.2+7-27," +
                        " and the server's temp file location is M:\\\\AppData\\\\Local\\\\Temp"));
    }

    @Test
    public void mock_repeated_detail() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?name=Mordy&details=availableProcessors,availableProcessors"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.contentHeader").value("Server Status requested by Mordy"))
                .andExpect(jsonPath("$.statusDesc").value("Server is up, and there are 4 processors available, and there are 4 processors available"));
    }

    @Test
    public void mock_diff_order_details() throws Exception{
        this.mockMvc.perform(get("/server/status/detailed?details=tempLocation,totalJVMMemory,availableProcessors"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(jsonPath("$.statusDesc")
                        .value("Server is up," +
                                " and the server's temp file location is M:\\\\AppData\\\\Local\\\\Temp," +
                                " and there is a total of 159383552 bytes of JVM memory," +
                                " and there are 4 processors available"));
    }

    @Test
    public void correct_error() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?name=Mordy&details=availableProcessors,junkERROR"))
                .andDo(print()).andExpect(status().is4xxClientError());
    }
    @Test
    public void correct_error_message() throws Exception {
        this.mockMvc.perform(get("/server/status/detailed?name=Mordy&details=availableProcessors,junkERROR"))
                .andDo(print()).andExpect(status().reason(is("Invalid details option: junkERROR")));
    }

}


