public class Snake
{
    Snake(Board b, int x, int y, int len, boolean player2)
    {
        if (player2)
        {
            b[x][y] = 3;
            for(int i = 1; i < len; i++)
            {
                b[x][y-i] = 4;
            }
        }
        else
        {
            b[x][y] = 1;
            for(int i = 1; i < len; i++)
            {
                b[x][y-i] = 2;
            }
        }
    }
    
    
}
