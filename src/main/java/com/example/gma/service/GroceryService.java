package com.example.gma.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.gma.entity.Grocery;
import com.example.gma.exception.GroceryNotFoundByIdExcpetion;
import com.example.gma.repository.GroceryRepository;

@Service
public class GroceryService {

	private GroceryRepository groceryRepository;
	
	public GroceryService(GroceryRepository groceryRepository) {
		this.groceryRepository = groceryRepository;
	}
	
	public void saveGrocery(Grocery grocery) {
		groceryRepository.save(grocery);
	}

	public void updateGrocery(Grocery grocery) {
		groceryRepository.save(grocery);
	}
	
	public Grocery findGroceryById(int groceryId) {
		return groceryRepository.findById(groceryId)
				.orElseThrow(()->new GroceryNotFoundByIdExcpetion("Could not find grocery", "/manage-groceries"));
	}

	public void deleteGroceryById(int groceryId) {
		groceryRepository.deleteById(groceryId);
	}
	
	public List<Grocery> getAllGroceries() {
		return groceryRepository.findAll();
	}
	
}
