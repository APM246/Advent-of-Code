import java.io.*;
import java.lang.Math;

public class Part2
{
    public static void main(String[] args)
    {
        BufferedReader in;
        try
        {
            in = new BufferedReader(new FileReader("../input files/input.txt"));
            String line = null;
            line = in.readLine();
            int result = 0;
            while (line != null)
            {
                int mass = Integer.parseInt(line);
                int initial = (int) Math.floor(mass / 3) - 2;

                while (initial > 0)
                {
                    result += initial;
                    initial = (int) Math.floor(initial / 3) - 2;
                }

                line = in.readLine();
            }

            System.out.println(result);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

    }
}
