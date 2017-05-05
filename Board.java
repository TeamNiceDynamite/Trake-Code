public class Board2
{
    Position[] Board;

    //square constructor
    Board2(int side)
    {
        Board = new Position[side*side];
        int count = 0;
        for (int i = 0; i < side; i++)
        {
            for (int j = 0; j < side; j++)
            {
                Board[count] = new Position(i, j);
                count++;
            }
        }
    }
    
    public String toString()
    {
        String str = "";
        for(Position p : Board)
        {
            str += p + ", ";
        }
        return str;
    }

    public static void main(String args[])
    {
        Board2 b1 = new Board2(2);
        Board2 b2 = new Board2(3);
        Board2 b3 = new Board2(4);
        Board2 b4 = new Board2(5);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
