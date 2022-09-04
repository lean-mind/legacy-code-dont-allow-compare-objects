package com.leanmind.legacyERP.privatized_db_library;

import java.util.Objects;

public final class Ingredient {
    private final String name;

    public Ingredient(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(name, that.name);
    }
}
