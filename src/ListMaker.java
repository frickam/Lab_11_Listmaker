import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker
{
    static ArrayList<String> list = new ArrayList<>();
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        final String menu = "A - Add  D - Delete  P - Print  Q - Quit";
        boolean done = false;
        String cmd = "";
        String item = "";
        int delete = 0;

        do
        {
            displayList();

            cmd = SafeInput.getRegExString(in, menu, "[AaDdPpQq]");
            cmd = cmd.toUpperCase();
            switch(cmd)
            {
                case "A":
                    item = SafeInput.getNonZeroLenString(in, "What is the item you would like to add to the list: ");
                    System.out.println("" + item + " has been added to the list");
                    list.add(item);
                    break;
                case "D":
                    delete = SafeInput.getInt(in, "What is the number of the item you would like to delete: ");
                    delete = delete - 1;
                    list.remove(delete);
                    System.out.println("Item number " + delete + " has been removed from the list");
                    break;
                case "P":
                    break;
                case "Q":
                    System.exit(0);
                    break;
            }
            System.out.println("cmd is " + cmd);
        }
        while(!done);
    }

    private static void displayList()
    {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        if (list.size() != 0)
        {
            for (int i = 0; i < list.size(); i++)
            {
                System.out.printf("%3d%35s", i+1, list.get(i));
                System.out.println();
            }
        }
        else
            System.out.println("+++             List is empty        +++");
        System.out.println();
        System.out.println("++++++++++++++++++++++++++++++++++++++");
    }
}
