package forest;

import java.util.ArrayList;

public class Tree
{
	/**
	 * 木構造にするために必要な
	 * ノード一式
	 */
	ArrayList<Node> nodes;
	/**
	 * 木構造にするために必要な
	 * 枝一式
	 */
	ArrayList<Branch> branches;
	/**
	 * コンストラクタ
	 * @param aCollection
	 * @param branches
	 */
	public Tree(ArrayList<Node> nodes,ArrayList<Branch> branches)
	{
		this.nodes = nodes;
		this.branches = branches;
		linkedNode();
	}
	/**
	 * ブランチの情報からノードの情報を入れる。
	 */
	public void linkedNode()
	{
		for(Branch aBranch : branches)
		{
			Node aChildNode = nodes.get(aBranch.getChildNumber());
			Node aParentNode = nodes.get(aBranch.getParentNumber());
			aChildNode.addParent(aParentNode);
			aParentNode.addChild(aChildNode);
		}
	}

	public void createTree()
	{
		ArrayList<Node> aRoot = new ArrayList<Node>();

		for(Node aNode : nodes)
		{
			if(aNode.getParentNode() == null)
			{
				aRoot.add(aNode);
				System.out.println(aNode.getNodeName());
			}
		}
	}
}
