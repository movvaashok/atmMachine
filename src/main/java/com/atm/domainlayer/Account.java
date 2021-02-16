package com.atm.domainlayer;

interface IAccount {
    boolean isValid(int number, int pin);
}

public class Account implements IAccount {
    private final int balance;
    private final int number;
    private final int pin;
    private final int overdraft;

    //todo use overdraft and provide maxCash method
    public Account(int number, int pin, int balance, int overdraft) {
        this.number = number;
        this.pin = pin;
        this.balance = balance;
        this.overdraft = overdraft;
    }

    public boolean isValid(int number, int pin) {
        return (this.number == number)
                &&
                (this.pin == pin);
    }

    public int getBalance() {
        return this.balance;
    }

    public int getOverdraft() {
        return this.overdraft;
    }
}
