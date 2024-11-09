package com.mfons_projects.walletapp.domain.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;
import java.util.List;

@Entity
@Getter
@Setter
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private Integer bvn;
    private boolean isLoggedIn;
    private BigInteger accountNumber;
    private String dateOfBirth;
    private String stateOfOrigin;
    private String country;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Wallet> wallet;
}
