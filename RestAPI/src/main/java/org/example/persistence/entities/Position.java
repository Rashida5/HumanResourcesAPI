package org.example.persistence.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "positions", schema = "humanresources")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id", nullable = false)
    private Integer id;

    @Column(name = "position_name")
    private String positionName;

    @Column(name = "salary", precision = 10, scale = 2)
    private Integer salary;

    @OneToMany(mappedBy = "position")
    private Set<Employee> employees = new LinkedHashSet<>();

}