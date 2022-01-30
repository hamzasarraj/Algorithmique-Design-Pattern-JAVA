package fr.eql.ai108.filemanager;

public class Shortcut extends File{

	private Element target;
	
	public Shortcut(String name, Element target) {
		super(name, "lnk");
		this.target = target;
	}
	
	@Override
	public String getName() {
		return super.getName() + " cible : " + target.getPath();
	}

}
