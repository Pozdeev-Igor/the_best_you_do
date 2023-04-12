package com.example.thebest_youdo.controller;

import com.example.thebest_youdo.handler.ErrorResponse;
import com.example.thebest_youdo.model.dto.responce.ServiceProductDto;
import com.example.thebest_youdo.service.ServicesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/auth/main")
@RequiredArgsConstructor
public class MainController {
    private final ServicesService servicesService;


    @GetMapping("/paging")
    @Operation(summary = "Пагинация карточек объявлений", tags = "serviceCards",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Success",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    array = @ArraySchema(schema = @Schema(implementation = List.class)))),
                    @ApiResponse(responseCode = "400", description = "Bad request",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class))),
                    @ApiResponse(responseCode = "500", description = "Internal Server Error",
                            content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(implementation = ErrorResponse.class)))
            })
    public ResponseEntity<List<ServiceProductDto>> pagingFindAll(@RequestParam Integer page, @RequestParam Integer limit) {
        return ResponseEntity.ok(servicesService.findAllByPagination(page, limit));
    }
}
