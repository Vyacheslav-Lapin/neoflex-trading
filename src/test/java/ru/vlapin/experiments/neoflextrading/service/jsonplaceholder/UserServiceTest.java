package ru.vlapin.experiments.neoflextrading.service.jsonplaceholder;

import static org.assertj.core.api.Assertions.*;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import ru.vlapin.experiments.neoflextrading.model.jsonplaceholder.Address;
import ru.vlapin.experiments.neoflextrading.model.jsonplaceholder.Geo;
import ru.vlapin.experiments.neoflextrading.model.jsonplaceholder.User;

@SpringBootTest
@RequiredArgsConstructor(onConstructor_ = @Autowired)
class UserServiceTest {

  UserService userService;

  @Test
  @SneakyThrows
  @DisplayName("One user invoked correctly")
  void oneUserInvokedCorrectlyTest() {
    assertThat(userService.findById(1L)).isNotNull()
        .isInstanceOf(User.class)
        .extracting(User::getAddress)
        .extracting(Address::getGeo)
        .extracting(Geo::getLatitude, Geo::getLongitude)
        .contains(-37.3159, 81.1496);
  }
}
