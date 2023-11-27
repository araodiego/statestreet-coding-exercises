package com.statestreet.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.statestreet.entity.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
	Optional<List<Person>> findByFullName(String fullName);
	Optional<List<Person>> findByFullNameContainingIgnoreCase(String partialName);
	Optional<List<Person>> findByGender_IdGender(Integer idGender);
}
