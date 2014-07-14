package forest;

import java.util.ArrayList;
import java.util.List;
/**
 *木構造に必要なノードのオブジェクト
 *@author TOKUUME Shinya
 */
public class Node
{
	/**
	 *子ノード
	 */
	private List<Node> nodeChildren = new ArrayList<Node>();

	/**
	 *親ノード
	 */
	private Node nodeParent = null;

	/**
	 *ノード名
	 */
	private String nodeName;

	/**
	 *ノード番号
	 */
	private int nodeNumber;
	
	/**
	 *このノードの深さ 
	 */
	private int depth; 

	/**
	 *名前と数字を受け取るコンストラクタ
	 *@param aName ノードの名前
	 *@param aNumber ノードの整理番号
	 */
	public Node(String aName,int aNumber)
	{
		this.nodeName = aName;
		this.nodeNumber = aNumber;
	}
	
	/**
	 * ノード自身でノードを作成するコンストラクタ
	 * ルートを作る際に必要
	 * @param aNode
	 */
	public Node(Node aNode)
	{
		this.nodeNumber = aNode.getNodeNumber();
		this.nodeName = aNode.getNodeName();
	}

	/**
	 *子ノードを追加する
	 *@param aChild このノードの子ノード
	 */
	public void addChild(Node aChild)
	{
		this.nodeChildren.add(aChild);
	}

	/**
	 *親ノードを追加する
	 *7/2不必要な可能性があります
	 *@param aParent このノードの親ノード
	 */
	public void addParent(Node aParent)
	{
		this.nodeParent = aParent;
	}

	/**
	 *ノードの名前を返答する
	 *@return nodeName
	 */
	public String getNodeName()
	{
		return this.nodeName;
	}
	/**
	 *ノードの番号を返答する
	 *@return nodeNumber
	 */
	public int getNodeNumber()
	{
		return this.nodeNumber;
	}

	
	
	
}
