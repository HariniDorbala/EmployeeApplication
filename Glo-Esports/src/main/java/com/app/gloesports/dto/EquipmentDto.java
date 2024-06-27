package com.app.gloesports.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * equipment type should not be null or blank
      * equipment brand should not be null or blank
      * equipment model should not be null or blank
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class EquipmentDto {

    private Long id;
    @NotNull(message = "type is a mandatory feild")
    @Size(min = 1)
    private String type;
    @NotNull(message = "type is a mandatory feild")
    @Size(min = 1)
    private String brand;
    @NotNull(message = "type is a mandatory feild")
    @Size(min = 1)
    private String model;
}