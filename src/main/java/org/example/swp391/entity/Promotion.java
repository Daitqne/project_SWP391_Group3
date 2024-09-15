package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.util.List;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "Promotion")
public class Promotion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Promotion_ID")
    private Long promotionId;

    @Column(name = "Detail", length = 255)
    private String detail;

    @Column(name = "Discount_Value")
    private Float discountValue;

    @Column(name = "Start_Time")
    private LocalDateTime startTime;

    @Column(name = "End_Time")
    private LocalDateTime endTime;

    @Column(name = "Image", length = 255)
    private String image;

    @Column(name = "Sponsors", length = 255)
    private String sponsors;

    @Column(name = "Type")
    private Integer type;

    @OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
    private List<CarPromotion> carPromotions;
}

