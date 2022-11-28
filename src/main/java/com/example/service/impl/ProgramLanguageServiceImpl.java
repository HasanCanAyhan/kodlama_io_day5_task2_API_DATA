package com.example.service.impl;

import com.example.dto.ProgramLanguageDto;
import com.example.entity.ProgramLanguage;
import com.example.repository.ProgramLanguageRepository;
import com.example.service.ProgramLanguageService;
import com.example.util.MapperUtil;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        programLanguageRepository.deleteById(id);
    }

    @Override
    public ProgramLanguageDto update(Long id, ProgramLanguageDto dto) {

        Optional<ProgramLanguage> programLanguage = programLanguageRepository.findById(id);

        if (programLanguage.isPresent()){
            programLanguage.get().setProgramName(dto.getProgramName());
            programLanguageRepository.save(programLanguage.get());
            return mapperUtil.convert(programLanguage.get(), new ProgramLanguageDto());
        }
        return null;
    }

    @Override
    public ProgramLanguageDto findById(Long id) {

        Optional<ProgramLanguage> language = programLanguageRepository.findById(id);

        if (language.isPresent()){
            return mapperUtil.convert(language,new ProgramLanguageDto());
        }
        return null;
    }

    @Override
    public List<ProgramLanguageDto> findAllProgramLanguages() {
        List<ProgramLanguage> languageList = programLanguageRepository.findAll();

        return languageList.stream().map(programLanguage -> mapperUtil.convert(programLanguage,new ProgramLanguageDto())).collect(Collectors.toList());

    }
}
