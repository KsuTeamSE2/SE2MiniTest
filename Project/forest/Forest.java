package forest;

import java.util.ArrayList;
import java.util.List;

/**
 * 木構造をまとめた森クラス
 * @author TOKUUME Shinya
 */
public class Forest
{
	/**
	 * 木構造の集まり
	 */
	private ArrayList<Tree> trees = new ArrayList<Tree>();
	
	/**
	 * コンストラクタ
	 * 何もしません
	 */
	public Forest(){}
	
	/**
	 * 木構造の集まりを返すゲッター
	 * @return trees
	 */
	public ArrayList<Tree> getTrees()
	{
		return trees;
	}
	
	/**
	 * 木構造を追加するメソッド
	 * @param aTree 木構造
	 */
	public void addTree(Tree aTree)
	{
	    trees.add(aTree);
	}
}
