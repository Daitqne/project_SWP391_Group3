package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "[Order]")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Order_ID")
    private Long orderId;

    @Column(name = "Created_At")
    private LocalDate createdAt;

    @Column(name = "Total_Amount")
    private Float totalAmount;

    @Column(name = "Promotion_ID")
    private Long promotionId;

    @ManyToOne
    @JoinColumn(name = "Customer_ID")
    private Customer customer;

    @OneToOne
    @JoinColumn(name = "Installment_Plan_ID", unique = true)
    private InstallmentPlan installmentPlan;

    @OneToOne
    @JoinColumn(name = "Cost_ID", unique = true)
    private Cost cost;

    @ManyToOne
    @JoinColumn(name = "Car_ID")
    private Car car;
}

