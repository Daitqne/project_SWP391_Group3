package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Installment_Plan")
public class InstallmentPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Installment_Plan_ID")
    private Long installmentPlanId;

    @Column(name = "Installment_Number")
    private Integer installmentNumber;

    @Column(name = "Start_Date")
    private LocalDate startDate;

    @Column(name = "End_Date")
    private LocalDate endDate;

    @OneToOne
    @JoinColumn(name = "Interest_Bank_ID", unique = true)
    private InterestBank interestBank;

    @OneToMany(mappedBy = "installmentPlan", cascade = CascadeType.ALL)
    private List<InstallmentSchedule> installmentSchedules;

    @OneToOne(mappedBy = "installmentPlan", cascade = CascadeType.ALL)
    private Order order;
}

