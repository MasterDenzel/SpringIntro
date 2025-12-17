package com.denzelcode.springfsintro.repositories;
import com.denzelcode.springfsintro.entities.Greeting;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
public class GreetingRepositoryTest {
    @Autowired
    private GreetingRepository greetingRepository;

    @Test
    public void testCreateGreeting(){
        //create
        Greeting greeting = new Greeting("Hello World");
        Greeting savedGreeting = greetingRepository.save(greeting);
        greetingRepository.save(new Greeting("Hello World"));

        assertThat(savedGreeting).isNotNull();
        assertThat(savedGreeting.getId()).isNotNull();
        assertThat(savedGreeting.getGreeting()).isEqualTo("Hello World");

    }

    @Test
    public void testReadGreeting(){
        //create and save
        Greeting greeting = new Greeting("Hello Test");
        Greeting savedGreeting = greetingRepository.save(greeting);

        // Read
        Optional<Greeting> foundGreeting = greetingRepository.findById(savedGreeting.getId());

        assertThat(foundGreeting).isPresent();
        assertThat(foundGreeting.get().getGreeting()).isEqualTo("Hello Test");

    }

    @Test
    public void testUpdateGreeting(){

        //create and save

        Greeting originalGreeting = new Greeting("Hello Test");
        Greeting savedGreeting = greetingRepository.save(originalGreeting);

        //update
        savedGreeting.setGreeting("Updated Test");
        Greeting updatedGreeting = greetingRepository.save(savedGreeting);

        assertThat(updatedGreeting.getGreeting()).isEqualTo("Updated Test");
        assertThat(updatedGreeting.getId()).isEqualTo(savedGreeting.getId());


    }

    @Test
    public void testDeleteGreeting(){
        //create and save

        Greeting Greeting = new Greeting("Hello Test");
        Greeting savedGreeting = greetingRepository.save(Greeting);
        Integer greetingId = savedGreeting.getId();

        //delete
        greetingRepository.delete(savedGreeting);

        //verify deletion
        Optional<Greeting> deletedGreeting = greetingRepository.findById(greetingId);
        assertThat(deletedGreeting).isEmpty();

    }

    @Test
    public void testFindAllGreetings(){
        // Create multiple greetings
        greetingRepository.save(new Greeting("First Greeting"));
        greetingRepository.save(new Greeting("Second Greeting"));

        // Find all
        Iterable<Greeting> allGreetings = greetingRepository.findAll();

        assertThat(allGreetings).hasSize(2);
    }
}
