package nodes;

import java.util.Scanner;

public class Individual extends Node
{
    String birthday;
    public Individual(Scanner sc, int i)
    {
        super(sc,i);
        System.out.println("Do you want to add Birthday(Yes/No)?");
        String in = sc.nextLine();
        if(in.equalsIgnoreCase("YES"))
        {
            System.out.print("Enter Birthday (YYYY-MM-DD): ");
            this.birthday = sc.nextLine();
        }
        else 
        this.birthday="";
    }
    public String getBirthday(){
        return birthday;
    }
    public void PrintObj()
    {
        super.PrintObj();
        System.out.println("Type : Individual");
        if(!birthday.equals(""))
        {
            System.out.println("Birthday: "+birthday);
        }
        System.out.println();
    }
    public void GetLinks(Node nodes[])
    {
        super.GetLinks(nodes);
    }
}
