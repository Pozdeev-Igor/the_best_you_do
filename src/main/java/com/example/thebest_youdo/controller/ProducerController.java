package com.example.thebest_youdo.controller;

import com.example.thebest_youdo.model.dto.request.ServiceRequest;
import com.example.thebest_youdo.model.dto.responce.ServiceProductDto;
import com.example.thebest_youdo.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("api/auth/producer")
@RequiredArgsConstructor
public class ProducerController {

    private final ServicesService servicesService;

    @PostMapping("/create")
    public ResponseEntity<?> createNewService(@RequestBody ServiceRequest request, @RequestParam UUID userId) {

        return ResponseEntity.ok(servicesService.save(request, userId));
    }

    @DeleteMapping("/delete/{userId}/{serviceId}")
    public ResponseEntity<?> deleteService(@PathVariable UUID serviceId, @PathVariable UUID userId) {

        return servicesService.deleteService(serviceId, userId);
    }

    @GetMapping("/{serviceId}")
    public ResponseEntity<ServiceProductDto> getServiceProduct(@PathVariable UUID serviceId) {

        return ResponseEntity.ok(servicesService.findById(serviceId));
    }

    @PatchMapping("/{serviceId}/modify")
    public ResponseEntity<ServiceProductDto> modifyServiceProduct(@RequestBody ServiceProductDto serviceProductDto, @PathVariable UUID serviceId) {

        return ResponseEntity.ok(servicesService.modifyById(serviceProductDto, serviceId));
    }
}
