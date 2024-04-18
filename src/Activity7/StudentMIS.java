package Activity7;

public class StudentMIS {
	public static void main(String[] args) {
		StudentList list = new StudentList();
		list.loadData("assg6_data.txt");
		list.displayRoster();
	}

}
