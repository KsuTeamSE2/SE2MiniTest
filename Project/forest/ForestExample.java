package forest;

import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.awt.Panel;
import java.io.File;
import javax.swing.JFileChooser;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.lang.NullPointerException;
import java.util.HashMap;



public class ForestExample extends Object
{
	
    public static HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();
    
    public static ArrayList<Branch> branches = new ArrayList<Branch>();
    
    public static ArrayList<Root> roots = new ArrayList<Root>();
    
    public static Forest aForest = new Forest();
	
	/**
	 * クラス群を実行する
	 * @param arguments
	 */
	public static void main(String[] arguments)
	{
		
		
		//ファイルからテキスト群を読み込み
		ArrayList<String> texts = ForestExample.loadFile();
		//読み込んだテキストからブランチを生成
		branches = ForestExample.loadBranch(texts);
		//読み込んだテキストからノード生成
		nodes = ForestExample.loadNode(texts,branches);
		//ルートの設定
		roots = ForestExample.loadRoot(nodes);
		//ツリー
		ArrayList<Tree> trees = new ArrayList<Tree>();

		for(Root aRoot : roots)
		{
			trees.add(new Tree(aRoot));
		}
		for(Tree aTree : trees)
		{
		    HashMap<Integer,Node> childlen = aTree.createTreeRoot();
		    for(Node aNode : childlen.values())
			{
			    ForestExample.createTree(aNode,aTree);
			}
		}
		for(Tree aTree : trees)
		    {
			aForest.addTree(aTree);
		    }
	}
	/**
	 * mvcを開く
	 * @param aPanel
	 */
	public void open(Panel aPanel){}
	
	/**
	 * テキストファイルを読み込む
	 * @return
	 */
	private static ArrayList<String> loadFile()
	{
		ArrayList<String> texts = new ArrayList<String>();
		File aFile = null;
		BufferedReader aBufferedReader = null;
		FileReader aFileReader = null;
		JFileChooser aFileChooser = new JFileChooser();
		
		int selected = aFileChooser.showOpenDialog(null);
		if(selected == JFileChooser.APPROVE_OPTION)
		{
			 aFile = aFileChooser.getSelectedFile();
		}
		
		try
		{
			aFileReader = new FileReader(aFile);
			aBufferedReader = new BufferedReader(aFileReader);
			for(;;)
			{
				String aString = aBufferedReader.readLine();
				if(aString != null)
				{
					texts.add(aString);
				}else
				{
					break;
				}
			}


		}catch(FileNotFoundException error)
		{
			error.printStackTrace();

		}catch(NullPointerException error)
		{
			error.printStackTrace();
		}catch(IOException error)
		{
			error.printStackTrace();
		}
		finally
		{
			try
			{
				aBufferedReader.close();
				aFileReader.close();
			}catch(IOException error)
			{
				error.printStackTrace();
			}
		}
		return texts;
	}
	
	/**
	 * 枝の情報を読み込む
	 * ArrayListを返した方がいいと思われ
	 * @param texts
	 * @return
	 */
	private static ArrayList<Branch> loadBranch(ArrayList<String> texts)
	{
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<Branch> branches = new ArrayList<Branch>();
		int startLine = 0;
		for(int lineNumber = 0;lineNumber < texts.size();lineNumber++){
			String aString = texts.get(lineNumber);
			if(aString.equals("branches:")){
				startLine = lineNumber+1;
				break;
			}
		}
		for(int lineNumber = startLine;lineNumber < texts.size();lineNumber++){

			String aString = texts.get(lineNumber);
			if(aString == null){
				break;
			}else{
				strings.add(aString);
			}
		}
		for(String aString : strings)
		{
			String[] branchStrings = aString.split(",.");
			Branch aBranch = new Branch(Integer.parseInt(branchStrings[0]),Integer.parseInt(branchStrings[1]));
			branches.add(aBranch);

		}
		return branches;
	}

	
	/**
	 * 根の情報を読み込む
	 * 不必要な可能性あり
	 * @param texts
	 * @return
	 */
	private static ArrayList<Root> loadRoot(HashMap<Integer,Node> nodes)
	{
		ArrayList<Root> roots = new ArrayList<Root>();
		
		for(Node aNode : nodes.values())
		{
			if(aNode.getParentNode().isEmpty())
			{
				roots.add(new Root(aNode));
			}
		}
		return roots;
	}
	
	/**
	 * ノード情報を読み込む
	 * @param texts
	 * @return
	 */
	private static HashMap<Integer,Node> loadNode(ArrayList<String> texts,ArrayList<Branch> branches)
	{
		ArrayList<String> strings = new ArrayList<String>();
		int startLine = 0;
		for(int lineNumber = 0;;lineNumber++){
			String aString = texts.get(lineNumber);
			if(aString.equals("nodes:")){
				startLine = lineNumber+1;
				break;
			}
		}
		for(int lineNumber = startLine;;lineNumber++){
			String aString = texts.get(lineNumber);
			if(aString.equals("branches:")){
				break;
			}else{
				strings.add(aString);
			}
		}
		for(String aString : strings)
		{
			String[] nodeStrings = aString.split(",.");
			Node aNode = new Node(nodeStrings[1],Integer.parseInt(nodeStrings[0]));
			nodes.put(Integer.parseInt(nodeStrings[0]),aNode);
		}
		for(Branch aBranch : branches)
		{
			Node aParentNode = nodes.get(aBranch.getParentNumber());
			Node aChildNode = nodes.get(aBranch.getChildNumber());
			
			aParentNode.addChild(nodes.get(aBranch.getChildNumber()));
			aChildNode.addParent(nodes.get(aBranch.getParentNumber()));
			
			
			nodes.put(aBranch.getParentNumber(),aParentNode);
			nodes.put(aBranch.getChildNumber(),aChildNode);
			
		}
		
		return nodes;
	}

    private static void createTree(Node aNode,Tree aTree)
    {
	aNode.setNodeDepth(aTree.serchNodeDepth(aNode));
	nodes.put(aNode.getNodeNumber(),aNode);
	if(aNode.getChildlenNode() != null)
	    {
		for(Node aChildNode : aNode.getChildlenNode().values())
		    {
			createTree(aChildNode,aTree);
		    }
	    }else{return;}	
    }

}
