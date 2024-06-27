package com.app.gloesports.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.List;

/*
    task is to add the required annotation to make this class a JPA entity
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Users {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /*
        task is to add a new column name of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @NotNull
    private String name;
    /*
        task is to add a new column email of type String.
        It should not be null.
        It should be unique.
        Use appropriate annotation.
     */
    @NotNull
    @Column(unique = true)
    private String email;

    /*
        task is to establish the mapping between User and Equipment
        it should be a appropriate mapping as per the diagram
     */
    @OneToMany
    private List<Equipment> equipment;
}


