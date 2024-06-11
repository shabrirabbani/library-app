package com.librarymanament.Library.Management.Service;

import com.librarymanament.Library.Management.Entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User create(User user);
    User getUserById(String id);
    List<User> getAll();
    User update(User user);
    void deleteById(String id);

}
