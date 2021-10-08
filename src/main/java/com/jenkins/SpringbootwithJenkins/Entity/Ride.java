package com.jenkins.SpringbootwithJenkins.Entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

@Entity
@Getter
@ToString
@NoArgsConstructor
public class Ride {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private String description;
    private int speed;
    private int review;

    public Ride(String name, String description, int speed, int review) {
        this.name = name;
        this.description = description;
        this.speed = speed;
        this.review = review;
    }
}
