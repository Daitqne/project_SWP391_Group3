package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Car_Showroom")
public class CarShowroom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_Showroom_ID")
    private Long carShowroomId;

    @ManyToOne
    @JoinColumn(name = "Car_ID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "Showroom_ID")
    private Showroom showroom;

}
