package fr.eql.ai108.filemanager;

public abstract class Element {

	private String name;
	private Folder parent;

	public abstract int getSize();
	
	public void delete()
	{
		System.out.println("suppression de " + this.getName());
	}
	
	public Element(String nom) {
		super();
		this.name = nom;
	}

	public String getPath()
	{
		if (parent != null)
		{
			return parent.getPath() + "\\" + getName();
		}
		else
		{
			return getName();
		}
	}
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Folder getParent() {
		return parent;
	}

	public void setParent(Folder parent) {
		this.parent = parent;
	}
	
	
	
}
