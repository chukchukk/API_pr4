package com.example.demo.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "joke")
@Data
public class Joke {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Enumerated(EnumType.STRING)
    private Type jokeType;

    private String value;

    public enum Type{
        POLITICAL, HOUSEHOLD, ABSURD, CHILDLIKE, PHILOSOPHICAL, NATIONAL;
    }

}
