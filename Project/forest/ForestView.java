package forest;

import java.awt.Point;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import mvc.View;


public class ForestView extends View
{
	/**
	 * コンストラクタ
	 * @param aModel モデル
	 * @author YONEDA shigeki
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
	public void paintComponent(Graphics aGraphics)
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
		Forest aForest= aForestModel.getForest();
		ArrayList<Tree> trees = aForest.getTrees();
		Iterator iterator = trees.iterator();
		while(iterator.hasNext()){
			Tree aTree = (Tree)iterator.next();
			HashMap<Integer,Node> nodes=aTree.getNodes();
			for(Node aNode:nodes.values()){
				Point aPoint = aNode.getLocation();
				Dimension aDimension = aNode.getSize();
				aGraphicsBuffer.setFont(aNode.getFont());
				aGraphicsBuffer.drawString(aNode.getNodeName(), aPoint.x+Constans.WIDTH_SPACE, aPoint.y+aNode.getSize().height-Constans.HEIGHT);
				aGraphicsBuffer.drawRect(aPoint.x,aPoint.y, aDimension.width, aDimension.height);
			}

			ArrayList<Branch> branches = aForestModel.getBranches();
			for(Branch aBranch : branches){
				int aParentNumber = aBranch.getParentNumber();
				int aChildNumber = aBranch.getChildNumber();
				if(nodes.containsKey(aParentNumber)&&nodes.containsKey(aChildNumber)){
					Point aParentPoint= nodes.get(aParentNumber).getLocation();
					Dimension aParentDimension = nodes.get(aParentNumber).getSize();
					Point aChildPoint = nodes.get(aChildNumber).getLocation();
					Dimension aChildDimension = nodes.get(aChildNumber).getSize();
					aGraphicsBuffer.drawLine(aParentPoint.x+aParentDimension.width, aParentPoint.y+aParentDimension.height/2, aChildPoint.x, aChildPoint.y+aChildDimension.height/2);
				}

			}
		}
		Point aPoint = this.scrollAmount();
		aGraphics.drawImage(picture,0-aPoint.x,0-aPoint.y,this);
	}

	/**
	 * 
	 */
	public void update(){

	}


	/**
	 * 
	 * @return Point
	 */
	public Point getPoint(){
		return null;
	}

	/**
	 * @return Point
	 */
	public Point getNewPoint(){
		return null;
	}
}

