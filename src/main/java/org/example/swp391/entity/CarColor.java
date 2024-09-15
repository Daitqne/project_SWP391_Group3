package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Car_Color")
public class CarColor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_Color_ID")
    private Long carColorId;

    @Column(name = "Image", length = 255)
    private String image;

    @ManyToOne
    @JoinColumn(name = "Car_ID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "Color_ID")
    private Color color;

}

