package baseball.view;

import baseball.domain.GameResult;

public class PrintGameOver {
    public static void printResult(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(gameResult.getStrikeCount() + " 스트라이크 ," + gameResult.getBallCount() + " 볼");
    }
}
