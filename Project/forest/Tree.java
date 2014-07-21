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
    public HashMap<Integer,Node> createTreeRoot()
    {
	if(!aRoot.getChildlenNode().isEmpty())
	    {
		return aRoot.getChildlenNode();
	    }else{return null;}
    }

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
	/*
	if(!aNode.getChildlenNode().isEmpty())
	    {
		for(Node aChildNode : aNode.getChildlenNode().values())
		    {
			return aChildNode.getNodeDepth();
		    }
	    }else{return -1;}
	    */
    }
    
    public void getNodes()
    {
	for(Node aNode : nodes.values())
	    {
		System.out.println("No."+aNode.getNodeNumber()+"Depth"+aNode.getNodeDepth());
	    }	
	//return this.nodes;
    }
    
}
