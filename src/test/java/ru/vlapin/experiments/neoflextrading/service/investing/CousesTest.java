package ru.vlapin.experiments.neoflextrading.service.investing;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class CousesTest {

  Couses couses;

  @Test
  @SneakyThrows
  @DisplayName("BTC course invoked correctly")
  void bTCCourseInvokedCorrectlyTest() {
    assertThat(couses.bitcoin())
        .matches(btcValue -> btcValue > 0);
  }
}
