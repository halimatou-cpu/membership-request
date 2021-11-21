package main.domain;

import java.util.Objects;

public final class UserEmail {
    private final String value;

    public UserEmail(String value) {
        this.value = value;
    }

    public String getUserEmail() {
        return value;
    }

    //from stackoverflow
    public boolean isValidEmailAddress() {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(this.value);
        return m.matches();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEmail userEmail = (UserEmail) o;
        return value.equals(userEmail.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "UserEmail{ " + value +
                '}';
    }
}
