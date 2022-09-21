package br.com.alura.school.user;

import static java.lang.String.format;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
class UserController {
    
    private final UserService userService;

    UserController(UserService userService) {
		this.userService = userService;
    }

    @GetMapping("/{username}")
    ResponseEntity<UserResponse> userByUsername(@PathVariable("username") String username) {
        return ResponseEntity.ok(userService.userByUsername(username));
    }

    @PostMapping
    ResponseEntity<Void> newUser(@RequestBody @Valid NewUserRequest newUserRequest) {
        return ResponseEntity.created(userService.newUser(newUserRequest)).build();
    }
}
