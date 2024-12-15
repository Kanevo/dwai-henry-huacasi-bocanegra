package com.examen.dwaihenryhuacasi.response;

import com.examen.dwaihenryhuacasi.dto.DetailDto;

public record FindDetailResponse(String code,
                                 String error,
                                 DetailDto car) {
}
