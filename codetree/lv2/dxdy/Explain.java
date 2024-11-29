package lv2.dxdy;

public class Explain {
    /**
     * dx, dy 를 사용하여 2차원 배열을 푸는 방법에서는 x 를 행, y 를 열 로 생각해서 푼다.
     * 또한 상하좌우 같은 방향을 나타내는 경우엔 dx, dy 배열을 다음과 같이 만들어서 해결한다.
     *   int[] dx = new int[]{0, 1,  0, -1};
     *   int[] dy = new int[]{1, 0, -1,  0};
     *   90도 회전의 경우에도 위의 dx, dy 를 사용하면 해결할 수 있다. dirNum %= 4; 이런식으로 해결할 수 있다.
     *
     *   또한 각 격자 끝의 길이를 넘어가면 IndexOutOfBoundException 이 발생할 수 있기 때문에 항상 확인하는 함수를 만들어야 한다.
     */
}
