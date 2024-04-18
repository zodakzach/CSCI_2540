package assg8_CERVENKAZ19;
/**
 * @author zachary cervenka
 * Event class that allows you to create departure or arrival events
 */

public class Event implements Comparable<Event> {
	
	private char event;
	private int departTime, arrivalTime, transactionTime, time;
	
	/**
	 * @param event, departTime
	 */
	public Event(char event, int departTime) {
		this.event = Character.toUpperCase(event);
		this.departTime = departTime;
		time = departTime;
	}
	
	/**
	 * @param event, arrivalTime, transactionTime
	 */
	public Event(char event, int arrivalTime, int transactionTime) {
		this.event = Character.toUpperCase(event);
		this.arrivalTime = arrivalTime;
		this.transactionTime = transactionTime;
		time = arrivalTime;
	}
	
	/**
	 * @return event
	 */
	public char getEvent() {
		return event;
	}
	
	/**
	 * @return time
	 */
	public int getTime() {
		return time;
	}
	
	/**
	 * @return departTime
	 */
	public int getDepartTime() {
		return departTime;
	}
	
	/**
	 * @return arrivalTime
	 */
	public int getArrivalTime() {
		return arrivalTime;
	}
	
	/**
	 * @return transactionTime
	 */
	public int getTransactionTime() {
		return transactionTime;
	}
	
	/**
	 * @return (event, departTime) / (event,arrivalTime, transactionTime
	 */
	public String toString() {
		if(eventType() == 0) {
		return "(" + event + ", " + departTime + ")";
		}
		else {
			return "(" + event + ", " + arrivalTime + ", "+ transactionTime + ")";
		}
	}
	
	@Override
	/**
	 * @param event
	 * @return 1, 0, -1
	 */
	public int compareTo(Event event) {
		if(this.time > event.time) {
			return 1;
		}
		else if(this.time == event.time) {
			return 0;
		}
		else {
			return -1;
		}
	}
	
	/**
	 * @return 0, 1, 2
	 */
	public int eventType() {
		if(event == 'D') {
			return 0;
		}
		else if(event == 'A') {
			return 1;
		}
		else {
			return 2;
		}
	}

}
