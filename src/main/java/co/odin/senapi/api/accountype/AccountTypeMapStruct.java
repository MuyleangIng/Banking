package co.odin.senapi.api.accountype;

import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountTypeMapStruct {
    List<AccountTypeDto> toDto(List<AccountType> model);
}
