package baseball.view;

import baseball.domain.GameResult;

public class PrintGameResult {
    public static void printMessage(GameResult gameResult) {
        if (gameResult.isNothing()) {
            System.out.println("낫싱");
            return;
        }

        System.out.println(gameResult.getStrikeCount() + " 스트라이크 ," + gameResult.getBallCount() + " 볼");
    }
}
