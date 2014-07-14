package forest;

import java.awt.Point;

public class ForestView extends mvc.View
{
	/**
	 * 木構造のモデル
	 */
	private ForestModel aForestModel;
	/**
	 * コンストラクタ
	 * @param aModel モデル
	 */
	public ForestView(ForestModel aModel)
	{
		super(aModel);
	}
	
	/**
	 * 
	 */
	public void paintComponet(){}
	
	/**
	 * 
	 */
	public void update(){}
	
	
	/**
	 * 
	 * @return Point
	 */
	public Point getPoint(){return null;}

	/**
	 * 
	 */
	public Point getNewPoint(){return null;}
}

