package forest;

import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import mvc.View;


public class ForestView extends View
{
	/**
	 * コンストラクタ
	 * @param aModel モデル
	 */
	public ForestView(ForestModel aModel,ForestController aController)
	{
		super(aModel , aController);
		this.model = aModel;
		this.setSize(1500,1500);
	}
	
	/**
	 * 
	 */
	public void paintComponet()
	{
		int width = this.getWidth();
		int height = this.getHeight();
		aGraphics.setColor(Color.white);
		aGraphics.fillRect(0,0,width,height);

		BufferedImage picture = (BufferedImage)this.createImage(width,height);
		Graphics aGraphicsBuffer = picture.getGraphics();
		aGraphicsBuffer.setColor(Color.white);
		aGraphicsBuffer.fillRect(0,0,width,height);
		aGraphicsBuffer.setColor(Color.black);

		ForestModel aForestModel = (ForestModel)(this.model);


	}
	
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
	 * @return Point
	 */
	public Point getNewPoint(){return null;}
}

