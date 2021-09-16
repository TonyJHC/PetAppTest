package com.example.petapptest.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Pet extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String petName1;

    @Column(nullable = false)
    private String petName2;


    public Pet(@RequestBody PetReqDto petReqDto) {
        this.name = petReqDto.getName();
        this.email = petReqDto.getEmail();
        this.petName1 = petReqDto.getPetName1();
        this.petName2 = petReqDto.getPetName2();

    }

    public void update(PetReqDto petReqDto) {
        this.name = petReqDto.getName();
        this.email = petReqDto.getEmail();
        this.petName1 = petReqDto.getPetName1();
        this.petName2 = petReqDto.getPetName2();

    }


}
