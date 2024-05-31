package com.wellbridge.wellbridge.rest.dto.responses.account;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.wellbridge.wellbridge.rest.dto.responses.BaseDto;
import com.wellbridge.wellbridge.rest.dto.responses.MetaResponse;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountResponse extends BaseDto {
    private MetaResponse meta;
    private AccountDataResponse data;
    private List<AccountDataResponse> datas;

    public AccountResponse(AccountDataResponse data) {
        this.data = data;
    }

    public AccountResponse(Page<AccountEntity> entities) {
        this.meta = new MetaResponse(entities.hasPrevious(), entities.hasNext(), entities.getTotalPages());
        this.datas = map(entities);
    }

    private AccountDataResponse map(AccountEntity entity) {
        return new AccountDataResponse(entity);
    }

    private List<AccountDataResponse> map(Page<AccountEntity> entities) {
        return entities.stream().map(this::map).collect(Collectors.toList());
    }
}
