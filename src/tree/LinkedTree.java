package tree;


import list.List;
import stack.Stack;
import stack.StackException;

public class LinkedTree<E> {

	private TreeNode<E> root;

	public LinkedTree() {

	}

	public TreeNode<E> getRoot() {
		return root;
	}

	public LinkedTree(E data) {
		root = new TreeNode<E>(data);
	}

	public TreeNode<E> insertLeft(TreeNode<E> parents, E data) {
		final TreeNode<E> newNode = new TreeNode<E>(data);
		parents.left = newNode;
		return newNode;
	}

	public TreeNode<E> insertRight(TreeNode<E> parents, E data) {
		final TreeNode<E> newNode = new TreeNode<E>(data);
		parents.right = newNode;
		return newNode;
	}

	public void traversalPostorder(TreeNode<E> node) {
		if (node.left != null) {
			traversalPostorder(node.left);
		}
		if (node.right != null) {
			traversalPostorder(node.right);
		}
		System.out.println(node.data);
	}

	public void traversalPostorder(List<E> list, TreeNode<E> node) {
		if (node.left != null) {
			traversalPostorder(list, node.left);
		}
		if (node.right != null) {
			traversalPostorder(list, node.right);
		}
		list.add(node.data);
		// System.out.println(node.data);
	}
	
	//탐색 및 리스트에 자료를 담기위함
	public void traversalPostorder(List<E> list) {

		traversalPostorder(list, root);
	}
		
	public void calculating(List<E> list){
		calculating(list,root);
	}
	public void calculating(List<E> list, TreeNode<E> node){
		if(node.left!=null){
			calculating(list,node.left);
		}
		if(node.right!=null){
			calculating(list, node.right);
		}
		list.add(node.data);
		
	}
	//트리에 있는 노드들의 수식계산
	public double calc(TreeNode<String> treeNode){
		double result = 0;
		double lV = 0;
		double rV = 0;
		//비어있지 않다면 재귀호출하여 끝 노드까지 접근
		if(treeNode.left !=null){
			lV = calc(treeNode.left);
		}
		if(treeNode.right!=null){
			rV=calc(treeNode.right);
		}
		//반환된 노드에 있는 수식을 이용한 계산
		switch(treeNode.data){
		case "+":
			result = lV+rV;
			break;
		case "-":
			result = lV-rV;
			break;
		case "/":
			result = lV/rV;
			break;
		case "*":
			result = lV*rV;
			break;
		default : 
			result = Double.parseDouble(treeNode.data);
		}
		return result;
	}
	
	public static class TreeNode<E> {
		private E data;
		private TreeNode<E> left;
		private TreeNode<E> right;

		public TreeNode(E data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

	}
	//stack에 있는 수식들을 tree형태로 바꾸는 함수
	public static LinkedTree<String> toExpressionTree(String str) throws StackException {
		//트리형 노드를 담을 수 있는 스택
		Stack<TreeNode<String>> stack = new Stack<TreeNode<String>>();
		//tree 자료구조를 반환하기 위한 tree
		LinkedTree<String> tree = new LinkedTree<String>();
		int index = 0;
		//트리를 만들때까지 돌면서
		while (true) {
			//파라미터로 받아온 문자열 수식을 한개씩 잘라낸다
			String token = Character.toString(str.charAt(index));
			//잘라내어 트리에 들어갈 수 있도록 한다
			TreeNode<String> treeNode = new TreeNode<String>(token);
			//수식에 해당하는 정규식과 문자열의 토큰값이 일치한다면 스택에 push
			if (token.matches("-?\\d+(\\.\\d+)?")) {
				stack.push(treeNode);
				//일치하지 않으면 안에 있던 스택 노드들을 pop하여 노드 right left에 넣고 수식을 push한다.
			} else {
				treeNode.right = stack.pop();
				treeNode.left = stack.pop();
				stack.push(treeNode);
			}
			//모든 스택에 있는 자료를 트리화 하였다면 빠져나가기 위한 조건
			index++;
			if (index == str.length()) {
				//마지막 트리의 루트에 수식을 넣어준다.
				tree.root = stack.pop();
				break;
			}
		}

		return tree;
	}
}
