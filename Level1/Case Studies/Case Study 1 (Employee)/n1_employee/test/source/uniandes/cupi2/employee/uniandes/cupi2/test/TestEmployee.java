package uniandes.cupi2.test;
import uniandes.cupi2.employee.world.Employee;
import uniandes.cupi2.employee.world.DateInfo;


public class TestEmployee{
	public static void main(String[] args) {

		// Create test employees
		Employee employee1 = new Employee();
		Employee employee2 = new Employee();
		Employee employee3 = new Employee();

		// Create test
		DateInfo birthday1 = new DateInfo(10,7,1993);
		DateInfo entryDate1 = new DateInfo(13,8,2017);

		DateInfo birthday2 = new DateInfo(11,8,1999);
		DateInfo entryDate2 = new DateInfo(12,11,2010);

		DateInfo birthday3 = new DateInfo(1,1,1988);
		DateInfo entryDate3 = new DateInfo(28,5,2002);

		employee1.changeEmployee("Juan", "Gomez",0,birthday1, entryDate1,3500000,"employee1.png",
								 1,2);
		employee2.changeEmployee("Alex", "Rodriguez",0,birthday2,entryDate2,9500000,"employee2"
				+ ".jpg",3,4);
		employee3.changeEmployee("Kylie", "Jenner",1,birthday3,entryDate3,35000000,"employee1"
				+ ".png",5,4);

		employee1.printEmployee();
		System.out.println("\n");

		employee2.printEmployee();
		System.out.println("\n");

		employee3.printEmployee();
		System.out.println("\n");




	}
}

