package Main;

import static Main.MainMenu.maxsize;
import java.util.Scanner;

public class Menu {
    public static nodes.Node CreateNode(Scanner sc, int i)
    {
        System.out.print("Enter the type of node(Individual/Business/Organisation/Group): ");
        String mytype=sc.nextLine();
        if(mytype.equalsIgnoreCase("individual")) return new nodes.Individual(sc,i);
        if(mytype.equalsIgnoreCase("business")) return new nodes.Business(sc,i);
        if(mytype.equalsIgnoreCase("organisation")) return new nodes.Organisation(sc,i);
        if(mytype.equalsIgnoreCase("group")) return new nodes.Group(sc,i);
        return null;
    }
    public static void AddLink(nodes.Node nodes[], Scanner sc)
    {
        int id1, id2;
        System.out.println("Enter id of first node to be linked");
        id1=sc.nextInt();
        System.out.println("Enter id of second node to be linked");
        id2=sc.nextInt();
        sc.nextLine();
        if(utils.Utils.LinkageValidityCheck(nodes,id1,id2)==false)
        {
            return;
        }
        else 
        if(nodes[id1].getClass()==nodes.Business.class && nodes[id2].getClass()==nodes.Individual.class)
        {
            System.out.println("Is the individual an Owner or Customer of business (Owner/Customer)?");
            String oc = sc.nextLine();
            if(oc.equalsIgnoreCase("owner"))
            {
                nodes[id1].links.add(id2);
                ((nodes.Business)nodes[id1]).Owners.add(id2);
                nodes[id2].links.add(id1);
            }
            else 
            {
                nodes[id1].links.add(id2);
                ((nodes.Business)nodes[id1]).Customers.add(id2);
                nodes[id2].links.add(id1);
            }
           
           
        }
        else 
        if(nodes[id2].getClass()==nodes.Business.class && nodes[id1].getClass()==nodes.Individual.class)
        {
            System.out.println("Is the individual an Owner or Customer of business(Owner/Customer)?");
            String oc = sc.nextLine();
            if(oc.equalsIgnoreCase("owner"))
            {
                nodes[id2].links.add(id1);
                ((nodes.Business)nodes[id2]).Owners.add(id1);
                nodes[id1].links.add(id2);
            }
            else 
            {
                nodes[id2].links.add(id1);
                ((nodes.Business)nodes[id2]).Customers.add(id1);
                nodes[id1].links.add(id2);
            }
        }
        else 
        {
            nodes[id1].links.add(id2);
            nodes[id2].links.add(id1);
        }
        System.out.println("Link between given nodes was created sucessfully");
    }
    public static void GetLinks(nodes.Node nodes[], Scanner sc)
    {
        System.out.println("Enter id of Node whose Linkages you want");
        int id = sc.nextInt();
        sc.nextLine();
        if(nodes[id]==null)
        {
            System.out.println("Node with given id does not exist");
        }
        else
        if(nodes[id].links.isEmpty())
        {
            System.out.println("Node has no links");
        }
        else 
        {
            nodes[id].GetLinks(nodes);
        }
    }
    public static void AddContent(nodes.Node nodes[], Scanner sc)
    {
        System.out.println("Enter id of Node whose content you want to add to");
        int id = sc.nextInt();
        sc.nextLine();
        if(nodes[id]==null)
        {
            System.out.println("Node with given id does not exist");
        }
        else
        {
            String inp;
            System.out.println("Enter the content you want to add");
            inp=sc.nextLine();
            int flag=0;
            for(int i = 0; i < nodes[id].content.size(); i++){
                if(nodes[id].content.get(i).equals(inp)){
                    flag=1;
                    System.out.println("\nPost #" + (i+1) + " has been reposted\n");
                    break;
                }
            }
            if(flag==0){
                nodes[id].content.add(inp);
                System.out.println("\nNew content has been created and posted\n");
            }
        }
    }
    public static void PrintContent(nodes.Node nodes[], Scanner sc, int id)
    {
            if(nodes[id]==null)
            {
                System.out.println("Node with given id does not exist");
            }
            else
            {
                System.out.println("Content of Node with Id:"+nodes[id].getID());
                if(nodes[id].content.isEmpty())
                    System.out.println("**Node has no content**");
                else
                {
                int x=1;
                for(String value : nodes[id].content) 
                    {
                        System.out.println("Post #"+x+": "+value);
                        x+=1;
                    }
                }
            }
    }
    public static void PrintLinkedContent(nodes.Node nodes[], Scanner sc)
    {
        System.out.println("Enter id of Node ");
        int id = sc.nextInt();
        sc.nextLine();
        if(nodes[id]==null)
        {
            System.out.println("Node with given id does not exist");
        }
        else 
        {
            if(nodes[id].links.isEmpty())
                System.out.println("Node has no links");
            else
            {
                utils.Utils.NewLine(); 
                System.out.println("Printing Content of Nodes Linked To Given Node\n");
            }
            for(int j=0; j<nodes[id].links.size(); j++)
            {

                int ind = nodes[id].links.get(j);
                PrintContent(nodes, sc, ind);
                System.out.println();
            }
        }
    }
    public static void DeleteNode(nodes.Node nodes[], Scanner sc)
    {
        System.out.println("Enter id of Node ");
        int id = sc.nextInt();
        sc.nextLine();
        if(nodes[id]==null)
        {
            System.out.println("Node with given id does not exist");
        }
        else 
        {
            for(int j=0; j<nodes[id].links.size(); j++)
            {
                int ind = nodes[id].links.get(j);
                Integer x = (Integer)id;
                nodes[ind].links.remove(x);
            }
            nodes[id]=null;
            System.out.println("Node was deleted successfuly");
        }
    }
    public static void FindNode(nodes.Node nodes[], Scanner sc)
    {
        System.out.println("Find Node By (Enter number beside choice)\n 1. Name \n 2. Birthday \n 3. Type");
        String type = sc.nextLine(); 
        boolean f=false;
        if(type.equals("1"))
        {
            System.out.println("Enter Name to search");
            
            String search_name = sc.nextLine();
            for(int j=0; j<maxsize;j++)
            {
                if(nodes[j]==null)
                    continue;
                if(nodes[j].getName().equals(search_name))
                {
                    if(f==false)
                    {
                        utils.Utils.NewLine();
                        System.out.println("Displaying Search Results:\n");
                    }
                    nodes[j].PrintObj();
                    f=true;
                }
            }
        }
        if(type.equals("2"))
        {
            System.out.println("Enter Birthday to search");
            String search_bday = sc.nextLine();
            for(int j=0; j<maxsize;j++)
            {
                if(nodes[j]==null)
                    continue;
                if(nodes[j].getClass()==nodes.Individual.class && ((nodes.Individual)nodes[j]).getBirthday().equals(search_bday))
                {
                    if(f==false)
                    {
                        utils.Utils.NewLine();
                        System.out.println("Displaying Search Results:\n");
                    }
                    nodes[j].PrintObj();
                    f=true;
                }
            }
        }
        if(type.equals("3"))
        {
            System.out.println("Enter Type to search");
            String search_type = sc.nextLine();
            int t=0;
            if(search_type.equalsIgnoreCase("Group"))
                t=1;
            if(search_type.equalsIgnoreCase("Business"))
                t=2;
            if(search_type.equalsIgnoreCase("Organisation"))
                t=3;
            for(int j=0; j<maxsize;j++)
            {
                if(nodes[j]==null)
                    continue;
                if((t==0 && nodes[j].getClass()==nodes.Individual.class) || (t==1 && nodes[j].getClass()==nodes.Group.class) || (t==2 && nodes[j].getClass()==nodes.Business.class) || (t==3 && nodes[j].getClass()==nodes.Organisation.class) )
                {
                    if(f==false)
                    {
                        utils.Utils.NewLine();
                        System.out.println("Displaying Search Results:\n");
                    }
                    nodes[j].PrintObj();
                    f=true;
                }
            }
        }
        if(f==false)
        System.out.println("No item matched the given category");
                
    }
    public static void PrintAll(nodes.Node nodes[])
    {
            utils.Utils.NewLine();
            boolean flag = false;
            for(int j=0;j<maxsize;j++)
            {
                if(nodes[j]!=null)
                    {
                        nodes[j].PrintObj();
                        flag = true;
                    }
            }
            if(!flag)
            System.out.println("No Nodes are Active Currently");
                    
    }
}