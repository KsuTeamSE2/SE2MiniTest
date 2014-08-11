package forest;
import java.util.HashMap;

/**
 *根の情報をノードから継承し作成
 *@author TOKUUME Shinya
 */
public class Root extends Node
{
    /**
     *コンストラクタ
     *@param aNode 根になるノード
     */
    public Root(Node aNode)
    {
	super(aNode);
	for(Node aChildren : aNode.getChildrenNode().values())
	    {
		this.addChild(aChildren);
	    }
	setNodeDepth(0);
    }
}