package com.librarymanament.Library.Management.Controller;

import com.librarymanament.Library.Management.Entity.User;
import com.librarymanament.Library.Management.Service.UserService;
import com.librarymanament.Library.Management.constant.APIUrl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = APIUrl.USER)
public class UserController {

    private final UserService userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.create(user);
    }

    @GetMapping(path = APIUrl.PATH_VAR_ID)
    public User getById(@PathVariable String id){
        return userService.getUserById(id);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAll();
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return userService.update(user);
    }

    @DeleteMapping(path = APIUrl.PATH_VAR_ID)
    public void delete(@PathVariable String id){
        userService.deleteById(id);
    }
}
