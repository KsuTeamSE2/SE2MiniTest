package forest;
import java.util.HashMap;

public class Root extends Node
{
    
    public Root(Node aNode)
    {
	super(aNode);
	for(Node aChildren : aNode.getChildlenNode().values())
	    {
		this.addChild(aChildren);
	    }
	setNodeDepth(0);
    }
}