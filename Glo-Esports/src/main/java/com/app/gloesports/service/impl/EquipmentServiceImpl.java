package com.app.gloesports.service.impl;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.dto.UserDto;
import com.app.gloesports.entity.Equipment;
import com.app.gloesports.entity.Users;
import com.app.gloesports.exception.ResourceNotFoundException;
import com.app.gloesports.repository.EquipmentRepository;
import com.app.gloesports.repository.UserRepository;
import com.app.gloesports.service.EquipmentService;
import com.app.gloesports.utils.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// make this into a service layer for Equipment entity

@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Autowired
    private Mapper modelmapper;

    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserServiceImpl userService;
    @Override
    public EquipmentDto addEquipmentToUser(EquipmentDto equipmentDto, Long userId) {

        Optional<Users> u = userRepository.findById(userId);
        if(u.isEmpty())
            throw new ResourceNotFoundException("post","addEquipmentToUser",userId);
        else
        {
            Equipment equipment = modelmapper.mapToEquipmentEntity(equipmentDto);
            equipment.setUser(u.get());
            Equipment e2=equipmentRepository.save(equipment);
            return modelmapper.mapToEquipmentDto(e2);
        }
    }

    @Override
    public EquipmentDto getEquipmentById(Long userId, Long equipmentId) {
        Optional<Users> u = userRepository.findById(userId);
        if(u.isEmpty())
            throw new ResourceNotFoundException("user","userId",userId);
        else
        {
            Users u1 = u.get();
            Optional<Equipment> equipment = equipmentRepository.findById(equipmentId);
            return modelmapper.mapToEquipmentDto(equipment.get());
        }
    }

    @Override
    public EquipmentDto deleteEquipmentById(Long equipmentId, Long userId) {

        Optional<Users> u = userRepository.findById(userId);
        if(u.isEmpty())
            throw new ResourceNotFoundException("user","userId",userId);
        else{


            Optional<Equipment> e = equipmentRepository.findById(equipmentId);
            if(e.isEmpty())
            {
                throw new ResourceNotFoundException("equipment","equipmentId",equipmentId);
            }
            equipmentRepository.deleteById(equipmentId);
            return modelmapper.mapToEquipmentDto(e.get());


        }
    }
}
