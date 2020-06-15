package com.jczubak.crm.service;

import com.jczubak.crm.entity.Role;
import com.jczubak.crm.entity.User;
import com.jczubak.crm.repository.RoleRepository;
import com.jczubak.crm.repository.UserRepository;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository, BCryptPasswordEncoder bCryptPasswordEncoder){
        this.userRepository=userRepository;
        this.roleRepository=roleRepository;
        this.bCryptPasswordEncoder=bCryptPasswordEncoder;
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public void saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        user.setEnabled(false);
        Role userRole = roleRepository.findByName("USER");
        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        userRepository.save(user);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void createDefaultUserAccount() {
        User defaultUser = new User();
        defaultUser.setEmail("admin@gmail.com");
        defaultUser.setName("user");
        defaultUser.setSurname("user");
        defaultUser.setPassword("user");
        defaultUser.setPassword(bCryptPasswordEncoder.encode(defaultUser.getPassword()));
        Role userRole = roleRepository.findByName("ADMIN");
        defaultUser.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
        defaultUser.setEnabled(true);
        userRepository.save(defaultUser);
    }

    public void changeUserPassword(User user, String password){
        user.setPassword(bCryptPasswordEncoder.encode(password));
        userRepository.save(user);
    }

    public List<User> getUserList(){
        return userRepository.findAll();
    }

    public void deleteUserByID(Long id){
        userRepository.deleteById(id);
    }

    public void updateUser(User user){
        userRepository.save(user);
    }

    public void save_users_to_DB_who_logged_in_using_oAuth(String authorizedClientRegistrationId,OAuth2User principal){
        if("google".equals(authorizedClientRegistrationId)){

            String userName = (String) principal.getAttributes().get("name");
            String userEmail = (String) principal.getAttributes().get("email");
            String userLocale = (String) principal.getAttributes().get("locale");
            String userSUB = (String) principal.getAttributes().get("sub");

            System.out.println("Username: " + userName);
            System.out.println("User email: " + userEmail);
            System.out.println("User locale: " + userLocale);
            System.out.println("User SUB: " + userSUB);
            System.out.println("authorizedClientRegistrationId: " + authorizedClientRegistrationId);

        }else if ("facebook".equals(authorizedClientRegistrationId)){

            String userName = (String) principal.getAttributes().get("name");
            String userEmail = (String) principal.getAttributes().get("email");
            String userID = (String) principal.getAttributes().get("id");

            System.out.println("Username: " +userName);
            System.out.println("User email: " + userEmail);
            System.out.println("User ID: " +userID);
            System.out.println("authorizedClientRegistrationId: " + authorizedClientRegistrationId);

        }else if ("github".equals(authorizedClientRegistrationId)){

            String userName = (String) principal.getAttributes().get("name");
            String userURL = (String) principal.getAttributes().get("url");
            String userEmail = (String) principal.getAttributes().get("email");
            Integer userID = (Integer) principal.getAttributes().get("id");


            System.out.println("Username: " + userName);
            System.out.println("User URL: " + userURL);
            System.out.println("User email: " + userEmail);
            System.out.println("User ID: " + userID);
            System.out.println("authorizedClientRegistrationId: " + authorizedClientRegistrationId);
        }
    }
}
