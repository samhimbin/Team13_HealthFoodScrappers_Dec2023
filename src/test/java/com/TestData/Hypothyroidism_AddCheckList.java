package com.TestData;

import java.util.ArrayList;

public class Hypothyroidism_AddCheckList {
public static ArrayList<String> hypothyroidismAddList = new ArrayList<String>();
	

	public static boolean AddIngredient(String recieve_Ingredient) {
		hypothyroidismAddList.add("Saltwater fish");
		hypothyroidismAddList.add("oysters");
		hypothyroidismAddList.add("shellfish");
		hypothyroidismAddList.add("Eggs");
		hypothyroidismAddList.add("Dairy");
		hypothyroidismAddList.add("Nuts");
		hypothyroidismAddList.add("Chicken");
		hypothyroidismAddList.add("Pumpkinseeds");
		hypothyroidismAddList.add("Seaweed");
		hypothyroidismAddList.add("Iodized salt");
		hypothyroidismAddList.add("Brazil nuts");
		hypothyroidismAddList.add("Blue berries");
		hypothyroidismAddList.add("Low-fat Yogurt");
		hypothyroidismAddList.add("Brown rice");
		hypothyroidismAddList.add("quinoa");
		hypothyroidismAddList.add("Mushroom");
			

		boolean isIngrediantPresent = false;
		String ingredient = recieve_Ingredient.toLowerCase();

		for (String i : hypothyroidismAddList) {
			if (ingredient.contains(i)) // p_Ingredient
			{
				System.out.println("Recipe got added as " + i + " is present");
				isIngrediantPresent = true;
				continue;
			}
			
		}

		return isIngrediantPresent;

	}
}
