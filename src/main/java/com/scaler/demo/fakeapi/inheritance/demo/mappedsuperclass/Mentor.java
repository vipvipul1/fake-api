package com.scaler.demo.fakeapi.inheritance.demo.mappedsuperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "MSC_MENTOR")
public class Mentor extends User {
    private Double average_rating;
}
