package co.odin.senapi.api.accountype;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AccountTypeServiceImpl implements AccountTypeService{

    private final AccountTypeMapper accountTypeMapper;
    private final AccountTypeMapStruct accountTypeMapStruct;
    @Override
    public List<AccountTypeDto> findAll() {
        List<AccountType> accountTypes = accountTypeMapper.select();
        log.info("fdsfsdf={}",accountTypes);
//        List<AccountTypeDto> accountTypeDtoList =  accountTypes.stream().map(accountType -> new AccountTypeDto(accountType.getName())).toList();
        return accountTypeMapStruct.toDto(accountTypes);
    }
}
