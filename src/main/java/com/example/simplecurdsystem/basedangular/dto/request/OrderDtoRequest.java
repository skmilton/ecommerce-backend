package com.example.simplecurdsystem.basedangular.dto.request;

import com.example.simplecurdsystem.basedangular.domain.OrderProduct;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDtoRequest {

    private BigDecimal totalPrice;

    private Date date = new Date();

    private Date deliveryDate;

    private int employeeInformation_id;

    List<OrderProduct> products = new ArrayList<>();
}
