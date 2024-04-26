package demo.com.example.demo.controller;

import demo.com.example.demo.services.UserService;
import demo.com.example.demo.model.mapper.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
@Autowired
private UserService userService;
   @GetMapping("/search")
   public ResponseEntity<?> searchUser(@RequestParam(name= "keyword" , required = false, defaultValue = "") String name ) {
       List<UserDto> users = userService.searchUser(name);
       return ResponseEntity.ok(users) ;

   }

@GetMapping("")
    public ResponseEntity<?> getListUser() {
        List<UserDto> users = userService.getListUser();
        return ResponseEntity.ok(users) ;
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable int id) {
UserDto result = userService.getUserById(id);
        return ResponseEntity.ok(result) ;

    }
    @PostMapping("")
    public ResponseEntity<?> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.ok(createdUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody UserDto userDto) {
        UserDto updatedUser = userService.updateUser(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("User deleted successfully");
    }


}
