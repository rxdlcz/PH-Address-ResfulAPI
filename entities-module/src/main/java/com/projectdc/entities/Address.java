package com.projectdc.entities;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int id;

    public String code;

    public String name;

    @Column(name = "correspondence-code")
    public String correspondenceCode;

    @Column(name = "geographic-level")
    public String geographicLevel;

    @Column(name = "old-name")
    public String oldName;

    @Column(name = "city-class")
    public String cityClass;

    @Column(name = "income-class")
    public String incomeClass;

    @Column(name = "urban-rural")
    public String urbanRural;

    public long population;

    public String status;

}
