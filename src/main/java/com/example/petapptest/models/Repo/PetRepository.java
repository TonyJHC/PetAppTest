package com.example.petapptest.models.Repo;

import com.example.petapptest.models.Entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet,Long> {

}
