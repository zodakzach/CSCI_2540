package Activity14;

import java.util.*;

public class AdjacentList {

	public static void main(String[] args) {
		System.out.println("Enter the vertices: ");
		Scanner kyb = new Scanner(System.in);
		String vertices = kyb.nextLine().toUpperCase();
		String[] verticesArray = vertices.split(",");
		System.out.println("Enter the Edges: ");
		String edges = kyb.nextLine().toUpperCase();
		String[] edgesArray = edges.split(",");

		LinkedList<LinkedList<String>> Graph = new LinkedList<LinkedList<String>>();

		for (int i = 0; i < verticesArray.length; i++) {
			LinkedList<String> edgesList = new LinkedList<String>();
			edgesList.add(verticesArray[i]);
			for (int j = 0; j < edgesArray.length; j++) {
				String[] s = edgesArray[j].split("");
				if (s[0].equals(verticesArray[i])) {
					edgesList.add(s[1]);
				} else if (s[1].equals(verticesArray[i])) {
					edgesList.add(s[0]);
				}
			}
			Graph.add(edgesList);
		}

		for (int i = 0; i < Graph.size(); i++) {
			System.out.print(Graph.get(i).getFirst());
			if (Graph.get(i).size() > 1) {
				System.out.print(" -> ");
				for (int j = 1; j < Graph.get(i).size(); j++) {
					System.out.print(Graph.get(i).get(j) + ",");
				}
			}
			System.out.println();
		}
		System.out.println("End of Program");

	}

}
