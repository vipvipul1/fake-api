package com.scaler.demo.fakeapi.inheritance.demo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "TPC_MENTOR")
public class Mentor extends User {
    private Double averageRating;
}
