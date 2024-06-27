package com.app.gloesports.controller;

import com.app.gloesports.dto.EquipmentDto;
import com.app.gloesports.service.impl.EquipmentServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

// It is a controller class that handles the equipment related requests


@RestController
@RequestMapping("api/users")
public class EquipmentController {

    @Autowired
    private EquipmentServiceImpl equipmentService;

    // Add equipment to a user
    @PostMapping("/{id}/equipment")
    public ResponseEntity<EquipmentDto> addEquipment(@Valid @RequestBody EquipmentDto equipmentDto,@PathVariable Long id)
    {
        return new ResponseEntity<>(equipmentService.addEquipmentToUser(equipmentDto,id), HttpStatus.OK);
    }


    // Get equipment by equipmentId
    @GetMapping("{userId}/equipment/{EquipmentId}")
    public ResponseEntity<EquipmentDto> getEquipment(@Valid @PathVariable Long userId,@PathVariable Long EquipmentId )
    {
        return new ResponseEntity<>(equipmentService.getEquipmentById(userId,EquipmentId),HttpStatus.OK);
    }

    // Delete equipment from a User by equipmentId
    @DeleteMapping("{userId}/equipment/{EquipmentId}")
    public ResponseEntity<String> delete(@PathVariable Long userId,@PathVariable Long EquipmentId)
    {
        EquipmentDto equipmentDto = equipmentService.deleteEquipmentById( EquipmentId,userId);

        return new ResponseEntity<>("Equipment deleted with id"+equipmentDto.getId(),HttpStatus.OK);
    }
}
