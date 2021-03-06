package com.houseutils.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author namookk
 */
@Entity
@Getter
@Setter
public class Apartment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String address;

    @Column(nullable = false)
    private Long price;
}
