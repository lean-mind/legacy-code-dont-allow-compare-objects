import org.junit.jupiter.api.BeforeEach;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.shaded.org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.sql.Connection;
import java.sql.DriverManager;

@Testcontainers
public class DataBaseTestSuite {
    protected Connection session;
    protected static String initScript;

    @Container
    public PostgreSQLContainer postgres = (PostgreSQLContainer)new PostgreSQLContainer()
            .withInitScript(initScript);

    @BeforeEach
    public void setUp() throws Exception {
        String url = postgres.getJdbcUrl();
        String username = postgres.getUsername();
        String password = postgres.getPassword();
        session = DriverManager.getConnection(url, username, password);
    }

    public String retrieveQueryFrom(String pathToScript) throws IOException {
        return IOUtils.toString(ClassLoader.getSystemResourceAsStream(pathToScript), Charset.defaultCharset());
    }
}
