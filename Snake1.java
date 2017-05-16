import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;


/**
 * Write a description of class Snake1 here.
 * 
 * @author (Haley Guastaferro) 
 * @version (5/14/2017)
 */
public class Snake1 implements ActionListener, KeyListener
{
    public static Snake1 snake;

    public JFrame jframe;

    public Panel panel;
    public int speed = 40;
    public Timer timer = new Timer(speed, this);

    public ArrayList<Point> snakeParts = new ArrayList<Point>();

    public static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3, SCALE = 10;

    public int ticks = 0, direction = DOWN, score, tailLength = 10, time;

    public Point head, cherry, longer, shorter, faster;

    public Random random;

    public boolean over = false, paused;

    public Dimension dim;

    /* This method creates the JFrame puts panel into it.
     * 
     */
    public Snake1()
    {
        dim = Toolkit.getDefaultToolkit().getScreenSize();
        jframe = new JFrame("Snake");
        jframe.setVisible(true);
        jframe.setSize(805, 700);
        jframe.setResizable(false);
        jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
        jframe.add(panel = new Panel());
        jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jframe.addKeyListener(this);
        startGame();
    }

    /*This method creates a fresh new game by seting everything to the starting values.
     * 
     */
    public void startGame()
    {
        over = false;
        paused = false;
        time = 0;
        score = 0;
        tailLength = 14;
        ticks = 0;
        direction = DOWN;
        head = new Point(0, -1);
        random = new Random();
        snakeParts.clear();
        cherry = new Point(random.nextInt(79), random.nextInt(66));
        longer = new Point(random.nextInt(79), random.nextInt(66));
        shorter = new Point(random.nextInt(79), random.nextInt(66));
        faster = new Point(random.nextInt(79), random.nextInt(66));
        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent arg0)
    {
        panel.repaint();
        ticks++;

        if (ticks % 2 == 0 && head != null && !over && !paused)
        {
            time++;

            snakeParts.add(new Point(head.x, head.y));

            if (direction == UP)
            {
                if (head.y - 1 >= 0 && noTailAt(head.x, head.y - 1))
                {
                    head = new Point(head.x, head.y - 1);
                }
                else
                {
                    over = true;

                }
            }

            if (direction == DOWN)
            {
                if (head.y + 1 < 67 && noTailAt(head.x, head.y + 1))
                {
                    head = new Point(head.x, head.y + 1);
                }
                else
                {
                    over = true;
                }
            }

            if (direction == LEFT)
            {
                if (head.x - 1 >= 0 && noTailAt(head.x - 1, head.y))
                {
                    head = new Point(head.x - 1, head.y);
                }
                else
                {
                    over = true;
                }
            }

            if (direction == RIGHT)
            {
                if (head.x + 1 < 80 && noTailAt(head.x + 1, head.y))
                {
                    head = new Point(head.x + 1, head.y);
                }
                else
                {
                    over = true;
                }
            }

            while (snakeParts.size() > tailLength)
            {
                snakeParts.remove(0);

            }

            if (cherry != null)
            {
                if (head.equals(cherry))
                {
                    speed += 2;
                    score += 10;
                    tailLength+=2;
                    timer.stop();
                    timer.setDelay(speed);
                    timer.start();
                    cherry.setLocation(random.nextInt(79), random.nextInt(66));
                }
            }
            
            if (longer != null && head.equals(longer))
            {
                if((speed += 10) > (speed *= 1.5))
                {
                    speed += 10;
                }
                else
                {
                    speed *= 1.5;
                }
                tailLength *= 2;
                if(tailLength == 0)
                {
                    tailLength = 1;
                }
                 timer.stop();
                 timer.setDelay(speed);
                 timer.start();
                longer.setLocation(random.nextInt(79), random.nextInt(66));
            }

            if (shorter != null && head.equals(shorter))
            {
              tailLength /=2;
              shorter.setLocation(random.nextInt(79), random.nextInt(66));
            }
            
            if (faster != null && head.equals(faster))
            {
               
               if(speed >=40)
               {
                   speed -= 10;
               }
               else if(speed >= 20)
               {
                   speed -= 5;
               }
               else if (speed >= 8)
               {
                    speed -= 2;
               }
               else if (speed <= 4)
               {
                   speed = 4;;
               }

            
                
               timer.stop();
               timer.setDelay(speed);
               timer.start();
                
               faster.setLocation(random.nextInt(79),random.nextInt(66));
            }
            

        }
    }

    /*This method checks to see if the snake ran into itself, if it did than boolean = false
     * 
     */
    public boolean noTailAt(int x, int y)
    {
        for (Point point : snakeParts)
        {
            if (point.equals(new Point(x, y)))
            {
                return false;
            }
        }
        return true;
    }

   

    /*
     * Takes in the key event and precesses it as a direction.
     */
    @Override
    public void keyPressed(KeyEvent e)
    {
        int i = e.getKeyCode();

        if ((i == KeyEvent.VK_A || i == KeyEvent.VK_LEFT) && direction != RIGHT)
        {
            direction = LEFT;
        }

        if ((i == KeyEvent.VK_D || i == KeyEvent.VK_RIGHT) && direction != LEFT)
        {
            direction = RIGHT;
        }

        if ((i == KeyEvent.VK_W || i == KeyEvent.VK_UP) && direction != DOWN)
        {
            direction = UP;
        }

        if ((i == KeyEvent.VK_S || i == KeyEvent.VK_DOWN) && direction != UP)
        {
            direction = DOWN;
        }

        if (i == KeyEvent.VK_SPACE)
        {
            if (over)
            {
                startGame();
            }
            else
            {
                paused = !paused;
            }
        }
    }

    /*
     * empty methods to override
     */ 
    @Override
    public void keyReleased(KeyEvent e)
    {
    }

    /*
     *empty method to override 
     */
    @Override
    public void keyTyped(KeyEvent e)
    {
    }
    
    public static void main(String[] args)
    {
        snake = new Snake1();
        
    }
    
}
