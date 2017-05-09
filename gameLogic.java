public class gameLogic extends Thread
{
	Snake snakeHeadPos;
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
private void spawnFood
