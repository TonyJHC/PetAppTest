package com.example.petapptest.controller;

import com.example.petapptest.models.Entity.Pet;
import com.example.petapptest.models.PetRepository;
import com.example.petapptest.models.Dto.PetReqDto;
import com.example.petapptest.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class PetController {

    private final PetRepository petRepository;
    private final PetService petService;

    @GetMapping("/api/pets")
    public List<Pet> getPets() {
        System.out.println("GET ALL----");
        return petRepository.findAll();
    }

    @GetMapping("/api/pets/{id}")
    public Optional<Pet> getPet(@PathVariable Long id) {
        Optional<Pet> pet = petRepository.findById(id);
        System.out.println("GET ONE----");

        return pet;
    }

    @PostMapping("/api/pets")
    public Long postPet(@RequestBody PetReqDto petReqDto) {
        Pet pet = new Pet(petReqDto);
        petRepository.save(pet);
        System.out.println("POST----");
        return pet.getId();
    }

    @PutMapping("/api/pets/{id}")
    public Long putPet(@RequestBody PetReqDto petReqDto, @PathVariable Long id) {
        petService.update(id, petReqDto);
        System.out.println("PUT----");

        return id;
    }

    @DeleteMapping("/api/pets")
    public Long deletePet(@PathVariable Long id) {
        petRepository.deleteById(id);
        System.out.println("DELETE----");
        return id;
    }


}
