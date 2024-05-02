package com.pfe.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pfe.demo.Entity.Sanction;

public interface SanctionRepository extends JpaRepository <Sanction, Integer>{

}
