package by.bntu.fitr.poisit.fakeObjects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class FakeAccount {
    private int id;
    private String firstName;
    private String lastName;
    private String username;
    private String password;
    private int roleId;

    public FakeAccount(int id, String firstName, String lastName, String username, String password) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.username = username;
        this.password = password;
        roleId = 2;
    }
}
