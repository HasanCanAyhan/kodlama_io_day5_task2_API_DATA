package com.example.service.impl;

import com.example.dto.ProgramLanguageDto;
import com.example.entity.ProgramLanguage;
import com.example.repository.ProgramLanguageRepository;
import com.example.service.ProgramLanguageService;
import com.example.util.MapperUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class ProgramLanguageServiceImpl implements ProgramLanguageService {

    private final ProgramLanguageRepository programLanguageRepository;
    private final MapperUtil mapperUtil;

    public ProgramLanguageServiceImpl(ProgramLanguageRepository programLanguageRepository, MapperUtil mapperUtil) {
        this.programLanguageRepository = programLanguageRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public ProgramLanguageDto save(ProgramLanguageDto dto) {
        ProgramLanguage programLanguage = mapperUtil.convert(dto, new ProgramLanguage());
        programLanguageRepository.save(programLanguage);
        return dto;

    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void update(Long id, ProgramLanguageDto dto) {

    }

    @Override
    public ProgramLanguageDto findById(Long id) {
        return null;
    }
}
