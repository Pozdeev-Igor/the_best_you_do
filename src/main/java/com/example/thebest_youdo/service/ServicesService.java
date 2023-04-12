package com.example.thebest_youdo.service;

import com.example.thebest_youdo.model.dto.request.ServiceRequest;
import com.example.thebest_youdo.model.dto.responce.ServiceProductDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;


public interface ServicesService {
    ResponseEntity<?> save(ServiceRequest request, UUID userId);

    List<ServiceProductDto> findAllByPagination(Integer page, Integer limit);

    ResponseEntity<?> deleteService(UUID serviceId, UUID userId);

    ServiceProductDto findById(UUID serviceId);

    ServiceProductDto modifyById(ServiceProductDto serviceProductDto, UUID serviceId);
}
