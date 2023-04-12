package testUtils;

import com.example.thebest_youdo.model.entity.Authority;
import com.example.thebest_youdo.model.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class CreateUser {


    public static User createUser1() {
        Authority admin = new Authority();
        admin.setAuthorityName("ROLE_ADMIN");
        User user = User.builder()
                .id(UUID.randomUUID())
                .authorities(List.of(admin))
                .dayStart(LocalDate.now())
                .name("Vasya")
                .password("password")
                .email("email@mail.com")
                .phoneNumber("4105551212")
                .rate(3.0F)
                .build();

                return user;
    }

    public static User createUser2() {
        Authority consumer = new Authority();
        consumer.setAuthorityName("ROLE_CONSUMER");
        User user = User.builder()
                .id(UUID.randomUUID())
                .authorities(List.of(consumer))
                .dayStart(LocalDate.now())
                .name("Petr")
                .password("password123456")
                .email("email123@mail.com")
                .phoneNumber("4105551210")
                .rate(3.5F)
                .build();

        return user;
    }
}
