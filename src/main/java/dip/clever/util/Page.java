package dip.clever.util;

public class Page{
	private static final int COUNT = 3;
	public static int SIZE = 3;
	private int totalPages;
	private int startNumber;
	private int endNumber;
	private int number;
	
	public Page(int count, int num) {
		number = 1;
		
		if(count == 0) {
			totalPages = startNumber = endNumber = 0;
		}
		else {
			totalPages = (count - 1) / SIZE + 1;
			if(num > 0 )	
				number = num < totalPages ? num : totalPages;
			
			setPageNumber();
		}
	}
	
	private void setPageNumber() {
		startNumber = (number - 1) / COUNT * COUNT + 1;
		endNumber= (totalPages > startNumber + COUNT - 1) ? startNumber + COUNT - 1 : totalPages;
	}
	
	public int getNumber() {
		return number;
	}
	
	public int getStartNumber() {
		return startNumber;
	}
	
	public int getEndNumber() {
		return endNumber;
	}
	
	public int getTotalPages() {
		return totalPages;
	}
	
	public boolean isFirst() {
		return number <= COUNT;
	}
	
	public boolean isLast() {
		return startNumber > totalPages - COUNT; 
	}
}