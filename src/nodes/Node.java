package nodes;

import java.time.LocalDate;
import java.util.Scanner;

//import jdk.jshell.execution.Util;

import java.util.ArrayList;

public class Node 
{
    int id;
    String name;
    LocalDate date;
    public ArrayList<String> content = new ArrayList<>();
    public ArrayList<Integer> links = new ArrayList<>();
    public Node(Scanner myObj, int i) 
    {
        System.out.print("Enter the name: ");
        this.name=myObj.nextLine();
        LocalDate today = LocalDate.now();
        this.date = today;
        this.id = i;
        
    }
    public String getName()
    {
        return name;
    }
    public int getID()
    {
        return id;
    }
    public void PrintObj() 
    {
        System.out.println("Id: "+id);
        System.out.println("Name: "+name);
        System.out.println("Date of Creation: "+date);
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
                nodes[ind].PrintObj();
            }
        }
    }
    
}