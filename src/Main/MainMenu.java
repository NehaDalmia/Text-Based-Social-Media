package Main;
import java.util.*;
public class MainMenu
{
    public static int maxsize = 200;
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int i=0;
        nodes.Node nodes[] = new nodes.Node[maxsize];
        while(true) 
        {
            int ch;
            utils.Utils.PrintIdAndName(nodes);
            System.out.println("Choose number beside the operation you want to perform \n 1 - Create Node \n 2 - Delete Node \n 3 - Add Link between Two Nodes\n 4 - Print Nodes Linked to a Given Node\n 5 - Create and Post Content by a Node\n 6 - Search for Content Posted by a Given Node\n 7 - Display Contents Posted by Nodes Linked to a Given Node \n 8 - Find Node by Providing Data \n 9 - Print all Nodes \n 10 - Exit");
            utils.Utils.NewLine();
            ch=sc.nextInt();
            sc.nextLine();
            switch(ch)
            {
                case 1:
                    nodes[i] = Menu.CreateNode(sc, i);
                    if(nodes[i]==null)
                        System.out.println("Enter valid type");
                    else
                    {
                        System.out.println("Details of Created Node:");
                        nodes[i].PrintObj();
                        i++;
                    }
                    break;
                case 2:
                    Menu.DeleteNode(nodes, sc);
                    break;                
                case 3:
                    Menu.AddLink(nodes, sc);
                    break;
                case 4:
                    Menu.GetLinks(nodes, sc);
                    break;
                case 5:
                    Menu.AddContent(nodes, sc); 
                    break;              
                case 6:
                    System.out.println("Enter id of Node whose content you want to display");
                    int id = sc.nextInt();
                    sc.nextLine();
                    Menu.PrintContent(nodes, sc, id);
                    break;
                case 7:
                    Menu.PrintLinkedContent(nodes, sc);
                    break;
                case 8:
                    Menu.FindNode(nodes, sc);
                    break;
                case 9:
                    Menu.PrintAll(nodes);
                    break;
                case 10:
                    System.out.println("Exiting");
                    System.exit(0);
                    System.exit(0);
                    break;
                default: System.out.println("Select a Valid Option");
            }
            
        }
    }
    
}

