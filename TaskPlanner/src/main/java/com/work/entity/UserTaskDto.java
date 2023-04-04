package com.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserTaskDto {

    private String fullName;
    private String duration;
    private LocalDateTime localDateTime;
    private String department;
    private String taskName;
    private String taskDetails;

}
