package nodes;

import java.util.Scanner;

public class Organisation extends Node
{
    String xcord;
    String ycord;
    public Organisation(Scanner sc, int i)
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
        System.out.println("Type : Organisation");
        System.out.println("Coordinates: "+xcord+","+ycord);
        System.out.println();
    }
    public void GetLinks(Node nodes[])
    {
        super.GetLinks(nodes);
    }
} 