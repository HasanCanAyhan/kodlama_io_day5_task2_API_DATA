package com.example.service;

import com.example.dto.ProgramLanguageDto;

public interface ProgramLanguageService {

    ProgramLanguageDto save(ProgramLanguageDto dto);
    void deleteById(Long id);
    void update(Long id, ProgramLanguageDto dto);
    ProgramLanguageDto findById(Long id);

}
