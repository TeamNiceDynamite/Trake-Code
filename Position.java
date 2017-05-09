public class Position
{
    private final int myX;
    private final int myY;
    
    Position(int x, int y)
    {
        myX = x;
        myY = y;
    }
    
    public int getX()
    {
        return myX;
    }
    
    public int getY()
    {
        return myY;
    }
    
    public void changePos(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    
    public String toString()
    {
        String str = "";
        return "(" + myX + ", " + myY + ")";
    }
}
