package org.example.swp391.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Color")
public class Color {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Color_ID")
    private Long colorId;

    @Column(name = "Color_Name", length = 255)
    private String colorName;
}

