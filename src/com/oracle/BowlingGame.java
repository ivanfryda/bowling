package com.oracle;

import java.util.Arrays;

public class BowlingGame {

    private static final int MAX_POSSIBLE_THROWS = 21;
    private static final int FRAME_COUNT = 10;
    private static final int ALL_PINS = 10;

    private int currentBall = 0;
    private int[] balls = new int[MAX_POSSIBLE_THROWS];

    public int score() {
        int score = 0;
        for (int frame = 0, currentBall = 0; frame < FRAME_COUNT; frame++) {
            if (balls[currentBall] == ALL_PINS) {
                score += ALL_PINS + balls[currentBall + 1] + balls[currentBall + 2];
                currentBall++;
            } else {
                if (balls[currentBall] + balls[currentBall + 1] == ALL_PINS) {
                    score += balls[currentBall + 2];
                }
                score += balls[currentBall] +  balls[currentBall + 1];
                currentBall += 2;
            }
        }
        return score;
    }

    public boolean throwBall(int ball) {
        int strikeBalls = (int) Arrays.stream(balls).filter(it -> it == 10).count();
        int pinsLeft = (currentBall - strikeBalls) % 2 == 0 ? ALL_PINS : ALL_PINS - balls[currentBall - 1];
        if (ball >= 0 && ball <= pinsLeft) {
            balls[currentBall++] = ball;
            return true;
        }
        return false;
    }

    public void throwBalls(int[] balls) {
        for (int i = 0; i < MAX_POSSIBLE_THROWS && i < balls.length; i++) {
            if (!throwBall(balls[i])) {
                throw new IllegalArgumentException();
            }
        }
    }
}
