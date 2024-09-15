package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Insurance")
public class Insurance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Insurance_ID")
    private Long insuranceId;

    @Column(name = "Name", length = 255)
    private String name;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Promotion_ID")
    private Long promotionId;

    @Column(name = "Type")
    private Integer type;

    @OneToMany(mappedBy = "insurance", cascade = CascadeType.ALL)
    private List<Cost> cost;
}

