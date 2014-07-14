package forest;

import java.util.ArrayList;

/**
 * 木のクラス
 * @author TOKUUME Shinya
 *
 */
public class Tree
{
	
	/**
	 * この木のルート(根)
	 */
	private Root aRoot;
	
	private ArrayList<Branch> branches = new ArrayList<Branch>();
	
	
	/**
	 * コンストラクタ
	 * @param aRoot この木のルート(根)
	 */
	public Tree(Root aRoot)
	{
		this.aRoot = aRoot;
	}

	/**
	 * ルートのゲッター
	 * @return aRoot
	 */
	public Root getRoot()
	{
		return aRoot;
	}
	
	
	/**
	 * この木構造を枝から形成していく
	 * @param aBranch 枝の情報
	 */
	public void createTree(Branch aBranch)
	{
		branches.add(aBranch);
	}
	
}
