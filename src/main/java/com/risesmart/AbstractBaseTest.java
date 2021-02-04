package com.risesmart;


import org.junit.ClassRule;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.MySQLContainer;
import com.risesmart.builder.ModelBuilder;

/**
 * The type Abstract base test.
 *
 * @author adnaan
 */
public abstract class AbstractBaseTest {

  /**
   * The Logger.
   */
  protected final transient Logger LOGGER = LoggerFactory.getLogger(getClass());

  /**
   * The Mocked handler.
   */
  @Autowired(required = false)
  protected MockMvc mockedHandler;


  @ClassRule
  GenericContainer mySQLContainer = new MySQLContainer().withCommand("mysqld",
      "'--character-set-server=utf8mb4', '--collation-server=utf8mb4_unicode_ci'");


  /**
   * Setup.
   */
  @BeforeAll
  public void setup() {
    LOGGER.info("Profile test execution started");
    mySQLContainer.start();
    ModelBuilder.initializeBuilder();


    /* Include required test setup here */
  }

  /**
   * Cleanup.
   */
  @AfterAll
  public void cleanup() {
    LOGGER.info("Profile test execution completed");
    mySQLContainer.stop();
    /* Include required test cleanup here */
  }
}
