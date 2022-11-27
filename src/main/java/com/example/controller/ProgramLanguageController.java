package com.example.controller;


import com.example.dto.ProgramLanguageDto;
import com.example.service.ProgramLanguageService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/language/api/v1")
public class ProgramLanguageController {

    private final ProgramLanguageService programLanguageService;

    public ProgramLanguageController(ProgramLanguageService programLanguageService) {
        this.programLanguageService = programLanguageService;
    }

    @PostMapping
    public ResponseEntity<ProgramLanguageDto> createCourse(@RequestBody ProgramLanguageDto progLangDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(programLanguageService.save(progLangDto));
    }


}
