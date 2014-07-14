package forest;

import javax.swing.JFileChooser;
import java.util.ArrayList;
import java.awt.Panel;

public class ForestExample extends Object
{
	/**
	 * 可視的にファイルを選択するための
	 * FileChooser
	 */
	private JFileChooser aFileChooser = new JFileChooser();
	/**
	 * 読み込んだ文字列を記憶させる
	 */
	private ArrayList<String> texts = new ArrayList<String>();
	/**
	 * クラス群を実行する
	 * @param arguments
	 */
	public static void main(String[] arguments)
	{
		
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
	private ArrayList<String> loadFile(){return null;}
	/**
	 * 枝の情報を読み込む
	 * ArrayListを返した方がいいと思われ
	 * @param texts
	 * @return
	 */
	private ArrayList<String> loadBranch(ArrayList<String> texts){return null;}
	/**
	 * 根の情報を読み込む
	 * 不必要な可能性あり
	 * @param texts
	 * @return
	 */
	private ArrayList<String> loadRoot(ArrayList<String> texts){return null;}
	/**
	 * ノード情報を読み込む
	 * @param texts
	 * @return
	 */
	private ArrayList<String> loadNode(ArrayList<String> texts){return null;}

}
