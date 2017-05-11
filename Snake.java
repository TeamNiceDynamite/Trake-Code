public class Snake
{
    String direction;
    int length = 4;
    Board board;
    int player;

    Snake(int x, int y, int len, boolean player2)
    {
        if (player2)
        {
            board.set(5,y/2,"head");
            board.set(4,y/2,"body");
            board.set(3,y/2,"body");
            board.set(2,y/2,"tail");
            direction = "right";
            player = 2;
        }
        else
        {
            board.set(x-5,y/2,"head");
            board.set(x-4,y/2,"body");
            board.set(x-3,y/2,"body");
            board.set(x-2,y/2,"tail");
            direction = "left";
            player = 1;
        }
    }

    // pass in the current head position
    public boolean checkMove(int x, int y)
    {
        switch(direction)
        {
            case "down":
            if ((board.getVal(x, y-1)).equals("body"))
            {
                return false;
            }
            return true;
            case "up":
            if ((board.getVal(x, y+1)).equals("body"))
            {
                return false;
            }
            return true;
            case "left":
            if ((board.getVal(x-1, y)).equals("body"))
            {
                return false;
            }
            return true;
            case "right":
            if ((board.getVal(x+1, y)).equals("body"))
            {
                return false;
            }
            return true;
        }
        return true;
    }

    // actually move the snake head, remove tail
    public void move()
    {
        // move head if allowed
        int x, y;
        int[] head = board.getPos("head");
        x = head[0];
        y = head[1];
        boolean legal = this.checkMove(x, y);
        if (legal)
        {
            switch(direction)
            {
                case "down":
                board.getVal(x, y);
                board.set(x, y, "body");
                board.set(x, y-1, "down head");
                break;
                case "up":
                board.set(x, y, "body");
                board.set(x, y-1, "up head");
                break;
                case "right":
                board.set(x, y, "body");
                board.set(x+1, y, "right head");
                break;
                case "left":
                board.set(x, y, "body");
                board.set(x-1, y, "left head");
                break;
            }
        }
        else
        {
            this.lose();
        }
        
        //remove tail
        
    }

    public void lose()
    {
    }
}
