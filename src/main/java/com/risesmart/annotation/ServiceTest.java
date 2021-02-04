package com.risesmart.annotation;

import static java.lang.annotation.RetentionPolicy.RUNTIME;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import com.risesmart.builder.ModelBuilder;

/**
 * The interface Service test.
 *
 * @author adnaan
 */
@Retention(RUNTIME)
@Target({ElementType.TYPE})
@ExtendWith(SpringExtension.class)
@TestPropertySource(locations = "classpath:application.properties")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@Import({ModelBuilder.class})
@SpringBootTest
public @interface ServiceTest {

}
