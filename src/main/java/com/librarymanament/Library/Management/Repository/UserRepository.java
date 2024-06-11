package com.librarymanament.Library.Management.Repository;

import com.librarymanament.Library.Management.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    @Query("SELECT u From User u WHERE u.name = ?1")
    User findByName(String Name);
}
