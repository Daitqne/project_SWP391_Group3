package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Taxe")
public class Taxe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Taxe_ID")
    private Long taxeId;

    @Column(name = "Name", length = 255)
    private String name;

    @Column(name = "Price")
    private Float price;

    @Column(name = "Promotion_ID")
    private Long promotionId;

    @OneToMany(mappedBy = "taxe", cascade = CascadeType.ALL)
    private List<Cost> cost;
}

