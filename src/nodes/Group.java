package nodes;

import java.util.Scanner;

public class Group extends Node
{
    public Group(Scanner sc, int i)
    {
        super(sc,i);
    }
    public void PrintObj()
    {
        super.PrintObj();
        System.out.println("Type : Group");
        System.out.println();
    }
    public void GetLinks(Node nodes[])
    {
        super.GetLinks(nodes);
    }
} 