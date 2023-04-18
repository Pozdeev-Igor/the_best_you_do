package com.example.thebest_youdo.service.impl;

import com.example.thebest_youdo.exception.ResourceNotFoundException;
import com.example.thebest_youdo.mapper.ServiceProductMapper;
import com.example.thebest_youdo.model.constant.ServiceStatusEnum;
import com.example.thebest_youdo.model.dto.request.ServiceRequest;
import com.example.thebest_youdo.model.dto.responce.ServiceProductDto;
import com.example.thebest_youdo.model.entity.Category;
import com.example.thebest_youdo.model.entity.ServiceProduct;
import com.example.thebest_youdo.model.entity.User;
import com.example.thebest_youdo.repository.CategoryRepository;
import com.example.thebest_youdo.repository.ServiceRepository;
import com.example.thebest_youdo.repository.UserRepository;
import com.example.thebest_youdo.service.ServicesService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ServicesServiceImpl implements ServicesService {

    private final ServiceRepository serviceRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository userRepository;
    private final ServiceProductMapper mapper;

    @Override
    public ResponseEntity<?> save(ServiceRequest request, UUID userId) {
        Category category = categoryRepository.findById(request.getCategoryId())
                .orElseThrow(NoSuchElementException::new);
        User userFromDB = userRepository.findById(userId)
                .orElseThrow(NoSuchElementException::new);

        ServiceProduct service = ServiceProduct.builder()
                .category(category)
                .title(request.getTitle())
                .description(request.getDescription())
                .createdBy(userFromDB)
                .price(request.getPrice())
                .status(ServiceStatusEnum.PUBLISHED.toString())
                .build();

        return ResponseEntity.ok(serviceRepository.save(service));
    }

    @Override
    public ResponseEntity<?> findAllByPagination(Integer page, Integer limit) {
        PageRequest pageRequest = PageRequest.of(page, limit);
        
        Page<ServiceProduct> serviceProductDtoPage = serviceRepository.findAll(pageRequest);
        List<ServiceProductDto> serviceProductDtos = mapper.serviceProductsToServiceProductsDto(serviceProductDtoPage.getContent());
        long totalElements = serviceProductDtoPage.getTotalElements();
        List<ServiceProductDto> collect = serviceProductDtos.stream().filter(x -> x.getStatus().equals(ServiceStatusEnum.PUBLISHED.toString())).collect(Collectors.toList());
        return ResponseEntity.ok().header("total", String.valueOf(totalElements)).body(collect);
    }

    @Override
    public ResponseEntity<?> deleteService(UUID serviceId, UUID userId) {
        ServiceProduct serviceProduct = serviceRepository.findByIdAndByUserId(serviceId, userId);
        serviceProduct.setStatus(ServiceStatusEnum.ARCHIVED.toString());
        serviceRepository.save(serviceProduct);

        return ResponseEntity.ok("Your service or product successfully deleted");
    }

    @Override
    public ServiceProductDto findById(UUID serviceId) {
        return mapper
                .serviceProductToServiceProductDto(
                        serviceRepository
                                .findById(serviceId)
                                .filter(x -> x.getStatus().equals(ServiceStatusEnum.PUBLISHED.toString()))
                                .orElseThrow(
                                        () -> new ResourceNotFoundException("there is no such service or product by provided id")));
    }

    @Override
    public ServiceProductDto modifyById(ServiceProductDto serviceProductDto, UUID serviceId) {
        ServiceProduct serviceProduct =
                serviceRepository.findById(serviceId)
                        .orElseThrow(() -> new ResourceNotFoundException("there is no such service or product by provided id"));
        serviceProduct.setTitle(serviceProductDto.getTitle());
        serviceProduct.setDescription(serviceProductDto.getDescription());
        serviceProduct.setPrice(serviceProductDto.getPrice());
        serviceProduct.setStatus(serviceProductDto.getStatus());
        serviceRepository.save(serviceProduct);
        return mapper.serviceProductToServiceProductDto(serviceProduct);
    }

}
