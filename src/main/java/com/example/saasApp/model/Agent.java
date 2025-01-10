package com.example.saasApp.model;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table (name = "agent")
public class Agent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "parent_id")
    private long pId;
    @Column (name = "name")
    private String name;
    private String email;

    //    public long getpId() {
//        return pId;
//    }
//
//    public void setpId(long pId) {
//        this.pId = pId;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    //    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
//    private List <Customer> customers;
}
