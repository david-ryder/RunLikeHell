// David Winfield
// COP 3503C - Fall 2021
// PID: da789299
// UCFID: 4707545

public class RunLikeHell
{
    public static final int VISITED = 1;

    public static double hoursSpent()
    {
        return 3.0;
    }

    public static double difficultyRating()
    {
        return 2.0;
    }

    public static int maxGain(int[] blocks)
    {
        int[] status = new int[blocks.length];

        int total = 0;

        for (int i = 0; i < blocks.length; i++)
        {
            // Ensure that we don't jump to invalid index
            if (i == blocks.length - 1)
            {
                status[i] = VISITED;
                total += blocks[i];
                break;
            }

            // Safe to select this block
            if (blocks[i] > blocks[i + 1])
            {
                status[i] = VISITED;
                total += blocks[i];
                i++;
                continue;
            }
        }

        for (int i = 0; i < blocks.length; i++)
        {
            // Block i is visited - jump to next possible block
            if (status[i] == VISITED)
            {
                i++;
                continue;
            }
                
            // i is unvisited

            // Check that i + 1 is also unvisited - if so, it's free
            if (status[i + 1] != VISITED)
            {
                total += blocks[i];
                i++;
                continue;
            }

            i += 2;
        }

        return total;
    }
}