package com.leanmind.legacyERP.privatized_db_library;

import java.util.List;

public final class MiniChef {


    private final IngredientsRepository ingredientsRepository;
    private final RecipesRepository recipesRepository;

    public MiniChef(IngredientsRepository ingredientsRepository, RecipesRepository recipesRepository) {
        this.ingredientsRepository = ingredientsRepository;
        this.recipesRepository = recipesRepository;
    }

    public Ratatouille cookRatatouille() {
        Recipe recipe = recipesRepository.find("ratatouille");
        List<Ingredient> ingredients = this.ingredientsRepository.retrieveIngredients();
        return Ratatouille.withThis(ingredients);
    }
}
