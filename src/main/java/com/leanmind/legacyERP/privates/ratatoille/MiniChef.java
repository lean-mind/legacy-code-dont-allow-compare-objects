package com.leanmind.legacyERP.privates.ratatoille;

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
        if (recipe == null) {
            throw new RuntimeException("Don't found the recipe to do the ratatouille");
        }
        List<Ingredient> ingredients = this.ingredientsRepository.retrieveIngredients();
        return Ratatouille.withThis(ingredients);
    }
}
