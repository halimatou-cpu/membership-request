package main.domain;

public final class CreateUser {
    public String lastname;
    public String firstname;
    public UserEmail email;

    public CreateUser(String lastname, String firstname, UserEmail email) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
    }
}
