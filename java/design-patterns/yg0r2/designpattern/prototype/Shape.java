/**
 * 
 */
package yg0r2.designpattern.prototype;

/**
 * @author Yg0R2
 */
public abstract class Shape implements Cloneable {

	private String _id;

	protected String type;

	public Object clone() {
		Object clone = null;

		try {
			clone = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}

		return clone;
	}

	public abstract void draw();

	public String getId() {
		return _id;
	}

	public String getType() {
		return type;
	}

	public void setId(String id) {
		_id = id;
	}

}