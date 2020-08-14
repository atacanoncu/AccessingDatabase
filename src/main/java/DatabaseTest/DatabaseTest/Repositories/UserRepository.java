package DatabaseTest.DatabaseTest.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import DatabaseTest.DatabaseTest.Entities.User;


public interface UserRepository extends JpaRepository<User, String> {
	
}