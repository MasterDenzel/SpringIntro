package com.denzelcode.springfsintro.controller;

import com.denzelcode.springfsintro.model.GreetingDTO;
import com.denzelcode.springfsintro.services.GreetingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class GreetingControllerTest {

    @Mock
    private GreetingService greetingService;

    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        GreetingController greetingController = new GreetingController(greetingService);
        mockMvc = MockMvcBuilders.standaloneSetup(greetingController).build();
    }

    @Test
    void testGetGreeting() throws Exception {
        // Given
        GreetingDTO expectedGreeting = new GreetingDTO(1, "Hello World");
        when(greetingService.getGreeting()).thenReturn(expectedGreeting);

        // When & Then
        mockMvc.perform(get("/api/v1/greeting"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Id").value(1))
                .andExpect(jsonPath("$.greeting").value("Hello World"));
    }
}