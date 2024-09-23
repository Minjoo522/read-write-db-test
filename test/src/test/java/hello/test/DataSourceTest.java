package hello.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataSourceTest {

    private static final Logger log = LoggerFactory.getLogger(DataSourceTest.class);

    @Autowired
    private UserService userService;

    @DisplayName("read, write 서로 다른 db 사용하는지 테스트")
    @Test
    void readWriteDataSourceTest() {
        User userRead = userService.getListRead().get(0);
        User userWrite = userService.getListWrite().get(0);

        log.info("읽기 DB = {}", userRead.getName());
        log.info("쓰기 DB = {}", userWrite.getName());

        assertAll(
                () -> assertThat(userRead.getName()).isEqualTo("READ"),
                () -> assertThat(userWrite.getName()).isEqualTo("WRITE")
        );
    }
}
