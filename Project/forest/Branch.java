package forest;


/**
 * 枝クラス
 * @author TOKUUME Shinya
 */
public class Branch
{
	/**
	 * 親のノード番号
	 */
	private int numberParent;

	/**
	 * 子のノード番号
	 */
	private int numberChild;

	/**
	 * コンスラクト
	 * 
	 * @param numberParent 親ノードの番号
	 * @param numberChild 子ノードの番号
	 */
	public Branch(int numberParent,int numberChild)
	{
		this.numberParent = numberParent;
		this.numberChild = numberChild;
	}

	/**
	 *親のノード番号をかえす
	 * @return numberParent
	 */
	public int getParentNumber()
	{
		return this.numberParent;
	}

	/**
	 * 子のノード番号をかえす
	 * @return numberChild
	 */
	public int getChildNumber()
	{
		return this.numberChild;
	}

}
