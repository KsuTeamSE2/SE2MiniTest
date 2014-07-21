package forest;

import java.awt.event.MouseEvent;
import java.awt.Point;
import mvc.Controller;

public class ForestController extends Controller
{
	/**
	 * 
	 */
	public ForestController()
	{
		super();
	}
	
	/**
	 * 
	 * @param aMouseEvent マウスのイベント
	 */
	public void mouseClicked(MouseEvent aMouseEvent)
	{
		Point aPoint = aMouseEvent.getPoint();
		aPoint.translate(view.scrollAmount().x,view.scrollAmount().y);
		ForestModel aForestModel = (ForestModel)(this.model);
		aForestModel.mouseClicked(aPoint,aMouseEvent);
		return;
	}
	public void mouseDragged(MouseEvent aMouseEvent)
	{
		super.mouseDragged(aMouseEvent);
		return;
		
	}

}
