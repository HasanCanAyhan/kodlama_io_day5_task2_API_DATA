package com.example.repository;

import com.example.entity.ProgramLanguage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramLanguageRepository extends JpaRepository<ProgramLanguage,Long> {

}
