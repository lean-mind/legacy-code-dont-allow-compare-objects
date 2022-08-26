package com.leanmind.legacyERP.privatesDepencencies.unit;

import com.leanmind.legacyERP.privatesDepencencies.IngredientsRepository;
import com.leanmind.legacyERP.privatesDepencencies.MiniChef;
import com.leanmind.legacyERP.privatesDepencencies.RecipesRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;

final class MiniChefShould {

    @Test
    @DisplayName("Cook a ratatouille")
    public void cook_a_ratatouille() {
        IngredientsRepository ingredientsRepository = mock(IngredientsRepository.class);
        RecipesRepository recipesRepository = mock(RecipesRepository.class);
        when(recipesRepository.find(Mockito.anyString())).thenReturn("recipe");
        MiniChef remy = new MiniChef(ingredientsRepository, recipesRepository);

        remy.cookRatatouille();

        verify(recipesRepository, times(1)).find("ratatouille");
        verify(ingredientsRepository, times(1)).retrieveIngredients();
    }
}
