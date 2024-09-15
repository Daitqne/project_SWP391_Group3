package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Car_Promotion")
public class CarPromotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Car_Promotion_ID")
    private Long carPromotionId;

    @ManyToOne
    @JoinColumn(name = "Car_ID")
    private Car car;

    @ManyToOne
    @JoinColumn(name = "Promotion_ID")
    private Promotion promotion;

}
