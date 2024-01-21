package com.daylog.tomatolog.controller;

import com.daylog.tomatolog.config.SecurityConfig;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Import(SecurityConfig.class)
@WebMvcTest(MainController.class)
class MainControllerTest {

    private final MockMvc mockMvc;

    public MainControllerTest(@Autowired MockMvc mockMvc) {
        this.mockMvc = mockMvc;
    }

    @Test
    public void 홈버튼클릭시_루트페이지이동_파라미터없음() throws Exception {
        // given
        
        // when & then
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                ;

    }
}