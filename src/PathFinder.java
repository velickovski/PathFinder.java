import java.util.ArrayList;
public static void main(String[] args) {
    //creating the GRID that shows the matrix representation for the path
    char[][] grid = {
            {'>', '-', '-', '-', 'A', '-', '-', '-', '+'},
            {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '|'},
            {'s', '-', 'B', '-', '+', ' ', ' ', ' ', 'C'},
            {' ', ' ', ' ', ' ', '|', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', '+', '-', '-', '-', '+'}
    };
    //creating a boolean path that protects the moving object to go on already visited path
    boolean[][] visited = new boolean[grid.length][grid[0].length];
    for (int i = 0; i < grid.length; i++)
        for (int j = 0; j < grid[0].length; j++)
            visited[i][j]= grid[i][j] == ' ';
    //making the starting point already viewed
    visited[0][0]=true;
    //executing the function
    findPath(grid,visited);
}
public static boolean isValidPath(char[][] grid,int x,int y,boolean[][] visited){
    return (x >= 0 && x < grid.length) && (y >= 0 && y < grid[0].length) && !visited[x][y];
}
public static void findPath(char[][]grid, boolean[][] visited) {
    ArrayList<String> path = new ArrayList<>();
    ArrayList<String> letters = new ArrayList<>();
    path.add("@");
    int row=0,column=1;
    while (grid[row][column]!='s')
    {
        //adding the letters to the ArrayList that represents the Letters in the path
        if (Character.isUpperCase(grid[row][column]) && grid[row][column]!='s')
            letters.add(String.valueOf(grid[row][column]));
        //adding all the characters that appear in the path
        path.add(String.valueOf(grid[row][column]));
        //making the position not being able to be visited again
        visited[row][column] = true;
        //find the next step to make
        if (isValidPath(grid,row+1,column,visited)) row++;
        else if (isValidPath(grid,row-1,column,visited)) row--;
        else if (isValidPath(grid,row,column+1,visited)) column++;
        else if (isValidPath(grid,row,column-1,visited)) column--;
    }
    path.add(String.valueOf('s'));
    System.out.println("Path "+path);
    System.out.println("Letters "+letters);
}
