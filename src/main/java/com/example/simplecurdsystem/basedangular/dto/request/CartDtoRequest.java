package com.example.simplecurdsystem.basedangular.dto.request;

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
public class CartDtoRequest {
    private EmployeeInformation employeeInformation;
    private List<Product> products;
}
