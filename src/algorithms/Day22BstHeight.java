package algorithms;

import java.util.Scanner;


class Day22BstHeight {
	public Day22BstHeight() {}
	
	public static int getHeight(Node root){
		/**
		 * Any node has a height of 1, and the height of an empty subtree is -1.
		 * The Height of a tree is:
		 * 1 + max(height(leftSubTree), height(rightSubTree))
		 * (i.e., one more than the maximum of the heights of its left and right subtrees). 
		 */
		int result = 0;
		if (root == null){
			result = -1;
		}else{
			result = 1 + max(getHeight(root.left), getHeight(root.right));
		}
		return result;
    }

    private static int max(int left, int right) {
		int bigger = left > right ? left : right;
		return bigger;
	}

	public static Node insert(Node root, int data){
        if(root==null){
            return new Node(data);
        }
        else{
            if(data<=root.data){
            	root.left = insert(root.left, data);
            }
            else{
            	root.right = insert(root.right, data);
            }
            return root;
        }
    }
	 public static void main(String args[]){
        Scanner input=new Scanner(System.in);
        int T=input.nextInt();
        Node root=null;
        while(T-->0){
            int data=input.nextInt();
            root=insert(root,data);
        }
        int height=getHeight(root);
        System.out.println(height);
    }
}
