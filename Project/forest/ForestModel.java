package forest;

import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Point;
import java.io.IOException;
import java.io.File;
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


	public ForestModel(Forest aForest)
	{
		super();
		this.aForest = aForest;
		int y = 0;
	}
	public Forest getForest(){
		return aForest;
	}

	public void mouseClicked(Point aPoint , MouseEvent aMouseEvent)
	{
		
	}
}
