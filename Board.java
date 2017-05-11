/**
 * Write a description of class asdf here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Board
{
    // store strings as type, direction
    String[][] board;
    int x, y;

    public Board(int side)
    {
        board = new String[side][side];
        for (int i = 0; i < side; i++)
        {
            for (int j = 0; j < side; j++)
            {
                if (i == 0 || i == side-1 || j == side-1 || j == 0)
                {
                    board[i][j] = "side";
                }
                else
                {
                    board[i][j] = "bg";
                }
            }
        }
        x = side;
        y = side;
    }

    public String toString()
    {
        String str = "";
        int count1 = 0;
        int count2 = 0;
        for (String[] arr : board)
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
        board[x][y] = val;
    }

    // sets variables x and y to current position of str
    public int[] getPos(String str)
    {
        int[] arr = new int[2];
        for (int i = 0; i < x; i++)
        {
            for (int j = 0; j < y; j++)
            {
                if (board[i][j].equals(str))
                {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }

    public String getVal(int x, int y)
    {
        return board[x][y];
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
