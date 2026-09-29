package com.cst323.demo.business;

import com.cst323.demo.data.UserRepo;
import com.cst323.demo.data.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class RegistrationService implements RegistrationServiceInterface, UserDetailsService {

    @Autowired
    private UserRepo repo;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public void registerUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repo.save(user);
    }

    @Override
    public void deleteUser(UserEntity user){
        repo.deleteById(user.getId());
    }

    /*private UserEntity nameFinder(String firstName){
        return repo.findByFirstName(firstName);
    }*/

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity user = repo.findByFirstName(username);
        if (user != null){
            // switch to tilda if
            List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
            authorities.add(new SimpleGrantedAuthority("USER"));
            return new User(user.getFirstName(), user.getPassword(), authorities);
        } else {
            throw new UsernameNotFoundException("Username Not Found");
        }
    }
}
}
