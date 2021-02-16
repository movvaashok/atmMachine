package com.atm;

import com.atm.domainlayer.notes.MinCombination;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MinCombinationTest {
    //todo - use proper Combination examples rather than 7 , 8 and 100

    //amount
    //notes
    //result

    //7
    //5,3,4,7
    //7
    //List<Integer> notes = Arrays.asList(5, 3, 4, 7);


    //8
    //2,3,5
    //5,3
    //List<Integer> notes = Arrays.asList(2,3,5);

    // 8
    //1,4,5
    //4,4
    //List<Integer> notes = Arrays.asList(1,4,5);


    //100
    //1,2,5,25
    //25,25,25,25
    //List<Integer> notes = Arrays.asList(1, 2, 5, 25);

    @Test
    void shouldHaveCorrectCombination1() {
        //arrange
        MinCombination classUnderTest = new MinCombination();
        int amount = 7;
        List<Integer> notes = Arrays.asList(5, 3, 4, 7);


        //act
        List<Integer> actual = classUnderTest.getResult(amount, notes);

        //assert
        List<Integer> expected = Arrays.asList(7);
        assertEquals(expected, actual);
    }

    @Test
    void shouldHaveCorrectCombination2() {
        //arrange
        MinCombination classUnderTest = new MinCombination();
        int amount = 8;
        List<Integer> notes = Arrays.asList(2,3, 5);


        //act
        List<Integer> actual = classUnderTest.getResult(amount, notes);

        //assert
        List<Integer> expected = Arrays.asList(5, 3);
        assertEquals(expected, actual);
    }

    @Test
    void shouldHaveCorrectCombination3() {
        //arrange
        MinCombination classUnderTest = new MinCombination();
        int amount = 8;
        List<Integer> notes = Arrays.asList(1, 4, 5);


        //act
        List<Integer> actual = classUnderTest.getResult(amount, notes);

        //assert
        List<Integer> expected = Arrays.asList(4, 4);
        assertEquals(expected, actual);
    }

    @Test
    void shouldHaveCorrectCombination4() {
        //arrange
        MinCombination classUnderTest = new MinCombination();
        int amount = 100;
        List<Integer> notes = Arrays.asList(1, 2, 5, 25);


        //act
        List<Integer> actual = classUnderTest.getResult(amount, notes);

        //assert
        List<Integer> expected = Arrays.asList(25, 25, 25, 25);
        assertEquals(expected, actual);
    }
}
