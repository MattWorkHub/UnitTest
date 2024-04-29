package unittest.unittest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import unittest.unittest.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

}