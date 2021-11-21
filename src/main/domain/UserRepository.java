package main.domain;

public interface UserRepository {

    UserId nextIdentity();

    User findById(UserId id);

    void add(User user);
}
