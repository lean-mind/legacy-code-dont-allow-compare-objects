package com.leanmind.legacyERP.integration;

import com.leanmind.legacyERP.integration.assertions.EmployeeAssertion;
import org.junit.After;
import org.junit.Before;
import org.springframework.boot.jdbc.DataSourceBuilder;

import javax.sql.DataSource;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseInMemoryTestSuite {

    public static final String H2_DATABASE_DRIVER = "org.h2.Driver";

    public static final String DATABASE_USERNAME = "";
    public static final String DATABASE_PASSWORD = "";

    private Connection dbConnection;

    @Before
    public void setup() throws Exception {
        Class.forName(H2_DATABASE_DRIVER);
    }

    @After
    public void cleanup() throws Exception {
        if (dbConnection != null) {
            dbConnection.close();
        }
        File folder = new File(new File("").getAbsolutePath());
        for (File file: folder.listFiles()) {
            file.delete();
        }
        folder.delete();
    }

    protected DataSource getDataSource(){
        return DataSourceBuilder
                .create()
                .url(getDbConnectionString())
                .username(DATABASE_USERNAME)
                .password(DATABASE_PASSWORD)
                .build();
    }

    protected void setupDbConnection(String... scripts) throws Exception {
        dbConnection = getDbConnection(scripts);
        dbConnection.setAutoCommit(true);
    }

    private Connection getDbConnection(String... scripts) throws Exception {
        return DriverManager.getConnection(
                getDbConnectionString(scripts),
                DATABASE_USERNAME,
                DATABASE_PASSWORD
        );
    }

    private String getDbConnectionString(String... scripts) {
        StringBuilder sb = new StringBuilder(500);
        sb.append("jdbc:h2:mem:test");
        sb.append(";MODE=MSSQLServer");
        sb.append(";TRACE_LEVEL_SYSTEM_OUT=0");
        sb.append(";TRACE_LEVEL_FILE=0");
        if (scripts.length > 0) {
            sb.append(";INIT=");
            for (int count = 0; count < scripts.length; count++) {
                if (count > 0) {
                    sb.append("\\;");
                }
                sb.append("RUNSCRIPT FROM 'classpath:sql/");
                sb.append(scripts[count]);
                sb.append("'");
            }
        }
        return sb.toString();
    }

    protected EmployeeAssertion assertThatEmployeeWithId(int id) {
        return new EmployeeAssertion(id, getDataSource());
    }
}
