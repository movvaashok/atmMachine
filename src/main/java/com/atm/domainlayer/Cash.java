package com.atm.domainlayer;

import com.atm.domainlayer.notes.FiftyNote;
import com.atm.domainlayer.notes.FiveNote;
import com.atm.domainlayer.notes.TenNote;
import com.atm.domainlayer.notes.TwentyNote;

interface ICash {
    int countOfFiftyNote();

    int countOfTwentyNote();

    int countOfTenNote();

    int countOfFiveNote();

    default int value() {
        return ((countOfFiftyNote() * new FiftyNote().value())
                +
                (countOfTwentyNote() * new TwentyNote().value())
                +
                (countOfTenNote() * new TenNote().value())
                +
                (countOfFiveNote() * new FiveNote().value()));
    }

}

public class Cash implements ICash {
    //todo Map is better ?
    //todo private instead of public
    public int countOfFiftyNote;
    public int countOfTwentyNote;
    public int countOfTenNote;
    public int countOfFiveNote;

    //todo remove coupling with currency
    //todo use respective Note instead of int - typealias of int
    public Cash(int fifty, int twenty, int ten, int five) {
        this.countOfFiftyNote = fifty;
        this.countOfTwentyNote = twenty;
        this.countOfTenNote = ten;
        this.countOfFiveNote = five;
    }

    @Override
    public int countOfFiftyNote() {
        return this.countOfFiftyNote;
    }

    @Override
    public int countOfTwentyNote() {
        return this.countOfTwentyNote;
    }

    @Override
    public int countOfTenNote() {
        return this.countOfTenNote;
    }

    @Override
    public int countOfFiveNote() {
        return this.countOfFiveNote;
    }
}

//todo use this if separate class for each not is not feasible
enum NOTE {
    FIFTY(50),
    TWENTY(20),
    TEN(10),
    FIVE(5);
    private final int value;

    private NOTE(int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }
}