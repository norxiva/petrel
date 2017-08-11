package my.norxiva.petrel.util;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNull.notNullValue;

@Slf4j
public class IdUtilsTest {

    @Test
    public void testUuidWithNoDash() {
        String uuid = IdUtils.uuidWithNoDash();
        log.info("uuid with no dash: {}", uuid);
        assertThat(uuid, notNullValue());
    }
}
