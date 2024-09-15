package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Payment_ID")
    private Long paymentId;

    @Column(name = "Payment_Date")
    private LocalDate paymentDate;

    @Column(name = "Amount")
    private Float amount;

    @Column(name = "Payment_Method", length = 255)
    private String paymentMethod;

    @ManyToOne
    @JoinColumn(name = "Installment_Schedule_ID")
    private InstallmentSchedule installmentSchedule;
}

