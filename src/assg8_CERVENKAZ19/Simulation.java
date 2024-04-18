package assg8_CERVENKAZ19;
import java.io.*;
import java.util.*;

/**
 * @author zachary cervenka
 * simulation class that simulates a bank tellers average day in a bank an calculates the average wait time for each 
 * customer that goes in the bank
 */

public class Simulation {
	
	private static Scanner s = null;
	private static int time, wait;
	private static double customers;
	
	public static void main(String [] args) {
		Queue<Event> bankQueue = new LinkedList<Event>();
		EventList list = new EventList();
		File file = new File("assg8_input.txt");
		try {
			s = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		if(s.hasNextLine()) {
			StringTokenizer s1 = new StringTokenizer(s.nextLine(), "\t");
			
			if(s1.hasMoreTokens()) {
				try {
					int temp = (Integer.valueOf(s1.nextToken()));
					int temp1 = (Integer.valueOf(s1.nextToken()));
					list.insert(new Event('A', temp, temp1));
				}
				catch(NumberFormatException e) {
					System.out.println(e.getMessage());
				}
			}
		}
		System.out.println("Simulation Begins");
		
		while(!list.isEmpty()) {
			if(list.retrieve().eventType() == 1) {
				processArrival(list.retrieve(), list, bankQueue);
			}
			else {
				processDeparture(list.retrieve(), list, bankQueue);
			}
		}
		
		System.out.println("End of Simulation");
		System.out.println("\nFinal Statistics:");
		System.out.print("Final number of people processed: ");
		System.out.println(customers);
		System.out.print("Average of time spent waiting: ");
		double avg = wait/customers;
		System.out.println(avg);	
	}
	
	/**
	 * @param event, list, bankQueue
	 */
	public static void processArrival(Event arrival, EventList list, Queue<Event> bankQueue) {
		System.out.print("Processing an arrival event at time: ");
		System.out.println(arrival.getArrivalTime());
		customers++;
		time = arrival.getArrivalTime();
		bankQueue.add(arrival);
		list.remove();
		if(bankQueue.peek() == arrival) {
			list.insert(new Event('D', time + arrival.getTransactionTime()));
		}
		if(s.hasNextLine()) {
			StringTokenizer s1 = new StringTokenizer(s.nextLine(), "\t");
			
			if(s1.hasMoreTokens()) {
				try {
					int temp2 = (Integer.valueOf(s1.nextToken()));
					int temp3 = (Integer.valueOf(s1.nextToken()));
					list.insert(new Event('A', temp2, temp3));
				}
				catch(NumberFormatException e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	
	/**
	 * @param event, list, bankQueue
	 */
	public static void processDeparture(Event depart, EventList list, Queue<Event> bankQueue) {
		System.out.print("Processing a departure event at: ");
		System.out.println(depart.getTime());
		time = depart.getTime();
		bankQueue.remove();
		list.remove();
		if(!bankQueue.isEmpty()) {
			list.insert(new Event('D', time + bankQueue.peek().getTransactionTime()));
			wait = wait + time - bankQueue.peek().getTime();
		}
	}
}
