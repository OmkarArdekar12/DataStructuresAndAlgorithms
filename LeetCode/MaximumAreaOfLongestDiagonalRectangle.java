// Maximum Area of Longest Diagonal Rectangle

public class MaximumAreaOfLongestDiagonalRectangle {
    public static int areaOfMaxDiagonal(int[][] dimensions) {
        //simply using pythagoras theorem
        int n = dimensions.length;
        int maxArea = 0, maxDiagonalSq = 0;
        for(int i=0; i<n; ++i) {
            int length = dimensions[i][0];
            int width = dimensions[i][1];

            int area = length * width;
            int diagonalSq = (length * length) + (width * width);

            if(diagonalSq > maxDiagonalSq) {
                maxDiagonalSq = diagonalSq;
                maxArea = area;
            } else if(diagonalSq == maxDiagonalSq) {
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        int[][] dimensions = {{9,3},{8,6}};
        System.out.println(areaOfMaxDiagonal(dimensions));
    }
}