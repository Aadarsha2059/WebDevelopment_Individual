package org.example.individual.Repository;

import org.example.individual.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


    @Query(nativeQuery = true,value = "select * from users where userName=?1 and password=?2")
    User findByUsernameAndPassword(String username,String password);
}
