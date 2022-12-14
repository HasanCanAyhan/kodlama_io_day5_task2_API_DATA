package com.example.service;

import com.example.dto.ProgramLanguageDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ProgramLanguageService {

    ProgramLanguageDto save(ProgramLanguageDto dto);
    void deleteById(Long id);
    ProgramLanguageDto update(Long id, ProgramLanguageDto dto);
    ProgramLanguageDto findById(Long id);

    List<ProgramLanguageDto> findAllProgramLanguages();
}
