package com.leanmind.legacyERP.integration.privates.ratatoille;

import com.leanmind.legacyERP.integration.helper.db.DataBaseInMemoryTestSuite;
import com.leanmind.legacyERP.privates.ratatoille.RecipesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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

        String recipe = repository.find("ratatouille");

        assertThat(recipe).isEqualTo("ratatouille");
    }

}
