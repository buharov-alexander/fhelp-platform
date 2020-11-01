package ru.buharov.fhelp.account;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.buharov.fhelp.account.domain.AccountTypeEnum;
import ru.buharov.fhelp.account.domain.ValutaEnum;
import ru.buharov.fhelp.account.dto.AccountView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

class AccountAPIUtils {
    static void deleteAccount(UUID id, MockMvc mvc) throws Exception {
        mvc.perform(delete("/account/{id}", id))
                .andExpect(status().isOk());
    }

    static AccountView getAccount(UUID id, MockMvc mvc) throws Exception {
        MvcResult result = mvc.perform(get("/account/{id}", id).contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result.getResponse().getContentAsString(), AccountView.class);    }

    static AccountView saveAccount(String name, MockMvc mvc) throws Exception {
        String accountBody = createAccountJson(name, AccountTypeEnum.CASH, ValutaEnum.RUB);
        MvcResult result = mvc.perform(post("/account")
                .content(accountBody)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(result.getResponse().getContentAsString(), AccountView.class);
    }

    static List<AccountView> getAccountList(MockMvc mvc) throws Exception {
        MvcResult result = mvc.perform(get("/account/list").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk()).andReturn();

        ObjectMapper objectMapper = new ObjectMapper();
        AccountView[] accounts = objectMapper.readValue(result.getResponse().getContentAsString(), AccountView[].class);
        return Arrays.asList(accounts);
    }

    static String createAccountJson(String name, AccountTypeEnum type, ValutaEnum valuta) throws JsonProcessingException {
        AccountView accountView = AccountView.builder()
                .name(name)
                .type(type)
                .valuta(valuta)
                .build();
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(accountView);
    }
}
