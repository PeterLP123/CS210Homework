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
    public boolean [][] visited = new boolean [40][40];
    int currentX = 20;
    int currentY = 20;
    Stack<String> path = new Stack<String>();
    public String getMove(boolean north, boolean south, boolean east, boolean west){
        visited[currentX][currentY] = true;
        if(north && !visited[currentX][currentY+1]){
            path.push("south");
            currentY++;
            return "north";
        }
        else if(south && !visited[currentX][currentY-1]){
            path.push("north");
            currentY--;
            return "south";
        }
        else if(east && !visited[currentX+1][currentY]){
            path.push("west");
            currentX++;
            return "east";
        }
        else if(west && !visited[currentX-1][currentY]){
            path.push("east");
            currentX--;
            return "west";
        }
        else{
            String back = path.pop();
            switch(back){
                case "north":
                    currentY++;
                    break;
                case "south":
                    currentY--;
                    break;
                case "east":
                    currentX++;
                    break;
                case "west":
                    currentX--;
                    break;
            }
            return back;
        }
    }
}