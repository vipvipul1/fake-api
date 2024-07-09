package com.scaler.demo.fakeapi.inheritance.demo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_MENTOR")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Mentor extends User {
    private Double average_rating;
}
