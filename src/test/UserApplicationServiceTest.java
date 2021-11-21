package test;

import main.domain.*;
import main.infrastructure.InMemoryUserRepository;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserApplicationServiceTest {
    @Test
    void createUser() {
        UserRepository userRepository = new InMemoryUserRepository();
        UserApplicationService userApplicationService = new UserApplicationService(userRepository);

        CreateUser createdUser = new CreateUser("BOISSINOT", "GREGORY");
        final UserId userId = userApplicationService.handle(createdUser);

        final User storedUser = userRepository.findById(userId);
        assertEquals(new User(userId, createdUser.lastname, createdUser.firstname), storedUser);
    }
}
