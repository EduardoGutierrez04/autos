package mx.uam.integracion.autos.autos.service;

import mx.uam.integracion.autos.autos.dto.UserDTO;

public interface  UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUser(UserDTO user);

    UserDTO updateUser(String Id, UserDTO userDTO);

    UserDTO[] getAllUsers();

    boolean deleteUser(UserDTO user);
}
