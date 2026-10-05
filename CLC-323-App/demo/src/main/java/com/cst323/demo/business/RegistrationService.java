package com.cst323.demo.business;

import com.cst323.demo.data.UserRepo;
import com.cst323.demo.data.entity.UserEntity;
import com.cst323.demo.model.RegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class RegistrationService implements RegistrationServiceInterface, UserDetailsService {

    @Autowired
    private UserRepo repo;

    private final BCryptPasswordEncoder passwordEncoder;

    public RegistrationService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void registerUser(RegistrationModel registrationModel) {

        UserEntity user = new UserEntity();

            user.setFirstName(registrationModel.getFirstName());
            user.setLastName(registrationModel.getLastName());
            user.setEmail(registrationModel.getEmail());
            user.setRole(registrationModel.getRole());
            user.setPassword(passwordEncoder.encode(registrationModel.getPassword()));
            user.setCreatedAt(LocalDateTime.now());

        if (user.getFirstName() != null){
            repo.save(user);
            System.out.println("user is saved");
        }
    }

    @Override
    public void deleteUser(UserEntity user){
        repo.deleteById(user.getId());
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repo.findByEmail(username);
        if (user != null){
            // switch to tilda if
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getEmail(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("Username Not Found");
        }
    }
}
