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



public class ForestExample extends Object
{
	/**
	 * クラス群を実行する
	 * @param arguments
	 */
	public static void main(String[] arguments)
	{
		ArrayList<Node> nodes = new ArrayList<Node>();
		ArrayList<Branch> branches = new ArrayList<Branch>();
		ArrayList<Root> roots = new ArrayList<Root>();
		ArrayList<String> texts = ForestExample.loadFile();
		//ファイルからテキスト群を読み込み
		
		//読み込んだテキストからノード生成
		nodes = ForestExample.loadNode(texts);
		//読み込んだテキストからブランチを生成
		branches = ForestExample.loadBranch(texts);
		//ルートの設定
		roots = ForestExample.loadRoot(texts,nodes);
		for(Root aRoot : roots)
		{
			System.out.println(aRoot.getNodeNumber());
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
	private static ArrayList<Root> loadRoot(ArrayList<String> texts,ArrayList<Node> nodes)
	{
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<Node> candidacyNodes = new ArrayList<Node>();
		ArrayList<Root> roots = new ArrayList<Root>();
		for(String aString : texts)
		{
			if(aString.matches("^[A-Za-z1-9].*[^:]$"))
			{
				strings.add(aString);
			}
			else if(aString.equals("nodes:"))
			{
				break;
			}
		}
		for(String aString : strings)
		{
			for(Node aNode : nodes)
			{
				if(aString.equals(aNode.getNodeName()) && candidacyNodes.isEmpty())
				{
					candidacyNodes.add(new Node(aNode));
				}
				else if(aString.equals(aNode.getNodeName()) && ))
				{
					candidacyNodes.add(new Node(aNode));

				}
				else if(candidacyNodes.contains(aNode))
				{
					System.out.println("NodeName:"+aNode.getNodeName()+"NodeNumber"+aNode.getNodeNumber());
				}
			}
			
		}
		for(int aNumber: candidacyNodes)
		{
			roots.add(new Root(aNode));
		}


		return roots;

	}
	
	/**
	 * ノード情報を読み込む
	 * @param texts
	 * @return
	 */
	private static ArrayList<Node> loadNode(ArrayList<String> texts)
	{
		ArrayList<String> strings = new ArrayList<String>();
		ArrayList<Node> nodes = new ArrayList<Node>();
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
			nodes.add(aNode);
		}
		return nodes;
	}

}
