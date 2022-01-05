package com.example.simplecurdsystem.basedangular.dto.response;

import com.example.simplecurdsystem.basedangular.domain.EmployeeInformation;
import com.example.simplecurdsystem.basedangular.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartDtoResponse {

    private String id;
    private EmployeeInformation employeeInformation;
    private List<Product> products;
}
