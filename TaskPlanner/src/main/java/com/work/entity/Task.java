package com.work.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer taskId;

    private String taskName;
    private String taskDetails;
    private String duration;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private Sprint sprint;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.ALL)
    private List<User> users=new ArrayList<>();
}
