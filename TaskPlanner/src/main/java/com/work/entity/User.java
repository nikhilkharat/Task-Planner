package com.work.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userId;

    @Pattern(regexp = "^[a-zA-Z]+$", message = "First name must not contain numbers or special characters")
    private String fullName;

    @Size(min = 10, max = 10, message = "Mobile number must have 10 digits")
    @Digits(integer = 10, fraction = 0, message = "Mobile number must have 10 digits")
    private String mobileNumber;

    @Min(value = 12, message = "Age must be above 12 years")
    private int age;

    @Email
    private String email;

    private String userType;

    private String gender;

    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{6,12}$", message = "Password should be alphanumeric and must contain 6-12 characters having at least one special character, one upper case, one lowercase, and one digit")
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private List<Sprint>sprintList=new ArrayList<>();

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL,mappedBy = "users")
    private List<Task>tasks=new ArrayList<>();
}
