import java.util.ArrayList;

public class Feed {

	private ArrayList<Meme> memes; 
	
	public Feed() {
		memes = new ArrayList<Meme>();
	}
	
	public Meme getNewMeme(User user) {
		for (Meme m : memes) {
			if (!(user.getMemesCreated().contains(m) || user.getMemesViewed().contains(m) )) {
				return m;
			}
		}
		return null;
	}
	
	@Override
	public String toString() {
		String output = "";
		for (Meme m : this.memes) {
			output = output + m.toString() + "\n" ;
		}
		return output;
	}

	public ArrayList<Meme> getMemes() {
		return memes;
	}

	public void setMemes(ArrayList<Meme> memes) {
		this.memes = memes;
	}
	
	
	
}
