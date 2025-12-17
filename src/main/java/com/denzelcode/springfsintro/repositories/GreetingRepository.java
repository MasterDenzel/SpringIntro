package com.denzelcode.springfsintro.repositories;

import com.denzelcode.springfsintro.entities.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GreetingRepository extends JpaRepository<Greeting,Integer> {
}
