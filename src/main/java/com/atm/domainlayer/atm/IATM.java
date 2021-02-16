package com.atm.domainlayer.atm;

//todo IATM to be renamed to ATMInterface ?
//todo follow same pattern for others
public interface IATM {
    String dispense(int number, int pin, int amount);
}
