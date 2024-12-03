package com.example.json_viev.model;

import com.example.json_viev.custom.Status;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserDetails.class)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
    @JsonView(Views.UserDetails.class)
    private List<Product> products;
    @Transient
    @JsonView(Views.UserDetails.class)
    private double summ;
    @Enumerated(value = EnumType.STRING)
    @JsonView(Views.UserDetails.class)
    private Status status;

    public Order(Long id, List<Product> products, Status status) {
        this.id = id;
        this.products = products;
        this.status = status;
    }

    public void calculateSumm() {
        summ = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
    }
}
