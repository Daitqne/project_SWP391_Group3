package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Employee_ID")
    private Long employeeId;

    @OneToOne
    @JoinColumn(name = "Account_ID", unique = true)
    private Account account;

    @ManyToOne
    @JoinColumn(name = "Role_ID")
    private Role role;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Showroom> showrooms;
}
