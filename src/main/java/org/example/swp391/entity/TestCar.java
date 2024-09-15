package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Test_Car")
public class TestCar {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Test_Car_ID")
    private Long testCarId;

    @Column(name = "Time")
    private LocalDateTime time;

    @Column(name = "Created_At")
    private LocalDate createdAt;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "Showroom_ID")
    private Showroom showroom;

    @OneToOne
    @JoinColumn(name = "Car_ID", unique = true)
    private Car car;
}

