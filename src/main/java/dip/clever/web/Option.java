package dip.clever.web;

public class Option extends Tag{
	public Option() {
		head = new Head() {
			public boolean selected = false;
		};
	}
}
