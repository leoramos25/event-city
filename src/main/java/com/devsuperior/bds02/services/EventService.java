package com.devsuperior.bds02.services;

import com.devsuperior.bds02.dto.EventDTO;
import com.devsuperior.bds02.entities.City;
import com.devsuperior.bds02.entities.Event;
import com.devsuperior.bds02.repositories.EventRepository;
import com.devsuperior.bds02.services.exceptions.ControllerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;
    
    @Transactional
    public EventDTO update(Long id, EventDTO dto) {
        try {
            var event = repository.getOne(id);
            event.setName(dto.getName());
            event.setDate(dto.getDate());
            event.setUrl(dto.getUrl());
            event.setCity(new City(dto.getCityId(), null));
            event = repository.save(event);
            return new EventDTO(event);
        } catch (EntityNotFoundException error) {
            throw new ControllerNotFoundException("Id not found " + 1);
        }
    }
    
}
