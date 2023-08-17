package com.example.userdetail.model;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Table(name = "user_detail")
@Entity
public class UserDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long user_id;
    private Date created_date;
    private Date last_modified_date;
    private String avatar;
    private Date date_of_birth;
    private String fullname;
    private boolean gender;
    private String phone;



}
