import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


public class FooRepository extends DataBaseTestSuite {
//    private JdbcTemplate jdbcTemplate;

    static {
        initScript = "contract/sql/contract_modification_init.sql";
    }

    @BeforeEach
    void initialize() {
//        this.jdbcTemplate = new JdbcTemplate(dataSource);
//        this.jdbcContractModificationRepository = new JdbcContractModificationRepository(dataSource);
    }

    @Test
    void foo() {

        assertThat(true)
                .isEqualTo(false);
    }
}
