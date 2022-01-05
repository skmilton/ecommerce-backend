package com.example.simplecurdsystem.basedangular.domain;

import lombok.Data;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;
@Data
@Entity
@Table(name = "cart")
public class Cart extends BaseEntity{
    @ManyToOne
    @JoinColumn(name = "employee_information_id")
    private EmployeeInformation employeeInformation;
    @OneToMany(cascade = CascadeType.ALL)
    Set<OrderProduct> products =new HashSet<>();
}
