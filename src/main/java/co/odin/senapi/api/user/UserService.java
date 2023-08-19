package co.odin.senapi.api.user;

import co.odin.senapi.api.user.web.CreateUserDto;
import co.odin.senapi.api.user.web.UserDto;
import com.github.pagehelper.PageInfo;

public interface UserService {
    UserDto createNewUser(CreateUserDto createUserDto);
    PageInfo<UserDto> findAllUsers(int page , int limit);
    UserDto findUserById(Integer id );
    Integer deleteUserById(Integer id);
    Integer updateDeletedStatus(boolean status ,Integer id);
}
