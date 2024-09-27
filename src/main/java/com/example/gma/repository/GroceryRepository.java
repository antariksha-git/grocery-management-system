package com.example.gma.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.gma.entity.Grocery;

public interface GroceryRepository extends JpaRepository<Grocery, Integer> {

	
}
