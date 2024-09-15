package org.example.swp391.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "Account")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Account_ID")
    private Long accountId;

    @Column(name = "Address", length = 255)
    private String address;

    @Column(name = "Date_Of_Birth")
    private Date dateOfBirth;

    @Column(name = "Email", length = 255)
    private String email;

    @Column(name = "Full_Name", length = 255)
    private String fullName;

    @Column(name = "Gender")
    private Integer gender;

    @Column(name = "Image", length = 255)
    private String image;

    @Column(name = "Identity_Card", length = 255)
    private String identityCard;

    @Column(name = "Phone_Number", length = 30)
    private String phoneNumber;

    @Column(name = "Register_Date")
    private Date registerDate;

    @Column(name = "Username", length = 30)
    private String username;

    @Column(name = "Password", length = 30)
    private String password;

    @Column(name = "Status")
    private Integer status;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Customer customer;

    @OneToOne(mappedBy = "account", cascade = CascadeType.ALL)
    private Employee employee;
}
