package dataStructures;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Day18Queues {
	Stack stack = new Stack();
	LinkedList queue = new LinkedList();
	
	void pushCharacter(char c) {
		stack.push(c);
	}
	
	char popCharacter() {
		return (char) stack.pop();
	}
	
	void enqueueCharacter(char c) {
		queue.add(c);
	}
	
	char dequeueCharacter() {
		return (char) queue.remove();
	}

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        char[] s = input.toCharArray();
        Day18Queues p = new Day18Queues();
        // Enqueue/Push all chars to their respective data structures:
        for (char c : s) {
            p.pushCharacter(c);
            p.enqueueCharacter(c);
        }
        // Pop/Dequeue the chars at the head of both data structures and compare them:
        boolean isPalindrome = true;
        for (int i = 0; i < s.length/2; i++) {
            if (p.popCharacter() != p.dequeueCharacter()) {
                isPalindrome = false;                
                break;
            }
        }

        //Finally, print whether string s is palindrome or not.
        System.out.println( "The word, " + input + ", is " 
                           + ( (!isPalindrome) ? "not a palindrome." : "a palindrome." ) );
    }
}


