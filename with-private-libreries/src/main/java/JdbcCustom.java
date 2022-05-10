import java.sql.Connection;

public class JdbcCustom {

    // https://www.adictosaltrabajo.com/2011/02/25/tutorial-basico-jdbc/

    private Connection connection = null;

    private final String url = "jdbc:";
    private final String dbName = "inventory";
    private final String username = "root";
    private final String password = "password";
}
