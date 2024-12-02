package com.example.json_viev.model;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonView(Views.UserSummary.class)
    private Long id;
    @JsonView(Views.UserSummary.class)
    private String name;
    @Email(message = "неверный формат электронной почты")
    @JsonView(Views.UserSummary.class)
    private String email;
    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonView(Views.UserDetails.class)
    private List<Order> orders;


}
