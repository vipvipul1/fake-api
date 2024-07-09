package com.scaler.demo.fakeapi.inheritance.demo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MSC_INSTRUCTOR")
public class Instructor extends User {
    private String specialization;
}
