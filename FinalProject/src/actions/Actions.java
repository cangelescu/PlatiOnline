
package actions;

import java.io.Serializable;

public class Actions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 855550229061605138L;

	public int value;

	public static final int registerUser = 0;
	public static final int loginUser = 1;
	public static final int addMoney = 2;
	public static final int retreiveOffers = 3;

	public Actions(int arg) {
		this.value = arg;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + value;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Actions other = (Actions) obj;
		if (value != other.value)
			return false;
		return true;
	}
}