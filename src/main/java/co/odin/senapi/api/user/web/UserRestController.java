package co.odin.senapi.api.user.web;

import co.odin.senapi.api.user.UserService;
import co.odin.senapi.base.BaseRest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/v1/users")
@Slf4j
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;

    @DeleteMapping("/{id}")
    public BaseRest<?> deleteUserById(@PathVariable Integer id){
        Integer deletedId = userService.deleteUserById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been deleted successfully")
                .timestamp(LocalDateTime.now())
                .data(deletedId)
                .build();

    }

    @GetMapping("/{id}")
    public BaseRest<?> findUserById(@PathVariable Integer id){
        UserDto userDto = userService.findUserById(id);
        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been found successfully")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }

    @PostMapping
    public BaseRest<?> createNewUser(@RequestBody @Valid CreateUserDto createUserDto){
//        log.info("DTO = {}" ,createUserDto);
        UserDto userDto = userService.createNewUser(createUserDto);

        return BaseRest.builder()
                .status(true)
                .code(HttpStatus.OK.value())
                .message("User has been created successfully")
                .timestamp(LocalDateTime.now())
                .data(userDto)
                .build();
    }
}
