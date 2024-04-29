package unittest.unittest.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import unittest.unittest.entities.User;
import unittest.unittest.services.UserService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v2")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    public ResponseEntity<User> addUser(@RequestBody User user) {
        userService.createUser(user);
        return ResponseEntity.ok().body(user);
    }

    @GetMapping("/getlist")
    public ResponseEntity<List<User>> getAllUser() {
        List<User> allUsers = userService.getAllUser();
        return ResponseEntity.ok().body(allUsers);
    }

    @GetMapping("/getuser/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id) {
        Optional<User> userOptional = userService.getUser(id);
        return ResponseEntity.ok().body(userOptional);
    }

    @PutMapping("/updateuser/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody User user, @PathVariable Long id) {
        Optional<User> userOptional = userService.updateUser(id, user);
        if (userOptional.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(userOptional.get());
    }

    @DeleteMapping("/delete")
    public ResponseEntity<User> deleteUser(@RequestParam Long id) {
        Optional<User> deletedUser = userService.deleteUser(id);
        if (deletedUser.isPresent()) {
            return ResponseEntity.ok().body(deletedUser.get());
        }
        return ResponseEntity.notFound().build();
    }


}