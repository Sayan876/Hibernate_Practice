package allMixed;
import java.util.*;
public class mainClass {
    public static void main(String[] args) {
		Combined c1 = new Combined();
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("select an option");
		System.out.println("1.Fetch all the Data\n2.Insert a column\n3.Update a column\n4.Delete a column\n5.Fetch by ID");
		int op = sc.nextInt();
		switch(op) {
		case 1: c1.fetchAll();break;
		case 2: c1.insert(); break;
		case 3: c1.update();break;
		case 4: c1.delete();break;
		case 5: c1.fetchId();break;
		case 6: System.out.println("Well goodbye"); System.exit(0);
		default:System.out.println("Invalid option");
		}
		System.out.println("=====================");
		}
	}
}
