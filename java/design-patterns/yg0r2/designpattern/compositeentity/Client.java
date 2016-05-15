/**
 * 
 */
package yg0r2.designpattern.compositeentity;

/**
 * @author Yg0R2
 */
public class Client {

	private CompositeEntity _compositeEntity = new CompositeEntity();

	public void printData() {
		String[] dataArray = _compositeEntity.getData();

		for(int i = 0; i < dataArray.length; i++) {
			System.out.println("Data: " + dataArray[i]);
		}
	}

	public void setData(String data1, String data2) {
		_compositeEntity.setData(data1, data2);
	}

}