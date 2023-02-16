package model;

public class User {
    public User(String id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    private String id;
    private String firstName;
    private String lastName;
    private String email;

    public String getId() {
        return id;
    }
}
