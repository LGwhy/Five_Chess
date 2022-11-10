package wuziqi;

public class Judge implements FiveChess {
	private int x, y;
	private int count;
 
	public Judge(int x, int y) {
		this.x = x;
		this.y = y;
	}
 
	boolean judge() {
		if (judge1(x, y) >= 5)
			return true;
		return false;
	}
 
	public int judge1(int x1, int y2) {
 
		// 横向检查（coloum）
		count = 1;
		for (int i = x1 + 1; i < coloum; i++) {   //每行向右方向遍历
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][y2]) {    //每一行有相连着的颜色，count+1
					count++;
				} else
					break;
			} else
				break;
		}
		for (int i = x1 - 1; i >= 0; i--) {    //每行向左方向遍历
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][y2]) {
					count++;
				} else
					break;
			} else
				break;
		}
 
		if (count >= 5)    //只要五子相连，则判定为胜
			return count;
 
		// 纵向检查（row）
		count = 1;
		for (int i = y2 + 1; i < row; i++) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[x1][i]) {
					count++;
				} else
					break;
			} else
				break;
		}
		for (int i = y2 - 1; i >= 0; i--) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[x1][i]) {
					count++;
				} else
					break;
			} else
				break;
		}
 
		if (count >= 5)
			return count;
 
		// 斜向检查
		count = 1;
		// 左上到右下
		for (int i = x1 + 1, j = y2 + 1; i < coloum && j < row; i++, j++) {
			if (array1[x1][y2] != 0) {      
				if (array1[x1][y2] == array1[i][j]) {   //行列同时移动，相当于（1，1）（2，2）（3，3）
					count++;     //等于初始位置棋子颜色则count+1
				} else
					break;
			} else
				break;
		}
		// 右下到左上
		for (int i = x1 - 1, j = y2 - 1; i >= 0 && j >= 0; i--, j--) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][j]) {
					count++;
				} else
					break;
			} else
				break;
		}
		if (count >= 5)
			return count;
 
		count = 1;
		// 左下到右上
		for (int i = x1 + 1, j = y2 - 1; i < coloum && j >= 0; i++, j--) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][j]) {
					count++;
				} else
					break;
			} else
				break;
		}
		// 右上到左下
		for (int i = x1 - 1, j = y2 + 1; i >= 0 && j < row; i--, j++) {
			if (array1[x1][y2] != 0) {
				if (array1[x1][y2] == array1[i][j]) {
					count++;
				} else
					break;
			} else
				break;
		}
 
		return count;
 
	}
}
