/**
 * 
 * 407. Trapping Rain Water II
 * 
 * 
 */


// s1: use Heap
// O(m*n*log(m*n)), O(m * n)
// tricky

public class Solution {
    public int trapRainWater(int[][] heightMap) {
        // corner case
        if (heightMap == null || heightMap.length == 0) {
            return 0;
        }
        if (heightMap[0] == null || heightMap[0].length == 0) {
            return 0;
        }
        int m = heightMap.length;
        int n = heightMap[0].length;
        int[][] map = new int[m][n];
        
        Queue<Point> queue = new PriorityQueue<Point>(new Comparator<Point>(){
                @Override
                public int compare(Point p1, Point p2) {
                    return p1.height - p2.height;
                }
            });
        
        // offer the 4 sides points to queue
        for (int i = 0; i < n; i++) {
            Point p1 = new Point(0, i, heightMap[0][i]);
            queue.offer(p1);
            map[0][i] = 1;
            
            Point p2 = new Point(m - 1, i, heightMap[m - 1][i]);
            queue.offer(p2);
            map[m - 1][i] = 1;
        }
        
        for (int i = 1; i < m - 1; i++) {
            Point p3 = new Point(i, 0, heightMap[i][0]);
            queue.offer(p3);
            map[i][0] = 1;
            
            Point p4 = new Point(i, n - 1, heightMap[i][n - 1]);
            queue.offer(p4);
            map[i][n - 1] = 1;
        }
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        
        int h = 0;
        int result = 0;
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            h = p.height;
            
            for (int i = 0; i < 4; i++) {
                int nx = p.x + dx[i];
                int ny = p.y + dy[i];
                if (isValid(nx, ny, map)) {
                    if (height[nx][ny] < h) {
                        result += h - height[nx][ny];
                        Point new_p = new Point(nx, ny, h);
                        queue.offer(new_p);
                    } else {
                        Point new_p = new Point(nx, ny, height[nx][ny]);
                        queue.offer(new_p);
                    }
                    map[nx][ny] = 1;
                    break;
                }
            }
        }
        return result;
    }
    
    
    public boolean isValid(int nx, int ny, int[][] map) {
        int m = map.length;
        int n = map[0].length;
        if (nx >= 0 && nx < m && ny >= 0 && ny < n && map[nx][ny] != 1){
            return true;
        }
        return false;
    }
    
}

class Point {
    int x;
    int y;
    int height;
    
    public Point(int x, int y, int height) {
        this.x = x;
        this.y = y;
        this.height = height;
    }
}
