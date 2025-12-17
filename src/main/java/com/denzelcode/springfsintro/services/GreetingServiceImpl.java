package com.denzelcode.springfsintro.services;

import com.denzelcode.springfsintro.entities.Greeting;
import com.denzelcode.springfsintro.model.GreetingDTO;
import com.denzelcode.springfsintro.repositories.GreetingRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GreetingServiceImpl implements GreetingService {

    private final GreetingRepository greetingRepository;

    public GreetingServiceImpl(GreetingRepository greetingRepository) {
        this.greetingRepository = greetingRepository;
    }

    @Override
    public GreetingDTO getGreeting() {
        List<Greeting> greetings = greetingRepository.findAll();

        if(greetings.isEmpty()){
            return new GreetingDTO("Greeting not found");
        }

        Greeting greeting = greetings.getFirst();
        return new GreetingDTO(greeting.getId(),greeting.getGreeting());
    }
}
