package com.booleanuk.api.models.daos;

import com.booleanuk.api.models.User;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDao {
    private int id;
    private String firstName;
    private String lastName;

    public UserDao(User user) {
        id=user.getId();
        firstName= user.getFirstName();
        lastName= user.getLastName();
    }
}
