package com.example.simplecurdsystem.basedangular.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@Entity
@Table(name = "orders")
@JsonPropertyOrder
//@JsonIdentityInfo()
public class Order extends BaseEntity{

    private BigDecimal totalPrice;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date date = new Date();

    @DateTimeFormat(pattern="dd/MM/yyyy")
    private Date deliveryDate;

    private int employeeInformation_id;

    @OneToMany(cascade = CascadeType.ALL)
    List<OrderProduct> products = new ArrayList<>();
}
