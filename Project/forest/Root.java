package forest;

public class Root extends Node
{

	public Root(Node aNode)
	{
		super(aNode);
		for(Node aChild : aNode.getChildlenNode().values())
		{
			aNode.addChild(aChild);
		}
		setNodeDepth(0);
	}

}