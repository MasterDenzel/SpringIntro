package com.denzelcode.springfsintro.services;

import com.denzelcode.springfsintro.entities.Greeting;
import com.denzelcode.springfsintro.model.GreetingDTO;
import com.denzelcode.springfsintro.repositories.GreetingRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class GreetingServiceTest {

    @Mock
    private GreetingRepository greetingRepository;

    private GreetingService greetingService;

    @BeforeEach
    void setUp() {
        greetingService = new GreetingServiceImpl(greetingRepository);
    }
    @Test
    void testGetGreeting_WhenEntitiesExist_ReturnsFirstEntity() {
        // Given
        Greeting greeting1 = new Greeting("Hello World");
        greeting1.setId(1);
        Greeting greeting2 = new Greeting("Good Morning");
        greeting2.setId(2);
        List<Greeting> greetings = Arrays.asList(greeting1, greeting2);

        when(greetingRepository.findAll()).thenReturn(greetings);

        // When
        GreetingDTO result = greetingService.getGreeting();

        // Then
        assertEquals(1, result.getId());
        assertEquals("Hello World", result.getGreeting());
    }

    @Test
    void testGetGreeting_WhenNoEntitiesExist_ReturnsNotFound() {
        // Given
        when(greetingRepository.findAll()).thenReturn(Collections.emptyList());

        // When
        GreetingDTO result = greetingService.getGreeting();

        // Then
        assertEquals("Greeting not found", result.getGreeting());
        assertNull(result.getId());
    }

}
