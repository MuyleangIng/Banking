package co.odin.senapi.api.user;

import co.odin.senapi.api.user.web.CreateUserDto;
import co.odin.senapi.api.user.web.UserDto;

public interface UserService {
    UserDto createNewUser(CreateUserDto createUserDto);
    UserDto findUserById(Integer id );
    Integer deleteUserById(Integer id);
}
