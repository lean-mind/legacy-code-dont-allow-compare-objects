package com.leanmind.legacyERP.integration.privatized_db_library;

import com.leanmind.legacyERP.integration.helper.db.DataBaseInMemoryTestSuite;
import com.leanmind.legacyERP.privatized_db_library.Recipe;
import com.leanmind.legacyERP.privatized_db_library.RecipeDontFound;
import com.leanmind.legacyERP.privatized_db_library.RecipesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

final class RecipesRepositoryIT extends DataBaseInMemoryTestSuite {

    private RecipesRepository repository;

    @BeforeEach
    public void setup() throws Exception {
        setupDbConnection(
                "privates/setupTables.sql",
                "privates/setupData.sql"
        );

        repository = new RecipesRepository(getDataSource());
    }

    @Test
    @DisplayName("Should retrieve a searched recipe")
    public void should_retrieve_a_searched_recipe() {

        Recipe recipe = repository.find("ratatouille");

        assertThat(recipe).isInstanceOf(Recipe.class);
        assertThat(recipe.getName()).isEqualTo("ratatouille");
    }

    @Test
    @DisplayName("Recipe don't found")
    public void recipe_don_t_found() {
        assertThrows(RecipeDontFound.class, () -> repository.find("dontExistingRecipe"));
    }

}