package nodes;

import java.util.Scanner;
import java.util.ArrayList;

public class Business extends Node
{
    String xcord;
    String ycord;
    public ArrayList<Integer>Owners = new ArrayList<>();
    public ArrayList<Integer>Customers = new ArrayList<>();
    public Business(Scanner sc, int i)
    {
        super(sc,i);
        System.out.print("Enter x Coordinate: ");
        this.xcord = sc.nextLine();
        System.out.print("Enter y Coordinate: ");
        this.ycord = sc.nextLine();
    }
    public String getXcord(){
        return xcord;
    }
    public String getYcord(){
        return ycord;
    }
    public void PrintObj()
    {
        super.PrintObj();
        System.out.println("Type : Business");
        System.out.println("Coordinates: "+xcord+","+ycord);
        System.out.println();
    }
    public void GetLinks(Node nodes[])
    {
        if(this.links.isEmpty())
            System.out.println("Node is not linked to anything");
        else 
        {
            utils.Utils.NewLine();
            System.out.println("Node is linked to:\n");
            for(int j=0; j<this.links.size(); j++)
            {
                System.out.println("Linked Node #"+(j+1));
                int ind = this.links.get(j);
                System.out.print("Relation with Business: ");
                if(Owners.contains(ind))
                    System.out.println("Owner");
                else 
                if(Customers.contains(ind))
                    System.out.println("Customer");
                else 
                    System.out.println("Group");
                nodes[ind].PrintObj();
            }
        }
    }
} 