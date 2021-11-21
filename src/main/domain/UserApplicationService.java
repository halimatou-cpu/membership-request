package main.domain;

public final class UserApplicationService {
    private final UserRepository userRepository;

    public UserApplicationService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserId handle(CreateUser createUser) {
        final UserId userId = userRepository.nextIdentity();
        User user = new User(userId, createUser.lastname, createUser.firstname, createUser.email);
        userRepository.add(user);
        return userId;
    }
}
