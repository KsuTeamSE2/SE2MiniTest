package forest;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 木のクラス
 * @author TOKUUME Shinya
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
	 * この木構造を枝から形成していく
	 * @param aBranch 枝の情報
	 */
	public void createTreeRoot()
	{
		if(!aRoot.getChildlenNode().isEmpty())
		{
			for(Node aChildNode : aRoot.getChildlenNode().values())
			{

				createTree(aChildNode);
			}
		}else{return;}
	}

	private void createTree(Node aNode)
	{
		int maxDepth = 0;

		for(Node aParentNode : aNode.getParentNode().values())
		{
			if(aParentNode.getNodeDepth()>maxDepth)
			{
				maxDepth = aParentNode.getNodeDepth();
			}
		}
		aNode.setNodeDepth(maxDepth);
		nodes.put(aNode.getNodeNumber(),aNode);
		if(!aNode.getChildlenNode().isEmpty())
		{
			for(Node aChildNode : aNode.getChildlenNode().values())
			{
				createTree(aChildNode);
			}
		}else{return;}
	}

	public HashMap<Integer,Node> getNodes()
	{
		return this.nodes;
	}
	
}
