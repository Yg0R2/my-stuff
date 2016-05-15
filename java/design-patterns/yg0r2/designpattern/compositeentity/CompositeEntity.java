/**
 * 
 */
package yg0r2.designpattern.compositeentity;

/**
 * @author Yg0R2
 */
public class CompositeEntity {

	private CoarseGrainedObject _coarseGrainedObject = new CoarseGrainedObject();

	public String[] getData() {
		return _coarseGrainedObject.getData();
	}

	public void setData(String data1, String data2) {
		_coarseGrainedObject.setData(data1, data2);
	}

}