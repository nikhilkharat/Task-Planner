package com.work.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Sprint {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sprintId;
    private String duration;
    private LocalDateTime localDateTime;
    private String department;

    @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "sprint")
    private List<Task>taskList=new ArrayList<>();
}
