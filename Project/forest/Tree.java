package forest;

import java.util.HashMap;

/**
 * 木のクラス
 * @author TOKUUME SHINYA
 *
 */
public class Tree
{

	/**
	 * この木のルート(根)
	 */
	private Root aRoot;

	/**
	 *この木のルート群
	 */
	private HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();

	/**
	 * コンストラクタ
	 * @param aRoot この木のルート(根)
	 */
	public Tree(Root aRoot)
	{
		this.aRoot = aRoot;
		nodes.put(aRoot.getNodeNumber(),aRoot);
	}

	/**
	 * ルートのゲッター
	 * @return aRoot
	 */
	public Root getRoot()
	{
		return aRoot;
	}


	/**
	 * ルートの子ノードを返答
	 * @return aRoot.getChildNode()
	 */
	public HashMap<Integer,Node> createTreeRoot()
	{
		if(!aRoot.getChildrenNode().isEmpty())
		{
			return aRoot.getChildrenNode();
		}else{return null;}
	}

	/**
	 *この木のノードの深さを探索して木が持つノードに挿入後
	 *挿入したノードの深さを返答
	 *@param aNode ノード
	 *@return aNode.getNodeDepth() 深さ
	 */
	public int serchNodeDepth(Node aNode)
	{
		int maxDepth = 0;

		for(Node aParentNode : aNode.getParentNode().values())
		{
			if(aParentNode.getNodeDepth()>maxDepth)
			{
				maxDepth = aParentNode.getNodeDepth();
			}
		}
		aNode.setNodeDepth(maxDepth+1);
		nodes.put(aNode.getNodeNumber(),aNode);
		return aNode.getNodeDepth();
	}

	/**
	 *木のノードを応答
	 *@return nodes
	 */
	public HashMap<Integer,Node> getNodes()
	{
		return this.nodes;
	}

}
