#include<iostream>
#include<cstdlib>
#define n 10
using namespace std;

struct Node{
    Node* prev;
    int num;
    Node* next;
};

class list{
private:
    Node *head, *tail;
    
public:
    void createnode(int value);
    void insert(int val);
    void display();
    void sort();
    int length();
    list(){
        head = NULL;
        tail = NULL;
    };
};

void list::createnode(int value){
    Node* N = new Node;
    N->num = value;
    N->next = NULL;
    if(head == NULL)
    {
        head = N;
        tail = N;
    }
    else
    {
        tail->next = N;
        tail = N;
    }
}

void list::display(){
    Node* temp = new Node;
    temp=head;
    while(temp != NULL)
    {
        cout<<temp->num<<'\t';
        temp = temp->next;
    }
}

void list::sort(){
    Node* t1;
    if(head == NULL || head->next == NULL)
        return;
    else
        t1 = head;
    while(t1 != NULL)
    {
        Node* t2;
        t2 = head;
        while(t2->next != t1->next)
        {
            if(t2->num > t1->num)
            {
                int temp = t2->num;
                t2->num = t1->num;
                t1->num = temp;
            }
            t2 = t2->next;
        }
        t1 = t1->next;
        //delete t2;
    }
    
}

void list::insert(int val){
    Node* t = new Node;
    t->num = val;
    tail->next = t;
    tail = t;
}
int list::length(){
    int len = 0;
    if(head == NULL)
        return 0;
    Node* l = new Node;
    l = head;
    while(l != NULL)
    {
        len++;
        l = l->next;
    }
    return len;
}

int main()
{
    list mine;
    
    int a[] = {1,2,4,7,1,4,10,13,5};
    
    for(int j=0;j<9;j++)
        mine.createnode(a[j]);
    
    mine.insert(20);
    mine.display();
    //mine.sort();
    cout<<'\n';
    //mine.display();
    //cout<<"the length of the list is "<<mine.length();
    return 0;
}