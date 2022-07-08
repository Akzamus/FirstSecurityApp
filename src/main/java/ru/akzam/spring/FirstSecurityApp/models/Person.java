package ru.akzam.spring.FirstSecurityApp.models;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Person")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @NotEmpty(message = "Username should not be empty")
    @Size(min = 2, max = 100, message = "Username length should be from 2 to 100 characters")
    @Column(name = "username")
    private String username;

    @Min(value = 1900, message = "Year of Birth should not be less than 1900")
    @Column(name = "year_of_birth")
    private int yearOfBirth;

    @NotEmpty(message = "Password should not bge empty")
    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;

    public Person(String username, int yearOfBirth) {
        this.username = username;
        this.yearOfBirth = yearOfBirth;
    }
}
