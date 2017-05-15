package tree.test;

import java.util.Arrays;

import list.DoublyLinkedList;
import list.List;
import tree.LinkedTree;

public class LinkedTreeTest {

	public static void main(String[] args) {
		LinkedTree<String> tree =
				new LinkedTree<String>("A");
		//level1
		//내부 클래스에 root가 정의되어 있기때문에
		LinkedTree.TreeNode<String> root = tree.getRoot();
		
		//level2
		LinkedTree.TreeNode<String> nodeB=
					tree.insertLeft(root, "B");
		LinkedTree.TreeNode<String> nodeC=	
				tree.insertRight(root, "C");
		//level3
		LinkedTree.TreeNode<String> nodeD=
		tree.insertLeft(nodeB, "D");
		LinkedTree.TreeNode<String> nodeE=
		tree.insertRight(nodeB, "E");
		
		//level4
		tree.insertLeft(nodeD, "H");
		tree.insertRight(nodeD, "I");
		
		tree.insertLeft(nodeE, "J");
		
		//level3
		LinkedTree.TreeNode<String> nodeF=
				tree.insertLeft(nodeC, "F");
		
		LinkedTree.TreeNode<String> nodeG=
				tree.insertRight(nodeC, "G");
		
		//level4
		tree.insertRight(nodeF, "K");
		
		tree.insertLeft(nodeG, "L");
		tree.insertRight(nodeG, "M");
		
		//tree.traversalPostorder(tree.getRoot());
		List<String> list = new DoublyLinkedList<String>();
		tree.traversalPostorder(list);
		System.out.println(Arrays.toString(list.toArray()));
	}

}
