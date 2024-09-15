package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Car")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_ID")
    private Long carId;

    @Column(name = "Make", length = 30)
    private String make;

    @Column(name = "Model", length = 30)
    private String model;

    @Column(name = "Year_Of_Manufacture")
    private LocalDate yearOfManufacture;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Description", length = 255)
    private String description;

    @Column(name = "Fuel_Type", length = 255)
    private String fuelType;

    @Column(name = "Transmission", length = 255)
    private String transmission;

    @Column(name = "Engine", length = 255)
    private String engine;

    @Column(name = "Created_At")
    private LocalDate createdAt;

    @Column(name = "Status")
    private Integer status;

    @Column(name = "Quantity")
    private Integer quantity;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarPromotion> carPromotions;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<CarShowroom> carShowrooms;

    @OneToOne(mappedBy = "car", cascade = CascadeType.ALL)
    private TestCar testCar;

    @OneToMany(mappedBy = "car", cascade = CascadeType.ALL)
    private List<Order> orders;
}

