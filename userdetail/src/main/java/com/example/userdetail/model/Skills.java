package com.example.userdetail.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "skill")
public class Skills {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date createed_date;
    private Date last_modified_date;
    private String name;
    private String status;
}
