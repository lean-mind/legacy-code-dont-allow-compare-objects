package com.leanmind.legacyERP.unit.privates.ratatouille;

import com.leanmind.legacyERP.privates.ratatoille.IngredientsRepository;
import com.leanmind.legacyERP.privates.ratatoille.MiniChef;
import com.leanmind.legacyERP.privates.ratatoille.RecipesRepository;
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
