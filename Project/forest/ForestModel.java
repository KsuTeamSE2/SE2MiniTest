package forest;

import java.awt.event.MouseEvent;
import java.awt.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mvc.Model;

/**
 * フォレストモデル
 * @author YONEDA SHIGEKI
 */
public class ForestModel extends Model
{
	/**
	 *ForestクラスのインスタンスaForestを束縛する
	 *
	 */
	private Forest aForest;
	

	/**
	 * ノード位置の底辺のY座標を束縛する。
	 */
	public static int underNodeY;
	
	/**
	 * ブランチを束縛する。
	 */
	private ArrayList<Branch> branches = new ArrayList<Branch>();

	/**
	 * コンストラクタ
	 * @param aForest
	 * @param branches
	 */
	public ForestModel(Forest aForest,ArrayList<Branch> branches)
	{
		super();
		this.aForest = aForest;
		this.branches=branches;
	}
	
	/**
	 * Forestを応答する。
	 * @return
	 */
	public Forest getForest(){
		return aForest;
	}
	/**
	 * Branchを応答する。
	 * @return
	 */
	public ArrayList<Branch> getBranches(){
		return branches;
	}
	/**
	 * マウスをクリックした場所にノードが有るならそのノードの名前を出力する
	 * @param aPoint
	 * @param aMouseEvent
	 */
	public void mouseClicked(Point aPoint , MouseEvent aMouseEvent)
	{
		ArrayList<Tree> trees = aForest.getTrees();
		Iterator<Tree> iterator = trees.iterator();
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
	/**
	 * それぞれの親、子ノードに従って正しい場所に再帰的に配置する
	 * 指定秒ごとにノードを移動させる
	 * @param aRoot
	 * @param aPoint
	 */
	public void arrange(Node aRoot , Point aPoint){
		if(aRoot.getVisiting()==false) aRoot.setLocation(aPoint);
		try {
			Thread.sleep(Constans.SLEEP_TIME);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		this.changed();
		
		int aChildY=aPoint.y;
		int aCount=0;
		for(Node aChildNode : aRoot.getChildrenNode().values()){
			while(aChildY<=ForestModel.underNodeY) aChildY+=18;
			arrange(aChildNode,new Point(aPoint.x+aRoot.getWidth()+Constans.WIDTH_SPACE,aChildY));
			aChildNode.setVisiting();
			aCount++;
			if(aRoot.getChildrenNode().size()<aCount){
				aChildY+=Constans.HEIGHT_SPACE+aRoot.getHeight();
			}
		}
		if(ForestModel.underNodeY<aChildY) ForestModel.underNodeY=aChildY;
		if(aRoot.getVisiting()==false) aRoot.setLocation(aPoint.x,(aChildY+aPoint.y+aRoot.getHeight())/2-(aRoot.getHeight()/2));
		if(aRoot.getParentNode()==null && aRoot.getChildrenNode().size()==1) aRoot.setLocation(aPoint.x,aRoot.getChildrenNode().get(0).getLocation().y);
	}
}
