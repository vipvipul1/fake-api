package com.scaler.demo.fakeapi.inheritance.demo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.JOINED)
@Entity(name = "JT_USER")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
