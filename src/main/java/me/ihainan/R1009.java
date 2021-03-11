package me.ihainan;

class R1009 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        else return find(0, 0, matrix.length - 1, matrix[0].length - 1, matrix, target);
    }

    public boolean find(int x1, int y1, int x2, int y2, int[][] matrix, int target) {
        if (x1 > x2 || y1 > y2) return false;
        else {
            int mx = (x1 + x2) / 2;
            int my = (y1 + y2) / 2;
            if (matrix[mx][my] == target) return true;
            else if (matrix[mx][my] > target) {
                return find(x1, y1, mx - 1, y2, matrix, target) || find(mx, y1, x2, my - 1, matrix, target);
            } else {
                return find(x1, my + 1, x2, y2, matrix, target) || find(mx + 1, y1, x2, my, matrix, target);
            }
        }
    }
}