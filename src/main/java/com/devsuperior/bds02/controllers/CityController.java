package com.devsuperior.bds02.controllers;

import com.devsuperior.bds02.dto.CityDTO;
import com.devsuperior.bds02.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityController {
    
    @Autowired
    private CityService service;
    
    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll() {
        var citiesDto = service.findAll();
        return ResponseEntity.ok().body(citiesDto);
    }
    
    @PostMapping
    public ResponseEntity<CityDTO> insert(@RequestBody CityDTO dto) {
        var cityDto = service.insert(dto);
        var uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(dto.getId())
                .toUri();
        return ResponseEntity.created(uri).body(cityDto);
    }
    
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
