package com.leanmind.legacyERP.privates.ratatoille;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.List;

public class IngredientsRepository {
    private final JdbcTemplate jdbcTemplate;

    public IngredientsRepository(DataSource dataSource)  {jdbcTemplate = new JdbcTemplate(dataSource);}

    /*
        We need imagine this repository use some library custom to access the data
        like a JDBC custom but private, we cannot know how is implemented

         TODO: We must move this JDBCTemplate to a wrapper in a package-module private ?
     */

    public List<Ingredient> retrieveIngredients() {
        return jdbcTemplate.queryForList("SELECT name FROM ingredients;", Ingredient.class);
    }
}
