package utils;

public class Utils 
{
    public static boolean LinkageValidityCheck(nodes.Node nodes[], int id1, int id2)
    {
    if(nodes[id1]==null || nodes[id2]==null)
    {
        System.out.println("One of the entered nodes does not exist");
        return false;
    }
    else 
    if(nodes[id1].links.contains(id2))
    {
        System.out.println("Given Nodes are Already Linked");
        return false;
    }
    else 
    if(nodes[id1].getClass()==nodes[id2].getClass())
    {
        System.out.println("Invalid Linkage");
        return false;
    }
    else
    if(nodes[id1].getClass()==nodes.Group.class && nodes[id2].getClass()==nodes.Organisation.class)
    {
        System.out.println("Invalid Linkage");
        return false;
    }
    else
    if(nodes[id1].getClass()==nodes.Organisation.class && nodes[id2].getClass()==nodes.Group.class)
    {
        System.out.println("Invalid Linkage");
        return false;
    }
    else
    if(nodes[id1].getClass()==nodes.Organisation.class && nodes[id2].getClass()==nodes.Business.class)
    {
        System.out.println("Invalid Linkage");
        return false;
    }
    else
    if(nodes[id1].getClass()==nodes.Business.class && nodes[id2].getClass()==nodes.Organisation.class)
    {
        System.out.println("Invalid Linkage");
        return false;
    }
    return true;
    }
    public static void PrintIdAndName(nodes.Node nodes[])
    {
        int i;
        boolean f=false;
        NewLine();
        for(i=0;i<Main.MainMenu.maxsize;i++)
        {
            if(nodes[i]!=null)
            f=true;
        }   
        if(f==false)
        {
            System.out.println("No nodes exist currently");
        }
        else 
        {
            
            System.out.println("Existing Nodes:");
            for(i=0;i<Main.MainMenu.maxsize;i++)
            {
                if(nodes[i]!=null)
                System.out.println("ID: "+nodes[i].getID()+"   Name: "+nodes[i].getName());
            }   
            System.out.println();
        }
    }
    public static void NewLine()
    {
        System.out.println("*-------------------------*");
    }
}
