package com.fizzbuzz.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fizzbuzz.entity.FizzBuzzTransacciones;

@Repository
public interface FizzBuzzTransaccionesRepository extends JpaRepository<FizzBuzzTransacciones, Long> {}
