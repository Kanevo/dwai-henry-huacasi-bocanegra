package com.examen.dwaihenryhuacasi.response;

import com.examen.dwaihenryhuacasi.dto.Dto;

public record FindAllResponse(String code,
                              String error,
                              Iterable<Dto> cars) {
}