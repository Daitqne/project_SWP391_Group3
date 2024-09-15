package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Showroom")
public class Showroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Showroom_ID")
    private Long showroomId;

    @Column(name = "Address", length = 255)
    private String address;

    @ManyToOne
    @JoinColumn(name = "Employee_ID")
    private Employee employee;

    @OneToMany(mappedBy = "showroom", cascade = CascadeType.ALL)
    private List<CarShowroom> carShowrooms;

    @OneToMany(mappedBy = "showroom", cascade = CascadeType.ALL)
    private List<TestCar> testCars;

}
