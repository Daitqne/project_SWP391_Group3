package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Interest_Bank")
public class InterestBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Interest_Bank_ID")
    private Long interestBankId;

    @Column(name = "Bank_Name", length = 255)
    private String bankName;

    @Column(name = "First_Interest")
    private Float firstInterest;

    @Column(name = "Next_Interest")
    private Float nextInterest;

    @Column(name = "Max_Loan_Interest")
    private Float maxLoanInterest;

    @Column(name = "Loan_Time")
    private Integer loanTime;

    @OneToOne(mappedBy = "interestBank", cascade = CascadeType.ALL)
    private InstallmentPlan installmentPlan;
}

