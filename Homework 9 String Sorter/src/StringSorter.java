import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.AbstractQueue;
import java.util.ArrayDeque;

public class StringSorter {

	private LinkedList<String>[] arrOfQ;
		
	public StringSorter(){
		arrOfQ = new LinkedList[26];
		for (int i = 0; i < 26; i++) {
			arrOfQ[i] = new LinkedList<String>();
		}
	}
	
	
	private void distribute(ArrayList<String> arrOfStrings, int indexValue) {
		
		for  (int i = 0; i < arrOfStrings.size(); i++) {
			String ch = arrOfStrings.get(i).substring(indexValue, indexValue + 1) ;
			String letters = "abcdefghijklmnopqrstuvwxyz";
			int index = letters.indexOf(ch);
			arrOfQ [ index ].add(arrOfStrings.get(i));
	
		}
		
	}
	
	private ArrayList<String> collect(int X){
		StringSorter s1 = new StringSorter();
		ArrayList<String> temp = new ArrayList<String>();
		ArrayList<String> result = new ArrayList<String>();
		
		for (int i = 0; i < arrOfQ.length; i++) {
		
			
			
			if (arrOfQ[i].size() == 1) {
				String s = new String(arrOfQ[i].get(0));
				result.add(s);
			}
			
			if (arrOfQ[i].size() > 1) {
				
				for (int n = 0; n < arrOfQ[i].size(); n++) {
					String elem = arrOfQ[i].get(n);
					
					if (elem.length() > X+1) {
						temp.add(elem);
					}
					else{
						result.add(elem);
					}
					
				}
			s1.distribute(temp, X+1);
			temp = s1.collect(X+1);
			
			result.addAll(temp);
				
			

			}
		}
		return result;
	}
		
	
	public ArrayList<String> sort(ArrayList<String> a1){
		distribute(a1, 0);
		
		a1= collect(0);
		
		
		return a1;
		
	}
	

	public static void main(String[] args) {
		StringSorter s2 = new StringSorter();
		ArrayList<String> a2 = new ArrayList<String>();
		a2.add("cab");
		a2.add("abc");
		a2.add("dab");
		a2.add("ac");
		a2.add("abab");
		
		
		
		
		
		System.out.println(s2.sort(a2));
		
		



}
}
