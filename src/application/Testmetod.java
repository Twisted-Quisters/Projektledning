package application;

public class Testmetod {
	public static void main(String [] args) {
		Skadeanmälan test = new Skadeanmälan();
		Skadeanmälan test1 = new Skadeanmälan();
		Skadeanmälan test2 = new Skadeanmälan();
		Skadeanmälan test3 = new Skadeanmälan();
		SkadeRegister reg = new SkadeRegister();
		
		test.setDamageId(1);
		test1.setDamageId(41);
		test2.setDamageId(8);
		test3.setDamageId(20);
		test.setTitle("Skada på fönster");
		test1.setTitle("Skada på stol");
		test2.setTitle("krossat fönster");
		test3.setTitle("jag vet inte!!");
		test.setPriority(1);
		test1.setPriority(3);
		test2.setPriority(1);
		test3.setPriority(1);
		test1.setStatus("Pågående");
		test2.setStatus("Pågående");
		test3.setStatus("Pågående");
		reg.addDamage(test);
		reg.addDamage(test2);
		reg.addDamage(test3);
		reg.addDamage(test1);
		
		System.out.println(reg.showOngoing());
		System.out.println(reg.showPriority3());
	}
}
