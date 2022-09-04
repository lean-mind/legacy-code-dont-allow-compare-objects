package com.leanmind.legacyERP.privatized_db_library;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;

public class RecipesRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecipesRepository(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}

    /*
        We need imagine this repository use some library custom to access the data
        like a JDBC custom but private, we cannot know how is implemented

        TODO: We must move this JDBCTemplate to a wrapper in a package-module private ?
     */

    public List<Recipe> findAll() {
        return jdbcTemplate.query("SELECT * FROM recipes;", recipeRowMapper());
    }

    public Recipe find(String recipeName) {
        return findAll().stream().filter(recipe -> recipe.getName().equals(recipeName)).findFirst().orElseThrow(() -> new RecipeDontFound(recipeName));
    }

    private RowMapper<Recipe> recipeRowMapper() {
        return (rs, rw) -> new Recipe(rs.getString("id"), rs.getString("name"), new ArrayList<>());
    }
}
