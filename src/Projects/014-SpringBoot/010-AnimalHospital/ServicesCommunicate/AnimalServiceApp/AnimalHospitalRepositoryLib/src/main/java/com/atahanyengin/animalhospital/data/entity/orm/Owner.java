package com.atahanyengin.animalhospital.data.entity.orm;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "owners")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "owner_id")
    public int id;

    @Column(nullable = false)
    public String name;

    @Column(nullable = false, length = 9, unique = true)
    public String phone;

    @Column(nullable = false, length = 512)
    public String address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "owner", cascade = CascadeType.ALL)
    public Set<Animal> animals;

    @Override
    public int hashCode()
    {
        return id;
    }

    @Override
    public boolean equals(Object obj)
    {
        return obj instanceof Owner o && o.id == id;
    }
}
