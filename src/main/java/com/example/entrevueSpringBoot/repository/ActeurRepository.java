package com.example.entrevueSpringBoot.repository;

import com.example.entrevueSpringBoot.model.Acteur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActeurRepository extends JpaRepository<Acteur,Long> {
}
