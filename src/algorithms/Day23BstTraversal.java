package algorithms;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Day23BstTraversal{
	/**
	 * InOrder Traversal
	 * An inorder traversal of a binary search tree will process the tree's elements in ascending order.
inOrder(t) {
    if(t is not empty) {
        inOrder( left subtree of t )
        process t's root element
        inOrder( right subtree of t )
    } 
} 
	 */
	static void inOrder(Node root){
		if (root != null){
			inOrder(root.left);
			System.out.print(root.data + " ");
			inOrder(root.right);
		}
    }
	/**
	 * PostOrder Traversal
postOrder(t) {
    if(t is not empty) {
        postOrder( left subtree of t )
        postOrder( right subtree of t )
        process t's root element
    } 
} 
	 */
	static void postOrder(Node root){
		if (root != null){
			postOrder(root.left);
			postOrder(root.right);
			System.out.print(root.data + " ");
		}
	}

	/**
	 * PreOrder Traversal (DFS)
	 * Because a preorder traversal goes as deeply to the left as possible, it's also known as a depth-first-search or
	 * DFS.
preOrder(t) {
    if(t is not empty) {
        process t's root element
        preOrder( left subtree of t )
        preOrder( right subtree of t )
    } 
} 
	 */
	static void preOrder(Node root){
		if (root != null){
			System.out.print(root.data + " ");
			preOrder(root.left);
			preOrder(root.right);
		}
	}
	/**
	 * Level-Order Traversal (BFS)
	 * The basic algorithm shown below uses a queue of references to binary trees to keep track of the subtrees at
	 * each level:
levelOrder(BinaryTree t) {
    if(t is not empty) {
        // enqueue current root
        queue.enqueue(t)
        
        // while there are nodes to process
        while( queue is not empty ) {
            // dequeue next node
            BinaryTree tree = queue.dequeue();
            
            process tree's root;
            
            // enqueue child elements from next level in order
            if( tree has non-empty left subtree ) {
                queue.enqueue( left subtree of t )
            }
            if( tree has non-empty right subtree ) {
                queue.enqueue( right subtree of t )
            }
        }
    } 
} 
	 */
	static void levelOrder(Node root){
		Queue<Node> queue = new LinkedList<Node>();
		if (root != null){
			queue.add(root);
			while (!queue.isEmpty()){
				Node tempTree = queue.remove();
				System.out.print(tempTree.data + " ");
				if (tempTree.left != null){
					queue.add(tempTree.left);
				}
				if (tempTree.right != null){
					queue.add(tempTree.right);
				}
			}
		}
    }
	public static Node insert(Node root,int data){
	        if(root==null){
	            return new Node(data);
	        }
	        else{
	            Node cur;
	            if(data<=root.data){
	                cur=insert(root.left,data);
	                root.left=cur;
	            }
	            else{
	                cur=insert(root.right,data);
	                root.right=cur;
	            }
	            return root;
	        }
	    }
	    public static void main(String args[]){
	            Scanner scanner = new Scanner(System.in);
	            int T = scanner.nextInt();
	            Node root = null;
	            while(T-- > 0){
	                int data=scanner.nextInt();
	                root = insert(root,data);
	            }
	            levelOrder(root);
	        }	
}


