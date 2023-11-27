package com.statestreet.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statestreet.entity.Gender;

@Repository
public interface GenderRepository extends JpaRepository <Gender, Integer>{

	
}
