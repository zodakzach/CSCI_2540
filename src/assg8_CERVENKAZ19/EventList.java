package assg8_CERVENKAZ19;
import java.util.*;

/**
 * @author zachary cervenka
 * EventList class that allows you create and manage an eventList
 */

public class EventList {
	private LinkedList<Event> list;
	
	/**
	 * default constructor that initializes the linkedList
	 */
	public EventList() {
		list = new LinkedList<Event>();
	}
	
	/**
	 * @param event
	 * inserts event into list based on the time of event
	 */
	public void insert(Event event) {
		if(list.size() > 0) {
			if(list.peek().getTime() > event.getTime()) {
				Event temp = list.poll();
				list.add(event);
				list.add(temp);
			}
			else if(list.peek().getTime() == event.getTime()) {
				if (list.peek().getEvent() == 1) {
					list.add(event);
				}
				else {
					Event temp = list.poll();
					list.add(event);
					list.add(temp);
				}
			}
			else {
				list.add(event);
			}
		}
		else {
			list.add(event);
		}
	}
	
	/**
	 * removes first thing in list
	 */
	public void remove() {
		list.remove();
	}
	
	/**
	 * @return event at top of list
	 * retrieves the first thing in list
	 */
	public Event retrieve() {
		return list.peek();
	}
	
	/**
	 * @return true/false
	 * determines if the list is empty or not
	 */
	public boolean isEmpty() {
		if(list.size() > 0) {
			return false;
		}
		else {
			return true;
		}
	}
}
