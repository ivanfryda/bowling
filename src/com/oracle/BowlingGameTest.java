package com.oracle;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class BowlingGameTest {

    private BowlingGame bowlingGame;

    @Before
    public void setUp() {
        bowlingGame = new BowlingGame();
    }

    @Test
    public void testIncompleteScore() {
        bowlingGame.throwBalls(new int[] {2, 3, 10});
        assertThat(bowlingGame.score(), is(15));
    }

    @Test
    public void testPerfectGame() {
        bowlingGame.throwBalls(new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10});
        assertThat(bowlingGame.score(), is(300));
    }

    @Test
    public void testSpare() {
        bowlingGame.throwBalls(new int[] {2, 8, 5});
        assertThat(bowlingGame.score(), is(20));
    }

    @Test
    public void testAlmostPerfectGame() {
        bowlingGame.throwBalls(new int[] {10, 10, 10, 10, 10, 10, 10, 10, 10, 9, 1, 10});
        assertThat(bowlingGame.score(), is(279));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowBalls1() {
        bowlingGame.throwBalls(new int[] {8, 3});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowBalls2() {
        bowlingGame.throwBalls(new int[] {10, 7, 3, 9, 2});
    }

    @Test(expected = IllegalArgumentException.class)
    public void testThrowBalls3() {
        bowlingGame.throwBalls(new int[] {10, 7, 3, 9, 1, 5, 5, 4, 6, 2, 8, 2, 2, 4, 4, 6, 3, 10, 2, 9});
    }
}
