package MavenDemo;

import java.util.HashMap;
import java.util.HashSet;

public class hashsetDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		HashSet<employee> hashset = new HashSet<>();
		
	
		employee emp1= new employee(1001, "shubham");
		employee emp2= new employee(1001, "gupta");
		employee emp3= new employee(1002, "shubham");
		employee emp4= new employee(1001, null);
		employee emp5= new employee(1001, null);
		
		hashset.add(emp1);
		hashset.add(emp2);
		
		hashset.add(emp3);
		hashset.add(emp4);
		hashset.add(emp5);
		
		System.out.println("  Result ="+emp1.equals(emp4));
		
		System.out.println("hascode value "+emp1.hashCode());
		System.out.println("hascode value "+emp2.hashCode());
		System.out.println("hascode value "+emp3.hashCode());
		System.out.println("hascode value "+emp4.hashCode());
		
		
		
		for(employee emp: hashset) {
			System.out.println("value ="+emp);
		}
		
	/*	
		String s1 =new String("Puma");
		String s2 = new String("Puma");
		//System.out.println(s1.equals(s2));
		//System.out.println(s1==s2);
				
		employee e1=new employee(101, "shubham");
		employee e2= new employee(101,"shubham");
		System.out.println(e1.equals(e2));
		System.out.println(e1==e2);
		*/
	
		HashSet hashset1 = new HashSet<>();
		hashset1.add(11);
		hashset1.add(2);
		hashset1.add(21);
		hashset1.add(21);
		hashset1.add(3);
		hashset1.add("shubham");
		hashset1.add("shubham");
		
		System.out.println("Value ="+hashset1);
		
	}

}
