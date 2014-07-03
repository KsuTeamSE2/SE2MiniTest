package forest;

import java.util.ArrayList;
import java.util.List;
/**
 *木構造に必要なノードのオブジェクト
 *@author 徳梅慎也
 */
public class Node
{
	/**
	 *子ノード
	 */
	public List<Node> nodeChildren = new ArrayList<Node>();

	/**
	 *親ノード
	 */
	public Node nodeParent = null;

	/**
	 *ノード名
	 */
	public String nodeName;

	/**
	 *ノード番号
	 */
	public int nodeNumber;

	/**
	 *名前と数字を受け取るコンストラクタ
	 *7/2正常
	 *@param aName ノードの名前
	 *@param aNumber ノードの整理番号
	 */
	public Node(String aName,int aNumber)
	{
		this.nodeName = aName;
		this.nodeNumber = aNumber;
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
	 *ノードの名前を応答
	 *@return nodeName
	 */
	public String getNodeName()
	{
		return this.nodeName;
	}
	/**
	 *
	 *@return nodeNumber
	 */

	

}
