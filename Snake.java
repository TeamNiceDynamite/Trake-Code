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
            board.set(5,y/2,"head right");
            board.set(4,y/2,"body right");
            board.set(3,y/2,"body right");
            board.set(2,y/2,"tail right");
            direction = "right";
            player = 2;
        }
        else
        {
            board.set(x-5,y/2,"head left");
            board.set(x-4,y/2,"body left");
            board.set(x-3,y/2,"body left");
            board.set(x-2,y/2,"tail left");
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

    // actually move the snake head
    public void moveHead(int x, int y)
    {
        // move head if allowed
        boolean legal = this.checkMove(x, y);
        if (legal)
        {
            String headDir = board.getVal(x, y).substring(5);
            switch(direction)
            {
                case "down":
                board.set(x, y-1, "head down");
                break;
                case "up":
                board.set(x, y+1, "head up");
                break;
                case "right":
                board.set(x+1, y, "head right");
                break;
                case "left":
                board.set(x-1, y, "head left");
                break;
                default:
                break;
            }
            board.set(x, y, "body " + headDir);
        }
        else
        {
            this.lose();
        }
    }

    public void removeTail()
    {
        //remove tail
        int[] tail = board.getPos("tail");
        int x = tail[0];
        int y = tail[1];
        String tailDir = board.getVal(x,y).substring(5);
        String newTailDir;
        switch (tailDir)
        {
            case "down":
            newTailDir = board.getVal(x,y-1).substring(5);
            board.set(x,y-1, "tail " + newTailDir);
            break;
            case "up":
            newTailDir = board.getVal(x,y+1).substring(5);
            board.set(x,y+1, "tail " + newTailDir);
            break;
            case "left":
            newTailDir = board.getVal(x-1,y).substring(5);
            board.set(x-1,y, "tail " + newTailDir);
            break;
            case "right":
            newTailDir = board.getVal(x+1,y).substring(5);
            board.set(x+1,y, "tail " + newTailDir);
            break;
            default:
            break;
        }
        board.set(x,y,"bg");
    }

    public void grow(int size)
    {
        length += size;
    }

    public void move()
    {
        int[] head = board.getPos("head");
        int x = head[0];
        int y = head[1];
        boolean good = checkMove(x, y);
        if (!good)
        {
            this.lose();
        }
        moveHead(x, y);
        int bodyLen = 0;
        for (int i = 0; i < board.getX(); i++)
        {
            for (int j = 0; j < board.getY(); j++)
            {
                if (board.getVal(i, j).substring(0,3).equals("body"))
                {
                    bodyLen++;
                }
            }
        }
        
        if (bodyLen + 2 == length)
        {
            removeTail();
        }
    }

    public void lose()
    {
    }
}
