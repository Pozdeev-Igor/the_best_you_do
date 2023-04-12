package com.example.thebest_youdo.mapper;

import com.example.thebest_youdo.model.dto.responce.ServiceProductDto;
import com.example.thebest_youdo.model.entity.ServiceProduct;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ServiceProductMapper {

    @Mapping(target = "categoryName", source = "category.name")
    @Mapping(target = "username", source = "createdBy.username")
    ServiceProductDto serviceProductToServiceProductDto(ServiceProduct serviceProduct);

    List<ServiceProductDto> serviceProductsToServiceProductsDto(List<ServiceProduct> serviceProducts);


    ServiceProduct serviceProductDtoToServiceProduct(ServiceProductDto serviceProductDto);

}
