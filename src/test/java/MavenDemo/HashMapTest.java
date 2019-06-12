package MavenDemo;

import java.util.HashMap;
import java.util.WeakHashMap;

import org.apache.poi.ss.formula.functions.Value;
import org.quartz.utils.Key;

public class HashMapTest {

	
	public static void main(String args[]) {
		HashMap map = new HashMap();
		employee e1= new employee(1001,"shubham");
		employee e2= new employee(1002,"gupta");
		employee e3= new employee(1001,"shubham");
		
		map.put(1, e1);
		map.put(2, e2);
		map.put(1, e3);
		
		
		System.out.println(e1);
		
		
	/*	HashMap m1 = new HashMap();
		HashMap m = new HashMap();
		Temp t= new Temp();
		m1.put(t, "shub");
		System.out.println(m1);
		t=null;
		System.gc();
		System.out.println(m1);
		m.put(1, "shubham");
		m.put(2,"shubham");
		m.put("shubha", "gupta");
		m.put("shubha", "shubham");
		
		System.out.println(m);
		
	    System.out.println(".............................................");*/
	}
	
}
class Temp{
	public String toString(){
		return "temp";
		
	}
}
