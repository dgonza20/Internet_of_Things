/*
 * David Gonzales
 * Assignment 1, ECGR 4090
 */
package Assignment1IOT;

import java.util.*;
import java.util.HashSet;




/**
 *
 * @author degme
 */
public class Main {
    
    // Node class to make a linked list
    public static class Node {
        
        Node next;
        int data;

        public Node(int data) {
            this.data=data;
        }
        
        
        public Node(){
   
        }
    
    }
    
    // Class for making a linked list
    public static class linklist{
        Node head;
        
        
        // Q1: Sort list in descending order while inserting
        public void addNode(int value){
            // if the list is empty
            if(head== null){
                head = new Node(value);
               // head.next=null;
            }
            else if(value >= head.data){
                prepend(value);
            }
            else{
                append(value);
            }
            
        }
        // Helper function for Q1
        public void append(int data){
            
            Node helper = new Node();
            Node current = helper;
            helper.next = head;

            Node newNode = new Node(data);
            
            
            while(current.next != null && current.next.data > data){
                current = current.next;
            }
            
            newNode.next=current.next;
            current.next=newNode;

        }
        // Helper function for Q1
        public void prepend(int data){
            Node newHead = new Node(data);
            newHead.next = head;
            head = newHead;
        }

        
        // Question 2: Removing duplicates from a linked list
        public void Duplicates(Node head){
            
            HashSet<Integer> Table = new HashSet<>();
        
            Node current = head;
            Node previous = null;
        
            while(current != null){
            
                
                if(Table.contains(current.data)){
                    previous.next = current.next;
                }
                else{
                    Table.add(current.data);
                    previous = current;
                }
                current = current.next;
            }
        
        }
        
        
        // Question 3: Checking if a linked list is a palindrome or not
        public boolean PalindromeCheck(Node word){
            
            Node firstHalf = head;
            Node secondHalf = head;
            
            Stack<Integer> stacklist = new Stack();
            
            if(head == null || head.next == null){
                return true;
            }
            
            
            // add first half of the list to a stack
            while(secondHalf != null && secondHalf.next != null){
                stacklist.push(firstHalf.data);
                firstHalf = firstHalf.next;
                secondHalf = secondHalf.next.next;
            }
            
            if(secondHalf !=null){
                firstHalf = firstHalf.next;
            }
            
            // compare the top of the stack with the second half of the list
            while(firstHalf != null){
                if(stacklist.pop() != firstHalf.data){
                    return false;
                }
                firstHalf = firstHalf.next;
            }
                    return true;
        }
        
        // Helper function for Q3
        public void AddFront(int value){
            
            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
            
        }
        
        // Function to prink a linked list
        public void printList(Node head){
            // Print out the list
            while(head != null){
                System.out.println(head.data);
                head = head.next;
            }
        }
       
        
    }
    
    

    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
     linklist list = new linklist();
     
     
     // List to be made for question one and two
     list.addNode(21);
     list.addNode(3);
     list.addNode(5);
     list.addNode(8);
     list.addNode(3);
     list.addNode(2);
     list.addNode(1);
     list.addNode(21);
     list.addNode(20);
    
     System.out.println("Question one list:");
     list.printList(list.head);
     
     System.out.println("Question two list:");
     list.Duplicates(list.head);
     list.printList(list.head);
     
     
     linklist list3 = new linklist();
     
     list3.AddFront(1);
     list3.AddFront(2);
     list3.AddFront(3);
     list3.AddFront(3);
     list3.AddFront(2);
     list3.AddFront(1);
     
     System.out.println("Question 3 list:");
     list3.printList(list3.head);
     if(list3.PalindromeCheck(list3.head)){
         System.out.println("List is a palindrome");
     }
     else{
         System.out.println("List is not a palindrome");
     }
     
     
     
    }
    

    
}

