package landunant;

public class LanDunAnt {
	public static void main(String args[]) throws InterruptedException{
		boolean[][] map = new boolean[100][100];
		for(int x=0;x<100;x++){
			for(int y=0;y<100;y++){
				map[x][y] = false;
			}
		}
		
		Ant ant = new Ant(map,100,100);
		ant.run();
		//Thread.sleep(10);
				
	}
}

class Ant{
	boolean[][] map;
	int row;
	int col;
	int antX;
	int antY;
	int directState;
	String[] direction = {"up","right","down","left"};
	String antDirection = direction[directState];
	Ant(boolean[][] map, int row , int col){
		this.map = map;
		this.row = row;
		this.col = col;
		antX = 50;
		antY = 60;
		directState = 0;
		
	}
	
	
	public void run() {
		while ((antX >0 && antX < row) && (antY>0 && antY < col)){
			move();
			printMap();
		}
		printMap();
		
	}
	public void move(){
		if((antX >0 && antX < row-1) && (antY>0 && antY < col-1)){
			if (antDirection == "up"){
				
				antX -= 1;
				if(map[antX][antY]){
					directState = ((directState+1)%4);
					
				}
				else
				{
					directState = (directState-1)%4;
					
				}
				map[antX][antY] = !map[antX][antY];
			}
			else if (antDirection == "right"){
				antY += 1;
				if(map[antX][antY]){
					directState = (directState+1)%4;
					
				}
				else
				{
					directState = (directState-1)%4;
					
				}
				map[antX][antY] = !map[antX][antY];
			}
			else if (antDirection == "down"){
				antX += 1;
				if(map[antX][antY]){
					directState = (directState+1)%4;
				}
				else
				{
					directState = (directState-1)%4;
				}
				map[antX][antY] = !map[antX][antY];
			}
			else if (antDirection == "left"){
				antY -= 1;
				if(map[antX][antY]){
					directState = (directState+1)%4;
				}
				else
				{
					directState = (directState-1)%4;
				}
				map[antX][antY] = !map[antX][antY];
			}
		}
		if(directState < 0)
			directState += 4;
		antDirection = direction[directState];
	}
	
	public void printMap(){
		for(int x=0;x<row;x++)
		{
			for(int y=0;y<col;y++){
				if(map[x][y]){
					System.out.print("#");
				}
				else
					System.out.print("+");
			}
			System.out.println();
		}
	}
}