package mx.uam.integracion.autos.autos.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import mx.uam.integracion.autos.autos.dto.UserDTO;
import mx.uam.integracion.autos.autos.entity.User;
import mx.uam.integracion.autos.autos.repository.UserRepository;
import mx.uam.integracion.autos.autos.service.UserService;

@Service
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceimpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = new User(null, null, null, null);

        user.setId(UUID.randomUUID().toString());
        user.setName(userDTO.getName());
        user.setLastName(userDTO.getLastName());
        user.setUser(userDTO.getUser());
        

        User savedUser = userRepository.save(user);

        userDTO.setId(savedUser.getId());
        return userDTO;
    }

    @Override
    public UserDTO getUser(UserDTO user) {
        Optional<User> userOptional = userRepository.findByUser(user.getUser());
        if (userOptional.isPresent()) {
            UserDTO userDTO = new UserDTO();
            userDTO.setId(userOptional.get().getId());
            userDTO.setName(userOptional.get().getName());
            userDTO.setLastName(userOptional.get().getLastName());
            userDTO.setUser(userOptional.get().getUser());
           
            return userDTO;
        }else {
            return null;
        }
    }

    @Override
    public UserDTO updateUser(String Id, UserDTO userDTO) {
        Optional<User> userOptional = userRepository.findByUser(userDTO.getUser());
        if (userOptional.isPresent()) {
            User userToUpdate = userOptional.get();
            userToUpdate.setName(userDTO.getName());
            userToUpdate.setLastName(userDTO.getLastName());
            
            User savedUser = userRepository.save(userToUpdate);

            userDTO.setId(savedUser.getId());
            return userDTO;


        }else{
            return null;
        }
    }

    @Override
    public boolean deleteUser(UserDTO user) {
        Optional<User> userOptional = userRepository.findByUser(user.getUser());
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
            return true;
        }else {
            return false;
        }
    }

    @Override
    public UserDTO[] getAllUsers() {
        List <User> users = userRepository.findAll();
        UserDTO[] userDTOs = new UserDTO[users.size()];
        for (int i =0; i < users.size(); i++) {
            User user = users.get(i);
            UserDTO userDTO = new UserDTO();
            userDTO.setId(user.getId());
            userDTO.setName(user.getName());
            userDTO.setLastName(user.getLastName());
            userDTO.setUser(user.getUser());
            userDTOs[i] = userDTO;

        }
        return userDTOs;
    }


}
