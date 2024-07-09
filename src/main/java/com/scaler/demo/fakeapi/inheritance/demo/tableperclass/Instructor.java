package com.scaler.demo.fakeapi.inheritance.demo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_INSTRUCTOR")
public class Instructor extends User {
    private String specialization;
}
