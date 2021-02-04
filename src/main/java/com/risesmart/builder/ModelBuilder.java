package com.risesmart.builder;

import com.risesmart.model.BaseEntity;
import java.nio.charset.StandardCharsets;
import java.util.stream.Stream;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;
import org.springframework.stereotype.Component;

/**
 * The type Model builder.
 *
 * @param <T> the type parameter
 * @author adnaan
 */
@Component
public class ModelBuilder<T> {

  /**
   * The constant easyRandom.
   */
  public static EasyRandom easyRandom;

  /**
   * Initialize builder.
   */
  public static void initializeBuilder() {
    EasyRandomParameters parameters = new EasyRandomParameters()
        .seed(123L)
        .excludeField(FieldPredicates.inClass(BaseEntity.class))
        .objectPoolSize(100)
        .randomizationDepth(3)
        .charset(StandardCharsets.UTF_8)
        .stringLengthRange(5, 50)
        .collectionSizeRange(1, 10)
        .scanClasspathForConcreteTypes(true)
        .overrideDefaultInitialization(false)
        .ignoreRandomizationErrors(true);
    easyRandom = new EasyRandom(parameters);
  }

  /**
   * Build model t.
   *
   * @param type the type
   * @return the t
   */
  public T buildModel(Class<T> type) {
    return easyRandom.nextObject(type);
  }

  /**
   * Build models stream.
   *
   * @param type  the type
   * @param count the count
   * @return the stream
   */
  public Stream<T> buildModels(Class<T> type, int count) {
    return easyRandom.objects(type, count);
  }


}
