/**
 * Write a description of class asdf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    String[][] Board;

    public Board(int side)
    {
        Board = new String[side][side];
        for (int i = 0; i < side; i++)
        {
            for (int j = 0; j < side; j++)
            {
                Board[i][j] = "back";
            }
        }
    }
    
    public String toString()
    {
        String str = "";
        int count1 = 0;
        int count2 = 0;
        for (String[] arr : Board)
        {
            for (String s : arr)
            {
                str += "(" + count1 + ", " + count2 + ")" + s + ", ";
                count2 ++;
            }
            count1 ++;
            count2 = 0;
            str += "\n";
        }
        return str;
    }
    
    public void set(int x, int y, String val)
    {
        Board[x][y] = val;
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
