package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Installment_Schedule")
public class InstallmentSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Installment_Schedule_ID")
    private Long installmentScheduleId;

    @Column(name = "Installment_Number")
    private Integer installmentNumber;

    @Column(name = "Due_Date")
    private LocalDate dueDate;

    @Column(name = "Amount")
    private Float amount;

    @Column(name = "Status")
    private Integer status;

    @ManyToOne
    @JoinColumn(name = "Installment_Plan_ID")
    private InstallmentPlan installmentPlan;

    @OneToMany(mappedBy = "installmentSchedule", cascade = CascadeType.ALL)
    private List<Payment> payments;

}

