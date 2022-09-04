package com.leanmind.legacyERP.integration.privatized_db_library;

import com.leanmind.legacyERP.integration.helper.db.DataBaseInMemoryTestSuite;
import com.leanmind.legacyERP.privatized_db_library.Ingredient;
import com.leanmind.legacyERP.privatized_db_library.IngredientsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.assertj.core.api.Assertions.assertThat;

final class IngredientsRepositoryIT extends DataBaseInMemoryTestSuite {

    private IngredientsRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        setupDbConnection(
                "privates/setupTables.sql",
                "privates/setupData.sql"
        );

        repository = new IngredientsRepository(getDataSource());
    }

    @Test
    @DisplayName("Should retrieve all ingredients")
    public void should_retrieve_all_ingredients() {

        List<Ingredient> ingredients = repository.retrieveIngredients();

        assertThat(ingredients).isNotEmpty();
        assertThat(ingredients).isEqualTo(asList(
                new Ingredient("🍆"),
                new Ingredient("🍅"),
                new Ingredient("🫑")
        ));
    }
}
