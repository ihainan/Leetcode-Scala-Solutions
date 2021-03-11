package me.ihainan;

class R1009Solution2 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        else return find(matrix.length - 1, 0, matrix, target);
    }

    public boolean find(int x, int y, int[][] matrix, int target) {
        if (x < 0 || y >= matrix[0].length) return false;
        else if (matrix[x][y] == target) return true;
        else if (matrix[x][y] > target) return find(x - 1, y, matrix, target);
        else return find(x, y + 1, matrix, target);
    }
}