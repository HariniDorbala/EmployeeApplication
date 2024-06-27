package com.app.gloesports.dto;

import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/*
    * Add the appropriate annotation for the fields to handle the validation
      using hibernate validator. Requirements are:
      * user name should not be null or empty and should have a minimum of 5 characters
      * user email should be a valid email
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserDto {

    private Long id;

    @Size(min = 6,message = "Username should be minimum 6 characters")
    private String name;
    @Email(message = "please proovide a valid email")
   // @Pattern(regexp = "[A-Za-z0-9]+@[a-zA-Z]+.{1}[a-zA-Z]{2,3}")
    private String email;

    private List<EquipmentDto> equipment;
}