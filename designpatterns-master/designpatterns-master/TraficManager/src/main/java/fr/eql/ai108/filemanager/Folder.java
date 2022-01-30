package fr.eql.ai108.filemanager;

import java.util.ArrayList;
import java.util.List;

public class Folder extends Element {

	private List<Element> children = new ArrayList<Element>();
	
	public Folder(String nom) {
		super(nom);
	}

	@Override
	public void delete() {
		// je supprime les enfants :
		for(Element child : children)
		{
			child.delete();
		}
		// je me supprime moi-même :
		super.delete();
	}
	
	public void addChild(Element element)
	{
		this.children.add(element);
		element.setParent(this);
	}

	@Override
	public int getSize() {
		int size = 0;
		
		for(Element child : children) {
			size += child.getSize();
		}
		
		return size;
	}
	
	
}
