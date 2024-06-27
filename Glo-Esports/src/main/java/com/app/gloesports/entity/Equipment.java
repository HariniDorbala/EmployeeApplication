package com.app.gloesports.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    task is to add the required annotation to make this class a JPA entity
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Equipment {

    /*
        task is to add a new column id of type Long.
        It should support the auto-generation of the primary key.
        Use appropriate annotation.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    /*
        task is to add a new column type of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @NotNull(message = "type is a mandatory feild")

    private String type;
    /*
        task is to add a new column brand of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @NotNull(message = "brand is a mandatory feild")
    private String brand;
    /*
        task is to add a new column model of type String.
        It should not be null.
        Use appropriate annotation.
     */
    @NotNull(message = "model is a mandatory feild")
    private String model;

    /*
        task is to establish the mapping between User and Equipment
        it should be a appropriate mapping as per the diagram
     */
    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;
}
