package com.TestData;

import java.util.ArrayList;

public class Hypothyroidism_IngredientsCheckList {
public static ArrayList<String> hypothyroidismEliminatedList = new ArrayList<String>();
	

	public static boolean eliminateIngredient(String recieve_Ingredient) {
		hypothyroidismEliminatedList.add("Tofu");
		hypothyroidismEliminatedList.add("Edamame");
		hypothyroidismEliminatedList.add("Tempeh");
		hypothyroidismEliminatedList.add("Cauliflower");
		hypothyroidismEliminatedList.add("Cabbage");
		hypothyroidismEliminatedList.add("Broccoli");
		hypothyroidismEliminatedList.add("Kale");
		hypothyroidismEliminatedList.add("Spinach");
		hypothyroidismEliminatedList.add("Sweet potatoes");
		hypothyroidismEliminatedList.add("Pine nuts");
		hypothyroidismEliminatedList.add("Peanuts");
		hypothyroidismEliminatedList.add("Peaches");
		hypothyroidismEliminatedList.add("Green tea");
		hypothyroidismEliminatedList.add("Coffee");
		hypothyroidismEliminatedList.add("Alcohol");
		hypothyroidismEliminatedList.add("Soy milk");
		hypothyroidismEliminatedList.add("White bread");
		hypothyroidismEliminatedList.add("Cakes");
		hypothyroidismEliminatedList.add("pastries");
		hypothyroidismEliminatedList.add("Fried food");
		hypothyroidismEliminatedList.add("Sugar");
		hypothyroidismEliminatedList.add("ham");
		hypothyroidismEliminatedList.add("bacon");
		hypothyroidismEliminatedList.add("salami");
		hypothyroidismEliminatedList.add("sausages");
		hypothyroidismEliminatedList.add("Frozen food");
		hypothyroidismEliminatedList.add("Sodas");
		hypothyroidismEliminatedList.add("Energy drinks with Caffeine");
		hypothyroidismEliminatedList.add("noodles");
		hypothyroidismEliminatedList.add("soups");
		hypothyroidismEliminatedList.add("salad dressings");
		hypothyroidismEliminatedList.add("sauces");
		hypothyroidismEliminatedList.add("Candies");
		

		boolean isIngrediantPresent = false;
		String ingredient = recieve_Ingredient.toLowerCase();

		for (String i : hypothyroidismEliminatedList) {
			if (ingredient.contains(i)) // p_Ingredient
			{
				System.out.println("Recipe skipped as " + i + " is present");
				isIngrediantPresent = true;
				break;
			}
		}

		return isIngrediantPresent;

	}
}
