package com.librarymanament.Library.Management.Service.Impl;

import com.librarymanament.Library.Management.Entity.User;
import com.librarymanament.Library.Management.Repository.UserRepository;
import com.librarymanament.Library.Management.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User create(User user) {
        return userRepository.saveAndFlush(user);
    }

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public void deleteById(String id) {
        deleteById(id);
    }
}
