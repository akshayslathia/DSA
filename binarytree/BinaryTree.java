package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree 
{
	static int index = -1;
	public static Node buildTree(int[] arr)
	{
		index++;
		if(index==arr.length || arr[index]==-1 )
			return null;
		
		Node newNode = new Node(arr[index]);
		newNode.left = buildTree(arr);
		newNode.right = buildTree(arr);
		
		return newNode;
		
	}
	
	public static int findMin(Node root)
	{
		
		if(root==null)
			return Integer.MAX_VALUE;
		
		int leftSmall = findMin(root.left);
		int rightSmall = findMin(root.right);
		
		int small = Math.min(leftSmall, rightSmall);
		
		return  Math.min(small, root.data);
		
		
	}
	
	public static boolean checkIdentical(Node root1,Node root2)
	{
		if(root1==null && root2==null)
			return true;
		
		if(root1==null || root2==null)
			return false;
		
		
		
		boolean left = checkIdentical(root1.left, root2.left);
		boolean right = checkIdentical(root1.right, root2.right);
		
		boolean res = left && right && root1.data==root2.data;
		
		return res;
		
	}
	
	public static int findMax(Node root)
	{
		if(root==null)
			return Integer.MIN_VALUE;
		
		int leftLarge = findMax(root.left);
		int rightLarge = findMax(root.right);
		
		int large = Math.max(leftLarge, rightLarge);
		
		return Math.max(large, root.data);
	}
	
	public static void preorder(Node root)
	{
		if(root==null)
			return;
		
		System.out.print(root.data+" ");
		preorder(root.left);
		preorder(root.right);
		
	}
	
	public static void postorder(Node root)
	{
		if(root==null)
			return;
		
		
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data+" ");
	}
	
	public static int heightOfTree(Node root)
	{
		if(root==null)
			return 0;
		
		int left = heightOfTree(root.left);
		int right = heightOfTree(root.right);
		
		return 1 + Math.max(left, right);
	}
	
	public static int countNodes(Node root)
	{	
		return root==null ? 0 : 1+ countNodes(root.left) + countNodes(root.right);
	}
	
	public static int sumOfNodes(Node root)
	{
		if(root==null)
			return 0;
		
		int left = sumOfNodes(root.left);
		int right = sumOfNodes(root.right);
		
		return root.data + left + right;
	}
	
	public static void levelOrder(Node root)
	{
		if(root==null)
			return;
		
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty())
		{
			Node node = q.remove();
			if(node==null)
			{
				if(q.isEmpty())
					break;
				else
				{
					System.out.println();
					q.add(null);
				}
			}
			else
			{
				System.out.print(node.data+" ");
				if(node.left!=null)
					q.add(node.left);
				
				if(node.right!=null)
					q.add(node.right);
			}
		}
	}
	
	public static void inorder(Node root)
	{
		if(root==null)
			return;
		
		
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
		
	}
	
	public static void leafNodes(Node root)
	{
		if(root==null)
			return;
		
		if(root.left==null && root.right==null)
			System.out.println(root.data);
		
		leafNodes(root.left);
		leafNodes(root.right);
	}
	
	public static int sumOfLeafNodes(Node root)
	{
		if(root==null) // base condition
			return 0;
		
		if(root.left==null && root.right==null) // leaf condition
			return root.data;
		
		int left = sumOfLeafNodes(root.left);
		int right = sumOfLeafNodes(root.right);
		
		return left+right;
		
	}
	
	public static void main(String[] args) {
		int[] arr = {5,3,4,-1,-1,5,6,-1,-1,-1,2,-1,9,-1,-1};
		
		Node root = buildTree(arr);
		//System.out.println(root.data);
		
		preorder(root); System.out.println();
		inorder(root); System.out.println();
		postorder(root);
		System.out.println();
		System.out.println("No of nodes "+countNodes(root));
		System.out.println("Sum of nodes "+sumOfNodes(root));
		System.out.println("Height of a tree :"+heightOfTree(root));
		System.out.println("----");
		leafNodes(root);
		System.out.println("Sum of leafs nodes :"+sumOfLeafNodes(root));
		
		System.out.println("Smallest value in tree :"+findMin(root));
		System.out.println("Largest value in tree :"+findMax(root));
		
		System.out.println("Identical trees :"+checkIdentical(root, root));
		
		levelOrder(root);
		
		
		
	}
}
