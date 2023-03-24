package com.work.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CurrentSession {

    @Id
    @Column(unique = true)
    private Integer Id;
    private String type;
    private String uuid;
    private LocalDateTime localDateTime;
}
