package com.pa.api.personalauditor.mapper;

import com.pa.api.personalauditor.dto.AccountDTO;
import com.pa.api.personalauditor.entity.Account;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface AccountMapper {

    @Mapping(target = "accountId", source = "entity.accountId")
    @Mapping(target = "userId", source = "entity.userId")
    AccountDTO accountEntityToAccountDto(Account entity);

    @Mapping(target = "accountId", source = "dto.accountId")
    @Mapping(target = "userId", source = "dto.userId")
    Account accountDTOToAccountEntity(AccountDTO dto);
}
