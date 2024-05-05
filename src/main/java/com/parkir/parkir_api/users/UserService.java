package com.parkir.parkir_api.users;

import jakarta.transaction.Transactional;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.net.http.HttpResponse;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User loginUser(User user) {
        return userRepository.getUserByEmailAndHashedPassword(user.getEmail(), user.getHashedPassword()).orElseThrow(
                () -> new IllegalStateException("Auth Failed"));
    }

    public User registerUser(User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());
        if (optionalUser.isPresent()) {
            throw new IllegalStateException("User Already Exist");
        }
        return userRepository.save(user);
    }

    public String requestOtp(@RequestParam("email") String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("Email Not Exists");
        }
        return "12345";
    }

    @PostMapping("/verify_otp")
    public Boolean verifyOtp(@RequestParam("email") String email, @RequestParam("otp") String otp) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isEmpty()) {
            throw new IllegalStateException("Email Not Exists");
        }
        return otp.equals("12345");
    }

    @Transactional
    public User recoverPassword(String email, String newPassword) {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new IllegalStateException("User not exist"));
        user.setHashedPassword(newPassword);
        return user;
    }

    @Transactional
    public User changePassword(Integer userId, String currentPassword, String newPassword) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User not exist"));
        if (!user.getHashedPassword().equals(currentPassword)) {
            throw new IllegalStateException("User not exist");
        }
        user.setHashedPassword(newPassword);
        return user;
    }

    @Transactional
    public User updateUser(Integer userId, String name, String phoneNumber, String gender) {
        User user = userRepository.findById(userId).orElseThrow(() -> new IllegalStateException("User not exist"));
        if (name != null) {
            user.setName(name);
        }
        if (phoneNumber != null) {
            user.setPhoneNumber(phoneNumber);
        }
        if (gender != null) {
            user.setGender(gender);
        }
        return user;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
