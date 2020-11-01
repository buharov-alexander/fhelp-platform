package ru.buharov.fhelp.account;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;
import ru.buharov.fhelp.account.domain.AccountTypeEnum;
import ru.buharov.fhelp.account.domain.ValutaEnum;
import ru.buharov.fhelp.account.dto.AccountView;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ru.buharov.fhelp.account.AccountAPIUtils.createAccountJson;
import static ru.buharov.fhelp.account.AccountAPIUtils.deleteAccount;
import static ru.buharov.fhelp.account.AccountAPIUtils.getAccount;
import static ru.buharov.fhelp.account.AccountAPIUtils.getAccountList;
import static ru.buharov.fhelp.account.AccountAPIUtils.saveAccount;

@SpringBootTest(
        classes = AccountServiceApplication.class)
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
@TestPropertySource(
        locations = "classpath:application-test.properties")
public class AccountAPITest {

    private static final String TEST_ACCOUNT_NAME = "TestAccount";
    @Autowired
    protected MockMvc mvc;

    @Test
    void saveAccount_thenCheck_thenDelete() throws Exception {
        // check that account doesn't exist
        checkAccountNotExist(TEST_ACCOUNT_NAME);

        // save account
        AccountView accountView = saveAccount(TEST_ACCOUNT_NAME, mvc);

        // check that account is saved
        accountView = getAccount(accountView.getId(), mvc);
        Assert.isTrue(accountView.getName().equals(TEST_ACCOUNT_NAME), "Found account has unexpected name");

        // delete account
        deleteAccount(accountView.getId(), mvc);

        // check that account was removed
        checkAccountNotExist(TEST_ACCOUNT_NAME);
    }

    @Test
    void saveAccount_withoutType() throws Exception {
        String accountBody = createAccountJson(TEST_ACCOUNT_NAME, null, ValutaEnum.RUB);
        mvc.perform(post("/account")
                .content(accountBody)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest()).andReturn();
    }

    @Test
    void saveAccount_withoutValuta() throws Exception {
        String accountBody = createAccountJson(TEST_ACCOUNT_NAME, AccountTypeEnum.CASH, null);
        mvc.perform(post("/account")
                .content(accountBody)
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isBadRequest()).andReturn();
    }

    private void checkAccountNotExist(String name) throws Exception {
        List<AccountView> list = getAccountList(mvc);
        Assert.isTrue(
                list.stream().noneMatch(account -> account.getName().equals(name)),
                "Account already exists"
        );
    }
}
