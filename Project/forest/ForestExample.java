package forest;

import java.util.List;
import java.util.ArrayList;

public class ForestExample extends Object
{
	public static void main(String[] arguments)
	{
		List<Node> aNode = new ArrayList<Node>();
		for(int i = 0;i < 1000;i++)
		{
			aNode.add(new Node("No."+i,i));
		}
	}

}
