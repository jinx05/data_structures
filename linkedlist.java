package com.example.helloworld;

public class linkedlist {
    node head;
    static class node
    {
        int num;
        node next;
        node(int n) {this.num = n;}
    }

    public static void printer(linkedlist a)
    {
        node temp = a.head;
        if(temp == null)
        {
            System.out.print("NUll");
        }
        while (temp != null)
        {
            System.out.print(temp.num);
            System.out.print(" ");
            temp = temp.next;
        }
        System.out.print("\n");

        return;
    }

    public static linkedlist insert(linkedlist a, int n)
    {
        node nex = new node(n);
        nex.next = null;
        if(a.head == null)
        {
            a.head = nex;
        }
        else
        {
            node temp = a.head;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = nex;
        }

        return a;
    }

    public static void swap(node a, node b)
    {
        int temp = a.num;
        a.num = b.num;
        b.num = temp;
    }

    public static linkedlist sorter(linkedlist a)
    {
        node temp = a.head;
        if(temp.next == null)
        {
            return a;
        }
        while(temp.next != null)
        {
            node temp2 = temp.next;
            while(temp2 != null)
            {
                if(temp.num > temp2.num)
                {
                    swap(temp,temp2);
                }
                temp2 = temp2.next;
            }

            temp = temp.next;
        }
        return a;
    }

    public static void main(String[] args) {
        linkedlist lister = new linkedlist();
        lister = insert(lister,10);
        lister = insert(lister,1);
        lister = insert(lister,100);
        lister = insert(lister,2);
        lister = insert(lister,50);
        lister = insert(lister,60);
        lister = insert(lister,40);
        lister = insert(lister,35);
        lister = insert(lister,3);
        lister = insert(lister,400);
        lister = insert(lister,200);
        lister = insert(lister,9);
        lister = insert(lister,15);
        lister = insert(lister,16);
        lister = insert(lister,9);

        printer(lister);
        node a = lister.head;
        swap(a,a.next);
        printer(lister);
        lister = sorter(lister);
        printer(lister);
    }
}
