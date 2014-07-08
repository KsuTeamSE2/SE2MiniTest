package forest;

import java.util.List;
import java.util.ArrayList;

public class ForestExample extends Object
{
	public static void main(String[] arguments)
	{
		Load aLoading = new Load();
		ArrayList<String> roots = aLoading.loadRoot();
		ArrayList<String> nodes = aLoading.loadNode();
		ArrayList<String> branches = aLoading.loadBranch();
		
	}
	
}
