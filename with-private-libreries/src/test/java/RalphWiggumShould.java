
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

final class RalphWiggumShould {

    @Test
    void say_something_smart() {
        //WHEN
        String thatHimSay = RalphWiggum.saySomethingSmart();

        //THEN
        assertThat(thatHimSay).isEqualTo("Algo smart");
    }
}
