import java.util.Scanner;

/**
 * 3. A queen is standing on an n x n chessboard. In a single move, she can
 * attack any square in any of the directions (left, right, top, bottom and
 * diagonal). There can be obstacles 'K' on the chessboard, each preventing the
 * queen from attacking any square beyond it on that path. Determine how many
 * squares the queen can attack including the obstacles. Chessboard size, the
 * queen's position, number of obstacles and their position's should be obtained
 * as input. In the first diagram the Q is placed in (2,2) and there are no
 * obstacles. So the queen can strike all the cells that are covered by arrows.
 * So the answer is 16 (i.e) the queen can attack 16 squares.
 * 
 * In the second, Q is placed in (2,2) and there are two obstacles. One at (1,3)
 * and (2,1). so now the queen can strike only 14 places ( Includes the
 * obstacles too)
 * 
 * In the third, Q is placed in (2,2) and there is one obstacle at (0,3). The
 * queen can now strike in 16 places since K is not in its path.
 */

public class queensPossiblePositions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("enter board size ");
        int n = scanner.nextInt();
        int[][] board = new int[n][n];

        System.out.print("enter queen's position as 'x,y': ");
        String queen = scanner.next();
        int xQueen = Integer.parseInt(queen.split(",")[0]);
        int yQueen = Integer.parseInt(queen.split(",")[1]);
        board[xQueen][yQueen] = 0;

        System.out.print("enter number of obstacles ");
        int t = scanner.nextInt();
        while (t > 0) {
            System.out.print("enter obstacles's position as 'x,y' ");
            String obstacle = scanner.next();
            int x = Integer.parseInt(obstacle.split(",")[0]);
            int y = Integer.parseInt(obstacle.split(",")[1]);
            board[x][y] = 1;
            t--;
        }

        int top = -1, bottom = -1, left = -1, right = -1, forwardDiagonal = -2, backwardDiagonal = -2,
                obstacleInWay = 0;

        // top
        for (int i = xQueen; i >= 0; i--) {
            if (board[i][yQueen] == 1) {
                obstacleInWay++;
                break;
            }
            top++;
        }

        // bottom
        for (int i = xQueen; i < n; i++) {
            if (board[i][yQueen] == 1) {
                obstacleInWay++;
                break;
            }
            bottom++;
        }

        // left
        for (int i = yQueen; i >= 0; i--) {
            if (board[xQueen][i] == 1) {
                obstacleInWay++;
                break;
            }
            left++;
        }

        // right
        for (int i = yQueen; i < n; i++) {
            if (board[xQueen][i] == 1) {
                obstacleInWay++;
                break;
            }
            right++;
        }

        // top-right
        int i = xQueen, j = yQueen;
        while (i >= 0 && j < n) {
            if (board[i][j] == 1) {
                obstacleInWay++;
                break;
            }
            i--;
            j++;
            forwardDiagonal++;
        }

        // bottom-left
        i = xQueen;
        j = yQueen;
        while (j >= 0 && i < n) {
            if (board[i][j] == 1) {
                obstacleInWay++;
                break;
            }
            j--;
            i++;
            forwardDiagonal++;
        }

        // top-left
        i = xQueen;
        j = yQueen;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1) {
                obstacleInWay++;
                break;
            }
            i--;
            j--;
            backwardDiagonal++;
        }

        // bottom-right
        i = xQueen;
        j = yQueen;
        while (i < n && j < n) {
            if (board[i][j] == 1) {
                obstacleInWay++;
                break;
            }
            i++;
            j++;
            backwardDiagonal++;
        }

        System.out.println(top + bottom + left + right + forwardDiagonal + backwardDiagonal + obstacleInWay);
        scanner.close();
    }
}
