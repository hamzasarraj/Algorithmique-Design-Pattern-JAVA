package fr.eql.ai108.filemanager;

public class Demo {

	public static void main(String[] args) {

		Folder f1 = new Folder("c:");
		
		File plop = new File("plop", "txt");
		f1.addChild(plop);
		
		Folder f2 = new Folder("users");
		f1.addChild(f2);
		Folder f3 = new Folder("benoit");
		f2.addChild(f3);
		Folder f4 = new Folder("desktop");
		f3.addChild(f4);
		
		File f5 = new File("toto", "txt");
		f4.addChild(f5);
		File f6 = new File("titi", "txt");
		f4.addChild(f6);
		File f7 = new File("tutu", "txt");
		f4.addChild(f7);
		
		Shortcut s = new Shortcut("Mon Raccourci", f5);
		f4.addChild(s);
		
		System.out.println(s.getName());
		
		System.out.println(f4.getSize());
		
		System.out.println(f5.getPath());
		System.out.println(f3.getPath());
		
		f3.delete();
		
	}

}
