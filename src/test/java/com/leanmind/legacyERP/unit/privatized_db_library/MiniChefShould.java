package com.leanmind.legacyERP.unit.privatized_db_library;

import com.leanmind.legacyERP.privatized_db_library.IngredientsRepository;
import com.leanmind.legacyERP.privatized_db_library.MiniChef;
import com.leanmind.legacyERP.privatized_db_library.Recipe;
import com.leanmind.legacyERP.privatized_db_library.RecipesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static java.util.Collections.emptyList;
import static org.mockito.Mockito.*;

final class MiniChefShould {

    @Test
    @DisplayName("Cook a ratatouille")
    public void cook_a_ratatouille() {
        IngredientsRepository ingredientsRepository = mock(IngredientsRepository.class);
        RecipesRepository recipesRepository = mock(RecipesRepository.class);
        Recipe recipe = new Recipe("id", "recipe", emptyList());
        when(recipesRepository.find(Mockito.anyString())).thenReturn(recipe);
        MiniChef remy = new MiniChef(ingredientsRepository, recipesRepository);

        remy.cookRatatouille();

        verify(recipesRepository, times(1)).find("ratatouille");
        verify(ingredientsRepository, times(1)).retrieveIngredients();
    }
}
