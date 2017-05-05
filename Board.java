public class Board
{
    Position[] Board;

    //square constructor
    Board(int side)
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
        Board b1 = new Board(2);
        Board b2 = new Board(3);
        Board b3 = new Board(4);
        Board b4 = new Board(5);
        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }
}
