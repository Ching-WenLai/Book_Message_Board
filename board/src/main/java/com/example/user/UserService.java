package com.example.user;

import com.example.post.PostRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@Validated
public class UserService {
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public UserModel findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public UserModel findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Integer addUser(UserModel user) {
        Set<ConstraintViolation<UserModel>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            StringBuilder sb = new StringBuilder();
            for (ConstraintViolation<UserModel> constraintViolation : violations) {
                sb.append(constraintViolation.getMessage());
            }
            throw new ConstraintViolationException(sb.toString(), violations);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        UserModel newUser = userRepository.save(user);
        return newUser.getId();
    }

    public boolean isLogin() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return !(authentication == null || authentication instanceof AnonymousAuthenticationToken);
    }

    public String getUsername() {
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }
//    public List<PostModel> getAllStudents(){
//        return  postRepository.selectAllStudents();
//    }
//    public  int upgradeStudent(PostModel postModel ){
//        return postRepository.upgradePost(postModel);
//
//    }
//    public  int deleteStudent(UUID id){
//        return postRepository.deletePost(id);
//
//    }

}