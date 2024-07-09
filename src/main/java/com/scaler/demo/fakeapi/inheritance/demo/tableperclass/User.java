package com.scaler.demo.fakeapi.inheritance.demo.tableperclass;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Entity(name = "TPC_USER")
public class User {
    @Id
    private Long id;
    private String name;
    private String email;
}
