package com.stackroute.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Transient;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String emailId;
    private String name;
    private int age;
    private String gender;
    private String mobileNo;
    @Transient
    private String password;
    private List<String> genre;
    private String role = "user";
    private List<String> wishListStandalone;
    private List<String> wishListEpisodic;
    private List<String> historyStandalone;
    private List<String> historyEpisodic;
}
