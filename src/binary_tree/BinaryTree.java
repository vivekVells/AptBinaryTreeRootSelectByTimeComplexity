package binary_tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// defining the node class which will be taken as individual node block containing all Binary Tree attribs
// exclusively for integer data
class BinaryNode {
	BinaryNode leftChild, rightChild, parent;
	int data;
	
	public BinaryNode() {
		parent = leftChild = rightChild = null;
		data =0;
	}
	
	public void setData(int data) {
		this.data = data;
	}
	
	public int getData() {
		return this.data;
	}

	public void setLeftChild(BinaryNode lc) {
		this.leftChild = lc;
	}
	
	public BinaryNode getLeftChild() {
		return this.leftChild;
	}

	public void setRightChild(BinaryNode rc) {
		this.rightChild = rc;
	}
	
	public BinaryNode getRightChild() {
		return this.rightChild;
	}	
}

public class BinaryTree {
	static BinaryNode root = new BinaryNode();
	static BinaryTree bt = new BinaryTree();

	public BinaryTree() {}
	
	public void leftRightChildInsertData(BinaryNode node, int dataArg) {
		BinaryNode tempNode =  new BinaryNode();
		tempNode = node.leftChild;
		
		if(dataArg < tempNode.data) {
			while(tempNode.leftChild != null) {
				tempNode = tempNode.leftChild;
			}
			tempNode.leftChild = new BinaryNode();
			tempNode.leftChild.setData(dataArg);	
		}else {
			tempNode = node.rightChild;
			
			while(tempNode.rightChild != null) {
				tempNode = tempNode.rightChild;
			}
			tempNode.rightChild = new BinaryNode();
			tempNode.rightChild.setData(dataArg);
		}
	}
	
	public void checkAndRedirect(BinaryNode root, int dataArg) {
		if(root != null) {
			if(dataArg < root.data) {
				if(root.leftChild == null) {
					root.leftChild = new BinaryNode();
					root.leftChild.parent = root;
					root.leftChild.setData(dataArg);
				}else {
					leftRightChildInsertData(root, dataArg);
					/*
					BinaryNode tempNode =  new BinaryNode();
					tempNode = root.leftChild;
					
					if(dataArg < tempNode.data) {
						while(tempNode.leftChild != null) {
							tempNode = tempNode.leftChild;
						}
						tempNode.leftChild = new BinaryNode();
						tempNode.leftChild.setData(dataArg);	
					}else {
						tempNode = root.rightChild;
						
						while(tempNode.rightChild != null) {
							tempNode = tempNode.rightChild;
						}
						tempNode.rightChild = new BinaryNode();
						tempNode.rightChild.setData(dataArg);
					}
					*/
				}
			}else if(dataArg > root.data) {
				if(dataArg > root.data) {
					if(root.rightChild == null) {
						root.rightChild = new BinaryNode();
						root.rightChild.setData(dataArg);
					}else {
						leftRightChildInsertData(root, dataArg);
						/*
						BinaryNode tempNode = new BinaryNode();
						tempNode = root.rightChild;
						
						while(tempNode.rightChild != null) {
							tempNode = tempNode.rightChild;
						}
						tempNode.rightChild = new BinaryNode();
						tempNode.rightChild.setData(dataArg);
						*/
					}
				}
			}
		}
	}
	
	private BinaryNode add(BinaryNode node, int dataArg)
    {
        if (node == null) {
            node = new BinaryNode();
        	node.setData(dataArg);
        }else {
            if (dataArg <= node.getData())
                node.leftChild = add(node.leftChild, dataArg);
            else
                node.rightChild = add(node.rightChild, dataArg);
        }
        return node;
    }
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int inputLen = 0;
		List<Integer> intArrayList = new ArrayList<>();
		
		System.out.print("Input total length of array: ");
		inputLen = scan.nextInt(); scan.nextLine();
		
		for(int i=0; i<inputLen; i++) {
			intArrayList.add(scan.nextInt());
		}
		
		System.out.println("Given Array: " + (intArrayList));
		
		
		root.data = intArrayList.get(0);
		
		for(int i=1; i<inputLen; i++) {
			//bt.checkAndRedirect(root, intArrayList.get(i));
			bt.add(root, intArrayList.get(i));
		}
		
		/*
		// [7, 4, 9, 2, 5, 8, 12,1] 
		System.out.println("Root: " + root.data); // 7
		System.out.println(root.leftChild.data); // 4
		System.out.println(root.rightChild.data); // 9
		System.out.println(root.leftChild.leftChild.data); // 2
		System.out.println(root.leftChild.rightChild.data); // 5
		System.out.println(root.rightChild.leftChild.data); // 8
		System.out.println(root.rightChild.rightChild.data); // 12
		System.out.println(root.leftChild.leftChild.leftChild.data); // 1
		*/
		
	}
}









