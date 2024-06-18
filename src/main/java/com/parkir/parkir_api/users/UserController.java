package com.parkir.parkir_api.users;

import com.parkir.parkir_api.ParkirConsts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/auth")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody User user) {
        return userService.loginUser(user);
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/signinwithgoogle")
    public User signInWithGoogle(@RequestBody User user) {
        return userService.signInWithGoogle(user);
    }

    @PostMapping("/request_otp")
    public Map<String, String> requestOtp(@RequestParam("email") String email) {
        //TODO: Send an email
        String otp = userService.requestOtp(email);
        Map<String, String> map = new TreeMap<>();
        map.put("email", email);
        map.put("otp", "12345");
        return map;
    }

    @PostMapping("/verify_otp")
    public String verifyOtp(@RequestParam("email") String email, @RequestParam("otp") String otp) {
        Boolean isOTPValid = userService.verifyOtp(email, otp);
        if (!isOTPValid) {
            return "OTP Not Valid";
        }
        return "OTP Valid";
    }

    @PostMapping("/recover_password")
    public User recoverPassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword) {
        return userService.recoverPassword(email, newPassword);
    }

    @PostMapping("/change_password/{userId}")
    public User changePassword(@PathVariable("userId") Integer userId, @RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword) {
        return userService.changePassword(userId, currentPassword, newPassword);
    }

    @PutMapping("/update/{userId}")
    public User updateUser(@PathVariable("userId") Integer userId,
                           @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                           @RequestParam(value = "name", required = false) String name,
                           @RequestParam(value = "gender", required = false) String gender) {
        return userService.updateUser(userId, name, phoneNumber, gender);
    }
}
