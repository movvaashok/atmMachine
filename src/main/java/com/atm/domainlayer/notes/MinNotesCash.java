package com.atm.domainlayer.notes;

import java.util.List;

interface IMinNotesCash {
    //no
}

//todo - can this implement ICash ?
public class MinNotesCash implements IMinNotesCash {
    public int countOfFiftyNote;
    public int countOfTwentyNote;
    public int countOfTenNote;
    public int countOfFiveNote;

    public MinNotesCash(int amount, List<Integer> notes) {
        List<Integer> minNotes = new MinCombination().getResult(amount, notes);
        //System.out.println(minNotes);
        minNotes.forEach(item -> updateValues(item));
    }

    private void updateValues(int noteValue) {
        if (noteValue == 50) {
            countOfFiftyNote++;
        } else if (noteValue == 20) {
            countOfTwentyNote++;
        } else if (noteValue == 10) {
            countOfTenNote++;
        } else if (noteValue == 5) {
            countOfFiveNote++;
        } else {
            //todo - invalid state - handle
            throw new RuntimeException();
        }
    }
}

