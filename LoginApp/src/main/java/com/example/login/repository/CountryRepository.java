package com.example.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.login.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, Long> {

	public Optional<Country> findByCountryname(String name);
	public Optional<Country> findByCountrycode(String code);
}
