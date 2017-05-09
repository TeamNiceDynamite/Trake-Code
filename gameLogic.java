public class gameLogic extends Thread
{
	Position snakeHeadPos;
	int snakeSize =;
	long speed =;
	public static int snakeDirection;
	ArrayList<Objects> positions = new ArrayList<Objects>();
	Objects foodPosition;

	gameLogic(Objects initialPosition)
	{

	}
	public void run()
	{
		while(true)
		{
			moveInitiate(snakeDirection);
			checkCollision();
			moveFinish();
			deleteTail();
			pause();
		}
	}

	Private void pause()
	{
		Try{
			
	}
	private void checkCollision() 
	{
		Position positionToCheck = positions.get(positions.size() - 1);
		for(int i = 0; i<=positions.size() - 2; i++)
		{
			Boolean biteSnake = positionToCheck.getX() == positions.get(i).getX() &&
			positionToCheck.getY() == positions.get(i).getY();
			if(biteSnake)
			{
				//code to stop the game;
			}
		}
		
		boolean eatingFood = positionToCheck.getX() == foodPosition.getX() &&
		positionToCheck.getY() == foodPosition.getY();
		If (eatingFood)
		{
			snakeSize += 1;
			foodPosition = //get a random location not occupied;
			spawnFood (foodPosition);
		}
	}
	private void moveInitiate(int dir)
	{
		switch(dir){
			case 0:
				headSnakePos.changePos(Math.abs(headSnakePos.x+1)%20,headSnakePos.y);
				positions.add(new Tuple(headSnakePos.x,headSnakePos.y));
				break;
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			default:
				break;
		}
	}
}
private void spawnFood
