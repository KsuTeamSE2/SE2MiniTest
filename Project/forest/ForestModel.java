package forest;

import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;

import mvc.Model;

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
		
	}
}
