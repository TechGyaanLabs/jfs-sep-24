package com.careerit.iplstats.domain;


import com.careerit.iplstats.enums.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@Table(name = "player_details")
public class Player {

        @Id
        @GeneratedValue(strategy = GenerationType.UUID)
        private UUID id;
        @Column(name = "name")
        private String name;
        @Enumerated(EnumType.STRING)
        private Role role;
        @Column(name = "country")
        private String country;
        @Column(name = "team")
        private String team;
        @Column(name = "price")
        private double price;
}
