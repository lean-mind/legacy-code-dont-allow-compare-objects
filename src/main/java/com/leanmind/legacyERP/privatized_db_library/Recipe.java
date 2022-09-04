package com.leanmind.legacyERP.privatized_db_library;

import java.util.List;

public final class Recipe {
    private final String id;
    private final String name;
    private final List<Ingredient> ingredients;

    public Recipe(String id, String name, List<Ingredient> ingredients) {
        this.id = id;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }
}
