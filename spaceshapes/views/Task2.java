package spaceshapes.views;


import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreePath;

import spaceshapes.ShapeModel;
import spaceshapes.ShapeModelEvent;
import spaceshapes.ShapeModelEvent.EventType;
import spaceshapes.ShapeModelListener;

public class Task2 extends Task1 implements ShapeModelListener{

	public Task2(ShapeModel model) {
		super(model);
	}
	@Override
	public void update(ShapeModelEvent event) {

		TreeModelEvent treeModelEvent = createTreeEvent(event);

		if (event.eventType().equals(EventType.ShapeAdded)) {
			for(TreeModelListener _listener : listener) {
				_listener.treeNodesInserted(treeModelEvent);
			}
		} else if (event.eventType().equals(EventType.ShapeRemoved)) {
			for(TreeModelListener _listener : listener) {
				_listener.treeNodesRemoved(treeModelEvent);
			}
		}
	}



	public TreeModelEvent createTreeEvent (ShapeModelEvent event) {

		TreePath path;
		int[] indexes = {event.index()};
		Object[] operands = {event.operand()};

		if (event.parent() == null) {
			path = null;
		} else {
			path = new TreePath(event.parent().path().toArray());
		}


		TreeModelEvent treeModelEvent = new TreeModelEvent(event.source(),path,indexes,operands);
		return treeModelEvent;

	}





}