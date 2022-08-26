package com.leanmind.legacyERP.privates.ratatoille;

public final class RecipeDontFound extends RuntimeException {
    public RecipeDontFound(String recipe)  {
        super(String.format("Recipe with name %s don't found", recipe));
    }
}
