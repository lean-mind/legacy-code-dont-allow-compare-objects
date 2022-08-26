package com.leanmind.legacyERP.privates.ratatoille;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

import static java.lang.String.format;

public class RecipesRepository {

    private final JdbcTemplate jdbcTemplate;

    public RecipesRepository(DataSource dataSource) {jdbcTemplate = new JdbcTemplate(dataSource);}

    /*
        We need imagine this repository use some library custom to access the data
        like a JDBC custom but private, we cannot know how is implemented

        TODO: We must move this JDBCTemplate to a wrapper in a package-module private ?
     */

    public String find(String recipe) {
        return jdbcTemplate.query(format("SELECT name FROM recipes WHERE name = '%s';", recipe),(rs, rw) -> rs.getString("name")).get(0);
    }
}
