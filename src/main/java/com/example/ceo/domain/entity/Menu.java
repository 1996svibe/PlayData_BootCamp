package com.example.ceo.domain.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "Menus")
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@Getter
public class Menu {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer price;

    @ManyToOne
    private Store store;

}
