package tk.djandjiev.practice;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:data.sql", config = @SqlConfig(encoding = "UTF-8"))
@SpringBootTest
public abstract class AbstractTest {
}
