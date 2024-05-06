package ks.msx.MusicStore.service;

import ks.msx.MusicStore.entity.UserDTO;
import ks.msx.MusicStore.entity.UserE;
import ks.msx.MusicStore.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.getUserByUsername(username);
    }

    public UserE returnUserByEmail(String email){
        try {
            return userRepository.getUserByEmail(email);
        } catch (Exception e){
            e.getStackTrace();
            System.out.println("User not found by email");
        }
        return null;
    }

    public void saveUser(UserDTO dto){
        userRepository.save(
                UserE.builder()
                        .username(dto.getUsername())
                        .password(dto.getPassword())
                        .email(dto.getEmail())
                        .build()
        );
    }


}
