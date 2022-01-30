package fr.eql.ai108.filemanager;

public class File extends Element {

	private String extension;
	private int size;
	
	public File(String name, String extension) {
		super(name);
		this.extension = extension;
		this.size = 42;
	}
	
	@Override
	public String getName() {
		return super.getName() + "." + extension;
	}

	@Override
	public int getSize() {
		return this.size;
	}

}
