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
public class Producer {
    @Id
    private String emailId;
    private String name;
    private int age;
    private String gender;
    private String mobileNo;
    @Transient
    private String password;
    private List<String> uploadedStandalone;
    private List<String> uploadedEpisodic;
    private String role = "producer";
}