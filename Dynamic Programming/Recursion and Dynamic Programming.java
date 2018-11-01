Recursion: 
Design an algorithm to compute the nth; 
Write code to list the first n ..;
Implement a method to compute all...;

Bottom-Up approach: 
Top-Down approach:
Half-And-Half approach:

int fibonacci(int i){
	if(n == 0) return 0;
	if(i == 1) return 1;
	return fibonacci(i - 1) + fibonacci(i - 2);
}

int fibonacci(int n){
	if(n == 0) return 0;
	else if(n == 1) return 1;

	int[] memo = new int[n];
	memo[0] = 0;
	memo[1] = 1;
	for(int i = 2; i < n; i++){
		memo[i] = memo[i - 1] + memo[i - 2];
	}

	return memo[n - 1] + memo[n - 2];
}

int fibonacci(int n ){
	if(n == 0) return 0;
	int a = 0 ;
	int b = 1;
	for(int i = 2; i < n; i++){
		int c = a + b;
		a = b;
		b = c;
	}
	return a + b;
}


Triple Step: 

int countWays(int n){
	int[] memo = new int[n + 1];
	Arrays.fill(memo,-1);
	return countWays(n,memo);
}
int countWays(int n, int[] memo){
	if(n < 0){
		return 0;

	}else if(n == 0){
		return 1;
	}else if(memo[n] > -1){
		return memo[n];
	}else{
		memo[n] = countWays(n - 1,memo) + countWays(n - 2,memo) + countWays(n - 3,memo);
		return memo[n];
	}
}

//my solution :  not sure if it's right; 
int countways(int n ){
	int[] memo = new int[n + 1];
	memo[1] = 1;
	memo[2] = 2;
	memo[3] = 4;

	for(int i = 4; i <= n; i++){
		memo[i] = memo[i - 1] + memo[i - 2] + memo[i -3];
	}

	return memo[n];
}

8.2 Robot in a Grid: imagine a robot sitting on the upper left corner of grid with 
r rows and c columns. The robot can only move in two directions, right and down; 
but certain cells are " off limits" such that the robot can not step on them. 
Design an algorithm to find a path for the robot from the top left to the bottom right. 

ArrayList<Point> getPath(boolean[][] maze){
	if(maze == null || maze.length == 0){
		return null;
	}

	ArrayList<Point> path = new ArrayList<Point>();
	HashMap<Point,Boolean> cache = new HashMap<Point, Boolean>();
	int lastRow = maze.length - 1;
	int lastCol = maze[0].length - 1;
	if(getPath(maze,lastRow,lastCol,path,cache)){
		return path;
	}
	return null;
}

boolean getPath(boolean[][] mazem, int row, int col, ArrayList<Point> path, HashMap<Point,Boolean> cache){
	if(col < 0 || row < 0 || !maze[row][col]){
		return false;
	}
	Point p = new Point(row,col);

	if(cache.containsKey(p)){
		return cache.get(p);
	}
	boolean isAtOrigin = (row == 0) && (col == 0);
	boolean success = false;
	if(isAtOrigin || getPath(maze, row, col - 1, path, cache) ||
		getPath(maze, row - 1, col, path, cache)){
		path.add(p);
		success = true;
	}
	cache.put(p,success);
	return success;
}




