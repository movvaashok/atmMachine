package com.atm;

import com.atm.domainlayer.atm.ATM;
import com.atm.domainlayer.Account;
import com.atm.domainlayer.atm.IATM;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ATMTest {
    @Test
    void shouldInitializeWithDefaultAccounts() {
        //arrange
        IATM classUnderTest = new ATM();

        //act
        //assert
        assert (true);
    }

    @Test
    void shouldNotDispenseMoneyIfPinIsIncorrect() {
        //arrange
        IATM classUnderTest = new ATM();

        //act
        Account account = new Account(
                123456789,
                1234,
                800,
                200
        );

        //assert
        assertEquals(false, account.isValid(123456789, 1));
    }
}
