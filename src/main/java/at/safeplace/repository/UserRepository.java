package at.safeplace.repository;

import at.safeplace.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    @Query("SELECT u FROM User u WHERE u.email=?1")
    public User findByMail(String mail);

    @Query("SELECT u FROM User u WHERE u.username=?1")
    public User findByUsername(String username);
}
