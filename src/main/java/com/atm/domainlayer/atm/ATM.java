package com.atm.domainlayer.atm;

import com.atm.domainlayer.Account;
import com.atm.domainlayer.Cash;
import com.atm.domainlayer.notes.*;

import java.util.Arrays;

public class ATM implements IATM {
    private Account account1;
    private Account account2;
    private Cash cash;

    public ATM() {
        //initialize
        setAccounts();
        setMoney();
    }

    private void setMoney() {
        cash = new Cash(
                10,
                30,
                30,
                20);
    }

    private void setAccounts() {
        account1 = new Account(
                123456789,
                1234,
                800,
                200
        );
        account2 = new Account(
                987654321,
                4321,
                1230,
                150
        );

    }

    //todo - think of tuple to understand returned string error or not
    @Override
    public String dispense(int number, int pin, int amount) {
        Account account = getAccount(number, pin);
        //todo remove null using NULL object pattern
        if (account != null) {
            if (cash.value() > amount) {
                //todo - remove getter as it is not OOP
                //if (account.getBalance() > amount) {
                if ((account.getBalance() + account.getOverdraft()) > amount) {
                    MinNotesCash cashToCustomer = new MinNotesCash(
                            amount,
                            Arrays.asList(
                                    new FiftyNote().value(),
                                    new TwentyNote().value(),
                                    new TenNote().value(),
                                    new FiveNote().value()));
                    giveCashToCustomer(cashToCustomer);
                    return stringOfCashGivenToCustomer(cashToCustomer);
                    //todo remove else use Strategy Pattern
                } else {
                    //todo think about overdraft
                    return "NO sufficient balance";
                }
            } else {
                return "ATM doesn't have that much";
            }
        } else {
            return "wrong account details";
        }
    }

    private void giveCashToCustomer(MinNotesCash cashToCustomer) {
        //todo - reduce in cash and add in account
        deduct(cashToCustomer);
    }

    //todo - follow CQS(Command Query Separation)
    //todo - change print to get so that presentation layer takes care of printing
    //todo - below only needed as rest call
    private int printBalanceOfCustomer(Account account) {
        return account.getBalance();
    }

    //todo - add print method inside Cash directly
    //todo - change print to get so that presentation layer takes care of printing
    private String stringOfCashGivenToCustomer(MinNotesCash cashToCustomer) {
        String cashAsString =
                "CASH:\n" +
                        "50 Euro Notes: " + cashToCustomer.countOfFiftyNote + "\n" +
                        "20 Euro Notes: " + cashToCustomer.countOfTwentyNote + "\n" +
                        "10 Euro Notes: " + cashToCustomer.countOfTenNote + "\n" +
                        "5 Euro Notes: " + cashToCustomer.countOfFiveNote + "\n";
        //remove printing to console?
        //System.out.println(cashAsString);
        return cashAsString;
    }

    private Account getAccount(int account, int pin) {
        //todo
        if (account == 123456789 && pin == 1234) {
            return account1;
        } else if (account == 987654321 && pin == 4321) {
            return account2;
        }
        return null;
    }

    //todo this can be moved to interface?
    private void deduct(MinNotesCash minNotesCash) {
        this.cash.countOfFiftyNote = this.cash.countOfFiftyNote - minNotesCash.countOfFiftyNote;
        this.cash.countOfTwentyNote = this.cash.countOfTwentyNote - minNotesCash.countOfTwentyNote;
        this.cash.countOfTenNote = this.cash.countOfTenNote - minNotesCash.countOfTenNote;
        this.cash.countOfFiveNote = this.cash.countOfFiveNote - minNotesCash.countOfFiveNote;
    }
}

