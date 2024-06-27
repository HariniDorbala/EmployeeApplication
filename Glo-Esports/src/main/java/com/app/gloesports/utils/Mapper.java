package com.app.gloesports.utils;

import com.app.gloesports.GloEsportsApplication;
import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.Equipment;
import com.app.gloesports.entity.Users;
import org.springframework.stereotype.Component;

/*
    This class is used to map the entity to dto and vice versa
    for the user and product entity
 */
@Component
public class Mapper {
    // map the user entity to user dto
    public static UserDto mapToUserDto(Users user) {
        return GloEsportsApplication.modelMapper().map(user, UserDto.class);
    }

    // map the user dto to user entity
    public static Users mapToUserEntity(UserDto userDto) {
        return GloEsportsApplication.modelMapper().map(userDto, Users.class);
    }

    // map the equipment entity to equipment dto
    public static EquipmentDto mapToEquipmentDto(Equipment equipment) {
        return GloEsportsApplication.modelMapper().map(equipment, EquipmentDto.class);
    }

    // map the equipment dto to equipment entity
    public static Equipment mapToEquipmentEntity(EquipmentDto equipmentDto) {
        return GloEsportsApplication.modelMapper().map(equipmentDto, Equipment.class);
    }

}
