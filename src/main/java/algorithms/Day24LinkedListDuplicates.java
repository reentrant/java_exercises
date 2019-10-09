package algorithms;

import java.util.Scanner;

public class Day24LinkedListDuplicates {

	public static  Node insert(Node head,int data)
	{
	    if(head == null){
	    	head = new Node(data);
	    }
	    else{
	        Node start = head;
	        while(start.next != null)
	            start = start.next;
	        start.next = new Node(data);
	    }
	    return head;
	}

	public static Node removeDuplicates(Node head) {
	      Node start = head;
	      while(start.next != null){
	    	  int nextData = start.next.data;
	    	  if(start.data == nextData){
	    		  start.next = start.next.next;
	    	  }
	    	  else{
	    		  start = start.next;
	    	  }
	      }
	      return head;
	}

	
 	public static void display(Node head){
          Node start = head;
          while(start != null){
              System.out.print(start.data + " ");
              start = start.next;
          }
    }

 	public static void main(String args[]){
          Scanner input=new Scanner(System.in);
          Node head=null;
          int T = input.nextInt();
          while(T-- > 0){
              int element = input.nextInt();
              head=insert(head, element);
          }
          head=removeDuplicates(head);
          display(head);

    }

}
