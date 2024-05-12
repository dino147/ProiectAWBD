package com.alexcojocaru.proiectpwj.bootstrap;

import com.alexcojocaru.proiectpwj.model.security.Authority;
import com.alexcojocaru.proiectpwj.model.security.User;
import com.alexcojocaru.proiectpwj.repository.security.AuthorityRepository;
import com.alexcojocaru.proiectpwj.repository.security.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Component
@Profile("mysql")
public class DataLoader implements CommandLineRunner {

    private AuthorityRepository authorityRepository;
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    private void loadUserData() {
        if (userRepository.count() == 0){
            Authority adminRole = authorityRepository.save(Authority.builder().role("ROLE_ADMIN").build());
            Authority guestRole = authorityRepository.save(Authority.builder().role("ROLE_GUEST").build());

            User admin = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("12345"))
                    .authority(adminRole)
                    .build();


            User guest = User.builder()
                    .username("admin")
                    .password(passwordEncoder.encode("12345"))
                    .authority(guestRole)
                    .build();


            userRepository.save(admin);
            userRepository.save(guest);
        }
    }


    @Override
    public void run(String... args) throws Exception {
        loadUserData();
    }
}
