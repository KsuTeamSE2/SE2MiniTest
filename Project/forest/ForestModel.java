package forest;

import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.JFrame;

import mvc.Model;

/**
 * フォレストモデル
 * @author YONEDA shigeki
 *
 */
public class ForestModel extends Model
{
	/**
	 *ForestクラスのインスタンスaForestを束縛する
	 *
	 */
	private Forest aForest;
	
	private ArrayList<Branch> branches = new ArrayList<Branch>();

	public ForestModel(Forest aForest,ArrayList<Branch> branches)
	{
		super();
		this.aForest = aForest;
		this.branches=branches;
		int y = 0;
	}
	public Forest getForest(){
		return aForest;
	}
	public ArrayList<Branch> getBranches(){
		return branches;
	}
	public void mouseClicked(Point aPoint , MouseEvent aMouseEvent)
	{
		ArrayList<Tree> trees = aForest.getTrees();
		Iterator iterator = trees.iterator();
		while(iterator.hasNext()){
			Tree aTree = (Tree)iterator.next();
			HashMap<Integer,Node> nodes=aTree.getNodes();
			for(Node aNode:nodes.values()){
				if(aNode.getLocation().x <= aPoint.x && aNode.getLocation().x+aNode.getWidth()>=aPoint.x&&aNode.getLocation().y<=aPoint.y&&aNode.getLocation().y+aNode.getHeight()>=aPoint.y){
					System.out.println(aNode.getNodeName());
				}
				
			}
		}
	}
}
