package application;

public class Testmetod {
	public static void main(String [] args) {
		Skadeanmälan test = new Skadeanmälan();
		Skadeanmälan test1 = new Skadeanmälan();
		Skadeanmälan test2 = new Skadeanmälan();
		Skadeanmälan test3 = new Skadeanmälan();
		SkadeRegister reg = new SkadeRegister();
		
		test.setDamageId(1);
		test1.setDamageId(4);
		test2.setDamageId(8);
		test3.setDamageId(20);
		test.setTitle("Skada på fönster");
		reg.addDamage(test);
		reg.addDamage(test2);
		reg.addDamage(test3);
		reg.addDamage(test1);
		
		System.out.println(reg.showIncoming());
	}
}
