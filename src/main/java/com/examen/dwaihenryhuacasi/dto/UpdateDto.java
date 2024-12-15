package com.examen.dwaihenryhuacasi.dto;

public record UpdateDto(Integer car_id,
                        String make,
                        String model,
                        Integer year,
                        String owner_name,
                        String color) {
}
