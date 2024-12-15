package com.examen.dwaihenryhuacasi.controller;


import com.examen.dwaihenryhuacasi.dto.DetailDto;
import com.examen.dwaihenryhuacasi.dto.Dto;
import com.examen.dwaihenryhuacasi.dto.UpdateDto;
import com.examen.dwaihenryhuacasi.response.*;
import com.examen.dwaihenryhuacasi.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class ManageController {
    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public FindAllResponse findUser() {
        try {
            List<Dto> cars = manageService.getAllCars();

            if (cars.isEmpty()) {
                return new FindAllResponse("02", "Cars not found", null);
            } else {
                return new FindAllResponse("01", null, cars);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new FindAllResponse("99", "Error ocurred", null);
        }

    }

    @GetMapping("/detail")
    public FindDetailResponse findCar(@RequestParam String id) {
        try {
            Optional<DetailDto> optional = manageService.getCarById(Integer.parseInt(id));

            return optional.map(car ->
                    new FindDetailResponse("01", null, car)
            ).orElse(
                    new FindDetailResponse("02", "Car not found", null)
            );
        } catch (Exception e) {
            e.printStackTrace();
            return new FindDetailResponse("99", "Car not found", null);
        }
    }

    @PutMapping("/update")
    public UpdateResponse updateCar(@RequestBody UpdateDto carUpdateDto) {
        try {
            if (manageService.updateCar(carUpdateDto)) {
                return new UpdateResponse("01", null);
            } else {
                return new UpdateResponse("02", "Car not found");
            }
        } catch (Exception e) {
            return new UpdateResponse("99", "Error ocurred");
        }
    }

    @DeleteMapping("/delete/{id}")
    public DeleteResponse deleteCar(@PathVariable String id) {
        try {
            if (manageService.deleteCarById(Integer.parseInt(id))) {
                return new DeleteResponse("01", null);
            } else {
                return new DeleteResponse("02", "Car not found");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteResponse("99", "Error ocurred");
        }
    }

    @PostMapping("/create")
    public CreateResponse createCar(@RequestBody DetailDto carDetailDto) {
        try {
            if (manageService.addCar(carDetailDto)) {
                return new CreateResponse("01", null);
            } else {
                return new CreateResponse("02", "Car already exist");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new CreateResponse("99", "Error ocurred");
        }
    }
}
