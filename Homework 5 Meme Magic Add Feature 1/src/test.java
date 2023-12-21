
public class test {

	public static void main(String[] args) {

		BackgroundImage b = new BackgroundImage("city.png","city","New Delhi, India");
		
		BackgroundImage b1 = new BackgroundImage("sand.png","beach","Goa, India");
		
		System.out.println(b.toString());
		System.out.println(b1.toString());
		System.out.println(b.equals(b1));
		System.out.println(b.equals(b));
		
		User user1 = new User();
		User user2 = new User();
		
		User user3 = new User("sahilkhanna");
		User user4 = new User("sk5xvh");
		
		System.out.println(user3.toString());
		System.out.println(user4.toString());
		System.out.println(user3.equals(user4));
		System.out.println(user3.equals(user3));
		
		Feed F = new Feed();
		Feed F1 = new Feed();
		System.out.println(F.getNewMeme(user1));
		System.out.println(F1.getNewMeme(user2));
//		Rating r3 = new Rating(user3,1);
//		Rating r4 = new Rating(user4,0);
		
		
		
		Meme m = new Meme(b , "Image of Joquain Phoenix in his role as Joker, laughing maniacally", user1);
		Meme m1 = new Meme(b1 , "Leonardo DiCaprio raising a glass of wine", user2);
		
		user3.rateMeme(m, 0);
		user4.rateMeme(m1, 1);
		
		user1.rateNextMemeFromFeed(F, 0);
		user2.rateNextMemeFromFeed(F1, 1);
		
		System.out.println(user1.createMeme(b, "Hello"));
		System.out.println(user2.createMeme(b1, "Goodbye"));
		
		user1.deleteMeme(m);
		user2.deleteMeme(m1);
		
		user1.shareMeme(m, F);
		user2.shareMeme(m1,F1);
		
		System.out.println(user1.calculateReputation());
		System.out.println(user2.calculateReputation());
		
		System.out.println(m.toString());
		System.out.println(m1.toString());
		System.out.println(m.equals(m1));
		System.out.println(m.equals(m));
		
		
		
		Rating r = new Rating(user1, 1);
		Rating r1 = new Rating(user2, 0);
		
		System.out.println(r.toString());
		System.out.println(r1.toString());
		System.out.println(r.equals(r1));
		System.out.println(r.equals(r));
		

		System.out.println(m.calculateOverallRating());
		System.out.println(m1.calculateOverallRating());
		
		System.out.println(m.addRating(r));
		System.out.println(m1.addRating(r1));
		
		System.out.println(m.setCaptionVerticalAlign("bottom"));
		System.out.println(m1.setCaptionVerticalAlign("top"));
		
		
		System.out.println(r.setScore(1));
		System.out.println(r.setScore(0));
		
		System.out.println(b.compareTo(b1));
		System.out.println(b1.compareTo(b));
		
		
		System.out.println(m.compareTo(m1));
		System.out.println(m1.compareTo(m));
		
		System.out.println(user1.compareTo(user2));
		System.out.println(user3.compareTo(user2));
		
		
		CompareMemeByRating c = new CompareMemeByRating();
		CompareMemeByRating c1 = new CompareMemeByRating();
		
		CompareMemeByCreator c2 = new CompareMemeByCreator();
		CompareMemeByCreator  c3= new CompareMemeByCreator();
		
		
		System.out.println(c.compare(m, m1));
		System.out.println(c1.compare(m1,m1));
		
		

		System.out.println(c2.compare(m, m1));
		System.out.println(c3.compare(m1,m1));
		
		OrderableFeed f = new OrderableFeed();
		OrderableFeed f1 = new OrderableFeed();

		f.sortByCaption();
		f1.sortByCaption();
		
		f.sortByCreator();
		f1.sortByCreator();
		
		f.sortByRating();
		f1.sortByRating();
		
		
		System.out.println(f.getNewMeme(user1));
		System.out.println(f.getNewMeme(user2));
		
		
	}

}
