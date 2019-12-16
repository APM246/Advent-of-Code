import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Day2
{
    public static int run_intcode(int noun, int verb)
    {
        String text = null;

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader("../../input files/Day2.txt"));
            text = reader.readLine();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        String[] intcode = text.split(",");

        intcode[1] = Integer.toString(noun);
        intcode[2] = Integer.toString(verb);

        int length = intcode.length;
        int i = 0;

        while (i < length)
        {
            int operation = Integer.parseInt(intcode[i]);
            int input_position1 = Integer.parseInt(intcode[i+1]);
            int input_position2 = Integer.parseInt(intcode[i+2]);
            int output_position = Integer.parseInt(intcode[i+3]);

            if (operation == 1)
            {
                intcode[output_position] = Integer.toString(Integer.parseInt(intcode[input_position1]) + Integer.parseInt(intcode[input_position2]));
            }

            else if (operation == 2)
            {
                intcode[output_position] = Integer.toString(Integer.parseInt(intcode[input_position1])*Integer.parseInt(intcode[input_position2]));
            }

            else 
            {
                break;
            }

            i += 4;
        }

        return Integer.parseInt(intcode[0]);
    }

    public static void main(String[] args) 
    {
        int max_value = 99;
        for (int i = 0; i <= max_value; i++)
        {
            for (int j = 0; j <= max_value; j++)
            {
                if (run_intcode(i, j) == 19690720)
                {
                    System.out.println(100*i + j);
                    System.exit(0);
                }
            }
        }
        
    }
}