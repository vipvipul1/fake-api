package com.scaler.demo.fakeapi.inheritance.demo.joinedtable;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_INSTRUCTOR")
@PrimaryKeyJoinColumn(name = "USER_ID")
public class Instructor extends User {
    private String specialization;
}
