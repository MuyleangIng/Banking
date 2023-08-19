package co.odin.senapi.api.user;

import co.odin.senapi.api.user.web.CreateUserDto;
import co.odin.senapi.api.user.web.UserDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapStruct {
    User createUserDtoToUser(CreateUserDto createUserDto);
    UserDto userToUserDto(User user);
    User userDtoToUser(UserDto userDto);
}
