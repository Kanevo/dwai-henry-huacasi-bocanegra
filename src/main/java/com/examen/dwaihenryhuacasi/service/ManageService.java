package com.examen.dwaihenryhuacasi.service;

import com.examen.dwaihenryhuacasi.dto.DetailDto;
import com.examen.dwaihenryhuacasi.dto.Dto;
import com.examen.dwaihenryhuacasi.dto.UpdateDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {
    List<Dto> getAllCars() throws Exception;

    Optional<DetailDto> getCarById(int id) throws Exception;

    boolean updateCar(UpdateDto UpdateDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(DetailDto DetailDto) throws Exception;
}
