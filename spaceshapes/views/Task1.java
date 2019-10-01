package spaceshapes.views;



import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

import spaceshapes.CarrierShape;
import spaceshapes.Shape;
import spaceshapes.ShapeModel;



public class Task1 implements TreeModel {

	protected ShapeModel _adaptee;

	protected List <TreeModelListener> listener = new ArrayList <TreeModelListener>();

	public Task1(ShapeModel shapeModel) {
		_adaptee = shapeModel;
	}

	@Override
	public void addTreeModelListener(TreeModelListener arg0) {
		listener.add(arg0);

	}

	@Override
	public Object getChild(Object arg0, int arg1) {
		if (arg0 instanceof CarrierShape) {
			CarrierShape carrierShape = (CarrierShape) arg0;
			if ((arg1 < carrierShape.shapeCount()) && (arg1 >= 0))
				return carrierShape.shapeAt(arg1);
		}
		return null;
	}

	@Override
	public int getChildCount(Object arg0) {
		if (arg0 instanceof CarrierShape) {
			CarrierShape carrierShape = (CarrierShape) arg0;
			return carrierShape.shapeCount();
		} 
		else {
			return 0;
		}
	}

	@Override
	public int getIndexOfChild(Object arg0, Object arg1) {
		if ((arg0 instanceof CarrierShape) && (arg1 instanceof Shape)) {
			CarrierShape carrierShape = (CarrierShape) arg0;
			Shape shape = (Shape) arg1;
			if (carrierShape.contains(shape)) {
				return carrierShape.indexOf(shape);
			}
			else {
				return -1;
			}
		}
		else {
			return -1;
		}
	}

	@Override
	public Object getRoot() {
		return _adaptee.root();

	}

	@Override
	public boolean isLeaf(Object arg0) {
		if (arg0 instanceof CarrierShape) {
			return false;
		}
		else {
			return true;
		}
	}

	@Override
	public void removeTreeModelListener(TreeModelListener arg0) {
		listener.remove(arg0);

	}

	@Override
	public void valueForPathChanged(TreePath arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

}
