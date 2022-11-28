package com.example.controller;


import com.example.dto.ProgramLanguageDto;
import com.example.service.ProgramLanguageService;
import jakarta.persistence.GeneratedValue;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/language/api/v1")
public class ProgramLanguageController {

    private final ProgramLanguageService programLanguageService;

    public ProgramLanguageController(ProgramLanguageService programLanguageService) {
        this.programLanguageService = programLanguageService;
    }


    @GetMapping
    public ResponseEntity<List<ProgramLanguageDto>> getAllProgramLanguages(){

        return ResponseEntity
                .status(HttpStatus.ACCEPTED)// 202 : ACCEPTED
                .header("Version","Cydeo.V2")
                .header("Operation","Get List")
                .body( programLanguageService.findAllProgramLanguages() );
    }

    @PostMapping
    public ResponseEntity<ProgramLanguageDto> createCourse(@RequestBody ProgramLanguageDto progLangDto){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Operation","Create")
                .body(programLanguageService.save(progLangDto));
    }

    @DeleteMapping("{id}")
    public void deleteProgramLanguage(@PathVariable("id") Long id){
        programLanguageService.deleteById(id);
    }


    @GetMapping("{id}")
    public ResponseEntity<ProgramLanguageDto> findById(@PathVariable("id") Long id){
        return ResponseEntity.ok(programLanguageService.findById(id));
    }


    @PutMapping("{id}")
    public ResponseEntity<ProgramLanguageDto> updateProgramLanguage(@RequestBody ProgramLanguageDto programLanguageDto, @PathVariable Long id){
       return ResponseEntity
               .status(HttpStatus.ACCEPTED)
               .header("Operation","Update")
               .body(programLanguageService.update(id,programLanguageDto));
    }

}
