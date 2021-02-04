package com.risesmart.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import com.risesmart.builder.ModelBuilder;

/**
 * The type Abstract base repository test.
 *
 * @author adnaan
 */
@Retention(RUNTIME)
@Target({ElementType.TYPE})
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
@Import({ModelBuilder.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional
public @interface RepositoryTest {

}
