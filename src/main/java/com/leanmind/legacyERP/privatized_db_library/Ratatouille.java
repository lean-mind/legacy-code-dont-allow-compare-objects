package com.leanmind.legacyERP.privatized_db_library;

import java.util.List;

public final class Ratatouille {
    private final List<Ingredient> ingredients;

    private Ratatouille(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public static Ratatouille withThis(List<Ingredient> ingredients) {
        return new Ratatouille(ingredients);
    }
}
