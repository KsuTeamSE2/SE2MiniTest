package forest;

import java.util.HashMap;

import javax.swing.border.LineBorder;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;



/**
 *木構造に必要なノードのオブジェクト
 *@author TOKUUME Shinya
 */
public class Node extends JLabel
{
	/**
	 *子ノード
	 */
	private HashMap<Integer,Node> nodeChildren = new HashMap<Integer,Node>();

	/**
	 *親ノード
	 */
	private HashMap<Integer,Node> nodeParent = new HashMap<Integer,Node>();

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
	private  int depth = 0;

	/**
	 *このノードを探索を行ったか
	 */
	private boolean visit = false;

	/**
	 *名前と数字を受け取るコンストラクタ
	 *@param aName ノードの名前
	 *@param aNumber ノードの整理番号
	 */
	public Node(String aName,int aNumber)
	{
		this.nodeName = aName;
		this.nodeNumber = aNumber;

		this.setFont(new Font("Arial", Font.PLAIN, 12));
		this.setText(this.nodeName);
		this.setBorder(new LineBorder(Color.black, 1));
		this.setSize(this.getPreferredSize());	}
	
	/**
	 * ノード自身でノードを作成するコンストラクタ
	 * ルートを作る際に必要
	 * @param aNode ノード自身
	 */
	public Node(Node aNode)
	{
		this.nodeNumber = aNode.getNodeNumber();
		this.nodeName = aNode.getNodeName();

		this.setFont(new Font("Arial", Font.PLAIN, 12));
		this.setText(aNode.getNodeName());
		this.setBorder(new LineBorder(Color.black, 1));
		this.setSize(this.getPreferredSize());
	}

	/**
	 *子ノードを追加する
	 *@param aChild このノードの子ノード
	 */
	public void addChild(Node aChild)
	{
		this.nodeChildren.put(aChild.getNodeNumber(),aChild);
	}

	/**
	 *親ノードを追加する
	 *7/2不必要な可能性があります
	 *@param aParent このノードの親ノード
	 */
	public void addParent(Node aParent)
	{
		this.nodeParent.put(aParent.getNodeNumber(),aParent);
	}
	/**
	 *親ノードの返答
	 *@return this.nodeParent
	 */
	public HashMap<Integer,Node> getParentNode()
	{
		return this.nodeParent;
	}

	/**
	 *
	 *子ノードの返答
	 *@return this.nodeChildren
	 */
	public HashMap<Integer,Node> getChildrenNode()
	{
		return this.nodeChildren;
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

	/**
	 *ノードの深さを設定する
	 *@param aDepth ノードの深さ
	 */
	public void setNodeDepth(int aDepth)
	{
		this.depth = aDepth;
	}
	/**
	 *ノードの深さを取得する
	 *@return this.depth
	 */
	public int getNodeDepth()
	{
		return this.depth;
	}
	/**
	 *ノードを探索したという印をつける
	 */
	public void setVisiting()
	{
		this.visit = true;
	}
	public boolean getVisiting()
	{
		return this.visit;
	}

	
	
	
}
