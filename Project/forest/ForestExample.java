package forest;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.Point;
import java.io.File;

import javax.swing.JFileChooser;

import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.FileReader;
import java.lang.NullPointerException;
import java.util.HashMap;

/**
 *実行を行う部分
 *@author TOKUUME Shinya
 */

public class ForestExample extends Object
{

	/**
	 *ノードの全情報
	 */
	public static HashMap<Integer,Node> nodes = new HashMap<Integer,Node>();
	/**
	 *枝の全情報
	 */
	public static ArrayList<Branch> branches = new ArrayList<Branch>();
	/**
	 *根の全情報
	 */
	public static ArrayList<Root> roots = new ArrayList<Root>();
	/**
	 *森の情報
	 */
	public static Forest aForest = new Forest();

	/**
	 * クラス群を実行する
	 * @param arguments コマンドライン引数
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
			HashMap<Integer,Node> children = aTree.createTreeRoot();
			if(children != null)
			{
				for(Node aNode : children.values())
				{
					ForestExample.createTree(aNode,aTree);
				}
			}
		}
		for(Tree aTree : trees)
		{
			aForest.addTree(aTree);
		}
		ForestModel aModel = new ForestModel(aForest);
		ForestView aView = new ForestView(aModel, new ForestController());
//		JPanel aPanel = new JPanel();
//		aPanel.add(aView);
		open(aView);
	}
	/**
	 * mvcを開く
	 * @param aPanel JPanel
	 */
	public static void open(ForestView aView){
			JFrame aWindow = new JFrame("Forest");
			aWindow.getContentPane().add(aView);
			aWindow.setLayout(null);
			aWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			aWindow.addNotify();
			int titleBarHeight = aWindow.getInsets().top;
			aWindow.getContentPane().setBackground(new Color(255,255,255));
			aWindow.setMinimumSize(new Dimension(Constans.WINDOW_WIDTH, Constans.WINDOW_HEIGHT + titleBarHeight));
			aWindow.setResizable(true);
			aWindow.setSize(800, 400 + titleBarHeight);
			aWindow.setLocation(0, 0);
			aWindow.setVisible(true);
			aWindow.toFront();
			return;
	}

	/**
	 * テキストファイルを読み込む
	 * @return text
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
		else if(selected == JFileChooser.CANCEL_OPTION)
		{
			System.out.println("キャンセルされました");
		}
		else if(selected == JFileChooser.ERROR_OPTION)
		{
			System.out.println("エラーまたは取り消しがありました");
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
			System.err.println("ファイルの指定されていないもしくは見つかりませんでした");

		}
		catch(NullPointerException error)
		{
			System.err.println("ファイルの指定されていないもしくは見つかりませんでした");
		}
		catch(IOException error)
		{
			System.err.println("予期せぬエラーが発生しました");
		}
		finally
		{
			try
			{
				aBufferedReader.close();
				aFileReader.close();
			}
			catch(IOException error)
			{
				error.printStackTrace();
			}
		}
		return texts;
	}

	/**
	 * 枝の情報を読み込む
	 * ArrayListを返した方がいいと思われ
	 * @param texts 入力した文章
	 * @return branches
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
	 * @param nodes 全ノード
	 * @return roots
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
	 * @param texts 入力された文章
	 * @param  branches 枝の情報
	 * @return nodes
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
		int y=0;
		for(String aString : strings)
		{
			String[] nodeStrings = aString.split(",.");
			Node aNode = new Node(nodeStrings[1],Integer.parseInt(nodeStrings[0]));
			aNode.setLocation(0,y);
			y+=aNode.getSize().height+Constans.HEIGHT_SPACE;
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
	/**
	 *木構造を組み立てる際のノード
	 *木のクラスに再帰的に子ノードの深さを設定する.
	 *@param aNode ノード
	 *@param aTree ノード格納される予定の木
	 */
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
