package dev.legol4.moustacheshop.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class OrderDetailModel {
    private String id;
    private int cantidad;
    private double precioVenta;
    private double total;
    private ProductModel producto;
}
