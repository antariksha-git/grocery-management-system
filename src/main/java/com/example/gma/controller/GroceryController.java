package com.example.gma.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.gma.entity.Grocery;
import com.example.gma.exception.GroceryNotFoundByIdExcpetion;
import com.example.gma.service.GroceryService;

@Controller
public class GroceryController {

	private final GroceryService groceryService;

	public GroceryController(GroceryService groceryService) {
		this.groceryService = groceryService;
	}

	@GetMapping("/")
	public String home() {
		return "index.html";
	}

	@GetMapping("/add-grocery")
	public String addGroceryRequest(Model model) {
		Grocery grocery = new Grocery();
		model.addAttribute("grocery", grocery);
		return "add_grocery.html";
	}

	@PostMapping("/add-grocery")
	public String addGrocery(@ModelAttribute Grocery grocery) {
		groceryService.saveGrocery(grocery);
		return "redirect:/";
	}

	@GetMapping("/update-grocery")
	public String updateGroceryRequest(@RequestParam("grocery_id") int groceryId, Model model) {
		Grocery grocery = groceryService.findGroceryById(groceryId);
		model.addAttribute("grocery", grocery);
		// System.out.println(grocery.getTitle());

		return "update_grocery.html";
	}

	@PostMapping("/update-grocery")
	public String updateGrocery(Grocery grocery) {
		groceryService.updateGrocery(grocery);
		return "redirect:/";
	}

	@GetMapping("/delete-grocery")
	public String deleteProduct(@RequestParam("grocery_id") int groceryId, Model model) {
		groceryService.deleteGroceryById(groceryId);
		return "redirect:/";
	}

	@ExceptionHandler(GroceryNotFoundByIdExcpetion.class)
	public String handleGroceryNotFoundById(GroceryNotFoundByIdExcpetion ex, Model model) {
		model.addAttribute("errorMessage", ex.getMessage());
		model.addAttribute("redirectTo", ex.getRedirect());
		return "not_found.html";
	}

	@GetMapping("manage-groceries")
	public String getAllGroceries(Model model) {
		List<Grocery> groceries = groceryService.getAllGroceries();
		// groceries.stream().map(g -> g.getTitle() + " --> " +
		// g.getPrice()).forEach(System.out::println);
		model.addAttribute("groceries", groceries);

		return "manage_groceries.html";
	}

}
