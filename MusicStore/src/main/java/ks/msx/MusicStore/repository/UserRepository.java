package ks.msx.MusicStore.repository;

import ks.msx.MusicStore.entity.UserE;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserE, Long> {

    UserDetails getUserByUsername(String username);
}
