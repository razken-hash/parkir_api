package com.parkir.parkir_api.users;

import com.parkir.parkir_api.ParkirConsts;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ParkirConsts.baseUrl + "/auth")
public class UserController {
    @PostMapping("/login")
    public void loginUser(@RequestBody User user) {

    }

    @PostMapping("/register")
    public void registerUser(@RequestBody User user) {

    }

    @PostMapping("/get_otp")
    public String requestOtp(@RequestParam("email") String email) {
        //TODO: Send an email
        return "12345";
    }

    @PostMapping("/verify_otp")
    public Boolean verifyOtp(@RequestParam("email") String email, @RequestParam("otp") String otp) {
        return otp.equals("12345");
    }

    @PostMapping("/recover_password")
    public void recoverPassword(@RequestParam("email") String email, @RequestParam("newPassword") String newPassword) {

    }

    @PostMapping("/change_password")
    public void changePassword(@RequestParam("email") String email, @RequestParam("currentPassword") String currentPassword, @RequestParam("newPassword") String newPassword) {

    }

    @PutMapping("/update/{userId}")
    public void register(@PathVariable("userId") Integer userId,
                         @RequestParam(value = "phoneNumber", required = false) String phoneNumber,
                         @RequestParam(value = "name", required = false) String name,
                         @RequestParam(value = "gender", required = false) String gender) {
    }
}
