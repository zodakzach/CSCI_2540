package assg9_CERVENKAZ19;

/**
 * @author zachary cervenka Customer class that allows you to create a customer
 *         and give it a ID, name, PhoneNumber
 */

public class Customer extends KeyedItem<String> {
	private String name, phoneNumber;

	/**
	 * Customer Constructor assigns id, name, and phoneNumber given
	 */
	public Customer(String iD, String name, String phoneNumber) {
		super(iD);
		this.name = name;
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @returns name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param newName Set method that allows you to change name of customer
	 */
	public void setName(String newName) {
		name = newName;
	}

	/**
	 * @param newNumber Set method that allows you to change phoneNumber of customer
	 */
	public void setPhoneNumber(String newNumber) {
		phoneNumber = newNumber;
	}

	/**
	 * @return "ID name Phonenumber"
	 */
	@Override
	public String toString() {
		return getKey() + "\t" + name + "\t" + phoneNumber;
	}
}
