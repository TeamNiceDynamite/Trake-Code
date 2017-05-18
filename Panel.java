import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JPanel;

/**
 * Write a description of class Panel here.
 * 
 * @author (Haley Guastaferro) 
 * @version (5/14/2017)
 */
public class Panel extends JPanel
{

	/*
	 *Will override the automatic paint component and replace with visual snake game. 
	 */
	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Snake1 snake = Snake1.snake;
        //background color
		g.setColor(Color.BLACK);//sets background color
		g.fillRect(0, 0, 800, 700);//fills the rectangle with black
        
		//sets snake color to green
		g.setColor(Color.GREEN);//snake color
		for (Point point : snake.snakeParts)//fills the board with green where the snake is
		{
			g.fillRect(point.x * Snake1.SCALE, point.y * Snake1.SCALE, Snake1.SCALE, Snake1.SCALE);
		}
		
		g.fillRect(snake.head.x * Snake1.SCALE, snake.head.y * Snake1.SCALE, Snake1.SCALE, Snake1.SCALE);
		
		//creates a cherry red and fills it
		g.setColor(Color.RED);
		g.fillRect(snake.cherry.x * Snake1.SCALE, snake.cherry.y * Snake1.SCALE, Snake1.SCALE, Snake1.SCALE);
		
		//creates a magenta food to make snake longer 
		g.setColor(Color.magenta);
		g.fillRect(snake.longer.x * Snake1.SCALE, snake.longer.y * Snake1.SCALE, Snake1.SCALE, Snake1.SCALE);
		
		//creates a yellow food to make snake shorter
		g.setColor(Color.YELLOW);
		g.fillRect(snake.shorter.x * Snake1.SCALE, snake.shorter.y * Snake1.SCALE, Snake1.SCALE, Snake1.SCALE);
		
		g.setColor(Color.BLUE);
		g.fillRect(snake.faster.x * Snake1.SCALE, snake.faster.y * Snake1.SCALE, Snake1.SCALE, Snake1.SCALE);
		
		g.setColor(Color.WHITE);
		g.fillRect(snake.reverse.x * Snake1.SCALE, snake.reverse.y * Snake1.SCALE, Snake1.SCALE, Snake1.SCALE);
		
		//score board display makes it white and in the middle
		String string = "Score: " + snake.score + ", Length: " + snake.tailLength + ", Time: " + snake.time / 20;
		g.setColor(Color.white);
		g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), 10);

		//game over
		string = "Game Over!";
		if (snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}

		//paused
		string = "Paused!";
		if (snake.paused && !snake.over)
		{
			g.drawString(string, (int) (getWidth() / 2 - string.length() * 2.5f), (int) snake.dim.getHeight() / 4);
		}
	}
}
