/**
 * 
 */
package yg0r2.designpattern.compositeentity;

/**
 * @author Yg0R2
 */
public class CoarseGrainedObject {

	private DependentObject1 _do1 = new DependentObject1();
	private DependentObject2 _do2 = new DependentObject2();

	public String[] getData() {
		return new String[] {_do1.getData(), _do2.getData()};
	}

	public void setData(String data1, String data2) {
		_do1.setData(data1);
		_do2.setData(data2);
	}

}