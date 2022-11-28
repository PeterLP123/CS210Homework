import java.util.*;
public class Labyrinth{
    public static void main(String[] args){
        int lives = 200;
        Scanner myScanner = new Scanner(System.in);
        String[] input = new String[20];
        for(int i=0;i<20;i++){
            input[i]=myScanner.nextLine();
        }
        int posX=Integer.parseInt(myScanner.nextLine());
        int posY=Integer.parseInt(myScanner.nextLine());
        myScanner.close();
        boolean[][] maze = new boolean[20][20];
        for(int i=0;i<20;i++){
            for(int j=0;j<20;j++){
                if(input[i].charAt(j)=='X'){
                    maze[i][j]=false;
                }else{
                    maze[i][j]=true;
                }
            }
        }
        Brain myBrain = new Brain();
        while(lives>0){
            String move =myBrain.getMove(maze[posX-1][posY],maze[posX+1][posY],maze[posX][posY+1],maze[posX][posY-1]);
            if(move.equals("north")&&maze[posX-1][posY]){
                posX--;
            }else if(move.equals("south")&&maze[posX+1][posY]){
                posX++;
            }else if(move.equals("east")&&maze[posX][posY+1]){
                posY++;
            }else if(move.equals("west")&&maze[posX][posY-1]){
                posY--;
            }
            lives--;
            if(posY%19==0||posX%19==0){
                //System.out.println(lives);
                System.out.println(posX+","+posY);
                System.exit(0);
            }
        }
        System.out.println("You died in the maze!");
    }
}

class Brain{
    public int [][] map = new int [40][40];
    int x = 20;
    int y = 20;
    Stack<String> path = new Stack<String>();
    Brain(){
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){
                map[i][j] = 0;
            }
        }
    }
    public String getMove(boolean north, boolean south, boolean east, boolean west){
        map[x][y] = 1;
        //System.out.println(x + "," + y);
        if(north && map[x][y+1] == 0){
            path.push("south");
            y++;
            return "north";
        }
        else if(south && map[x][y-1] == 0){
            path.push("north");
            y--;
            return "south";
        }
        else if(east && map[x+1][y] == 0){
            path.push("west");
            x++;
            return "east";
        }
        else if(west && map[x-1][y] == 0){
            path.push("east");
            x--;
            return "west";
        }
        else{
            String back = path.pop();
            if(back.equals("north")){
                y++;
            }
            else if(back.equals("south")){
                y--;
            }
            else if(back.equals("east")){
                x++;
            }
            else if(back.equals("west")){
                x--;
            }
            return back;
        }
    }
}