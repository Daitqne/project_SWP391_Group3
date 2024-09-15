package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Cost")
public class Cost {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Cost_ID")
    private Long costId;

    @ManyToOne
    @JoinColumn(name = "Insurance_ID")
    private Insurance insurance;

    @ManyToOne
    @JoinColumn(name = "Taxe_ID")
    private Taxe taxe;

}

