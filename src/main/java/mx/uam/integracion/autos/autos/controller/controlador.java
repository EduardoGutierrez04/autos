package mx.uam.integracion.autos.autos.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import mx.uam.integracion.autos.autos.dto.UserDTO;
import mx.uam.integracion.autos.autos.service.UserService;

@RestController
@RequestMapping("/v1")
public class controlador {

    private UserService userService;

    public controlador(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserDTO setUser(@RequestBody UserDTO userDTO) {

        return userService.createUser(userDTO);
    }
    @GetMapping("/user")
    public List<UserDTO> getUsers() {
        for (UserDTO userDTO : userService.getAllUsers()) {
            System.out.println(userDTO);
        }
        return List.of(userService.getAllUsers());
    }
    @GetMapping("/user/{user}")
    public ResponseEntity<UserDTO> getUser(@PathVariable("user") String user) {
        UserDTO userDTO = null;
        for (UserDTO userDTO2 : userService.getAllUsers()) {
            if (userDTO2.getUser().equals(user)) {
                userDTO = userDTO2;
                break;
            }
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @DeleteMapping("/user/{user}")
    public ResponseEntity<UserDTO> deleteUser(@PathVariable("user") String user) {
        UserDTO userDTO = null;
        for (UserDTO userDTO2 : userService.getAllUsers()) {
            if (userDTO2.getUser().equals(user)) {
                userDTO = userDTO2;
                break;
            }
        }
        if (userDTO != null) {
            userService.deleteUser(userDTO);
        }
        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping("/test")
    public String test() {
        return "hola mundo";
    }

@PutMapping("/user/{user}")
  public ResponseEntity<UserDTO> updateUser(@PathVariable("user") String user, @RequestBody UserDTO userDTO) {
        UserDTO userDTO2 = userService.updateUser(user, userDTO);
        return new ResponseEntity<>(userDTO2, HttpStatus.OK);
}

}
