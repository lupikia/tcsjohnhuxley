package com.tcsjohnhuxley;

public class Main {

    public static void main(String[] args)
    {
        int item_to_delete =2;
        String item_to_search ="Paul";

        LinkedList itemList = new LinkedList();
        itemList.insertItem("david");
        itemList.insertItem("Paul");
        itemList.insertItem(2);
        itemList.insertItem("Jaxck");


        /****************delete and display*****************/
        LinkedList tempNew = new LinkedList();
        Node temp = itemList.head;

        while (temp != null)
        {
            if( !temp.data.equals(item_to_delete))
            {
                tempNew.insertItem(temp.data);
            }
            temp=temp.next;
        }

        itemList=tempNew;
        Node displayList=itemList.head;
        while (displayList != null)
        {
            System.out.println("New list items " + displayList.data);
            displayList=displayList.next;
        }
        /****************delete and display*****************/


        /****************search and display*****************/

        System.out.println("Item search result: "+  itemList.searchItem(item_to_search));
        /****************search and display*****************/



    }
}

class LinkedList<param>
{
    Node head;
    Node newItem;
    Node newItemTemp = new Node();

    public void insertItem(param d)
    {
        newItem= new Node();
        newItem.data = d;
        newItem.next = head;
        head=newItem;
    }

    public param searchItem(param key)
    {
        Node temp_search = head;
        while (temp_search != null)
        {
            if( temp_search.data.equals(key))
            {
               return (param) temp_search.data;
            }
            temp_search=temp_search.next;
        }

        return null;
    }
    public void insetNewTempItem(Object temp)
    {
        Node temp_checker=newItemTemp;
        int counter=0;

        while (temp_checker != null)
        {

            if(temp_checker.next==null)
            {

                newItem= new Node();
                newItem.data = temp;
                newItemTemp.next=newItem;
            }

            if(counter>0)
            {
                newItemTemp.next=temp_checker;
            }

            temp_checker=temp_checker.next;
            counter++;
        }
    }

}
class Node<param>
{
    param data;
    Node next=null;
}

