public class Snake
{
    String direction;
    int length = 4;
    Board board;
    int size;

    Snake(int x, int y, int len, boolean player2)
    {
        if (player2)
        {
            board.set(5,y/2,"head");
            board.set(4,y/2,"body");
            board.set(3,y/2,"body");
            board.set(2,y/2,"tail");
            direction = "right";
        }
        else
        {
            board.set(x-5,y/2,"head");
            board.set(x-4,y/2,"body");
            board.set(x-3,y/2,"body");
            board.set(x-2,y/2,"tail");
            direction = "left";
        }
    }

    // pass in the current head position
    public boolean checkMove(int x, int y)
    {
        switch(direction)
        {
            case "down":
            if ((board.get(x, y-1)).equals("body"))
            {
                return false;
            }
            return true;
            break;
            case "up":
            if ((board.get(x, y+1)).equals("body"))
            {
                return false;
            }
            return true;
            break;
            case "left":
            if ((board.get(x-1, y)).equals("body"))
            {
                return false;
            }
            return true;
            break;
            case "right":
            if ((board.get(x+1, y)).equals("body"))
            {
                return false;
            }
            return true;
            break;
        }
    }

    // actually move the snake head, remove tail
    public void move(int x, int y)
    {
        // move head if allowed
        boolean legal = this.checkMove(x, y);
        if (legal)
        {
            switch(direction)
            {
                case "down":
                board.set(x, y, "body");
                board.set(x, y-1, "head");
                break;
                case "up":
                board.set(x, y, "body");
                board.set(x, y-1, "head");
                break;
                case "right":
                board.set(x, y, "body");
                board.set(x+1, y, "head");
                break;
                case "left":
                board.set(x, y, "body");
                board.set(x-1, y, "head");
                break;
            }
        }
        else
        {
            this.lose();
        }
        //remove tail
        for (int x = 0; x < size; x++)
        {
            for (int p: arr)
            {
                if (
            }
        }
    }

    public void lose()
    {

    }
}
