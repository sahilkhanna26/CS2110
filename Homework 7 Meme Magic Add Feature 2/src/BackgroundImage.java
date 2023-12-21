// Homework 3
//Sahil Khanna, sk5xvh
//Sources: TA, Lab, Cohort,Dhruv Patro


public class BackgroundImage implements Comparable<BackgroundImage> {

	private String imageFileName; 
	private String title;
	private String description;

	
	public BackgroundImage() {
		this.imageFileName = "";
		this.title = "";
		this.description = "";
		
	}
	
	public BackgroundImage(String imageFileName, String title, String description) {
		this.imageFileName = imageFileName;
		this.title = title;
		this.description = description;
		
	}
	
	@Override
	public String toString() {
		return title + " <" + description + ">";
	}
	
	@Override  
	public boolean equals(Object object) {
		if (object == null) { 
			return false;
		}
		if (object instanceof BackgroundImage) {
			BackgroundImage b = (BackgroundImage) object ;
		
			if (this.imageFileName.equals(b.imageFileName) && this.description.equals(b.description) && this.title.equals(b.title)){
			return true;
			}
		}
	
		return false;
		
	}
	
	
	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String imageFileName) {
		this.imageFileName = imageFileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int compareTo(BackgroundImage o) {
		int returnValue = this.imageFileName.compareTo(o.imageFileName);
		
		if (returnValue != 0) return returnValue;
		
		returnValue = this.title.compareTo(o.title);
		
		if (returnValue != 0) return returnValue;
		
		returnValue = this.description.compareTo(o.description);
		
		return returnValue;
		
	}

	
	

}


