package forest;

public class Branch
{
	/**
	 * 親のノード番号
	 */
	int parentNumber;

	/**
	 * 子のノード番号
	 */
	int childNumber;

	/**
	 * ブランチの情報を受取代入
	 *スプリットで分ける。
	 * @param aString 枝の番号の情報
	 */
	public Branch(String aString)
	{
		String[] branchInfo = new String[2];
		branchInfo = aString.split(",.");
		parentNumber = Integer.valueOf(branchInfo[0]);
		childNumber = Integer.valueOf(branchInfo[1]);
	}

	/**
	 *親のノード番号をかえす
	 * @return parentNumber
	 */
	public int getParentNumber()
	{
		return parentNumber-1;
	}

	/**
	 * 子のノード番号をかえす
	 * @return childNumber
	 */
	public int getChildNumber()
	{
		return childNumber-1;
	}

}
