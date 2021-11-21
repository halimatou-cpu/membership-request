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

        final UserEmail userEmail= new UserEmail("mariedupont@gmail.com");

        CreateUser createdUser = new CreateUser("DUPONT", "MARIE", userEmail);
        final UserId userId = userApplicationService.handle(createdUser);

        final User storedUser = userRepository.findById(userId);
        assertEquals(new User(userId, createdUser.lastname, createdUser.firstname, createdUser.email), storedUser);
    }
}
