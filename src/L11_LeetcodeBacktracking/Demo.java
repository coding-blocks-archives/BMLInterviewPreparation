package L11_LeetcodeBacktracking ;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Demo {

	public static void main(String[] args) {

		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		list.add(30);

		System.out.println(list);

		ArrayList<Integer> list1 = new ArrayList<>(list);
		// for(int i=0 ; i < list.size() ; i++) {
		// list1.add(list.get(i)) ;
		// }
		System.out.println(list1);

		ArrayList<ArrayList<Integer>> main = new ArrayList<>();

		System.out.println(main);

		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.add(10);
		temp.add(20);
		temp.add(30);

		main.add(new ArrayList<Integer>(temp));
		temp.add(40);
		main.add(new ArrayList<Integer>(temp));
		temp.add(50);
		main.add(new ArrayList<Integer>(temp));

		System.out.println(main);

		temp.remove(temp.size() - 1);
		temp.remove(temp.size() - 1);
		temp.remove(temp.size() - 1);
		temp.remove(temp.size() - 1);
		
		main.add(new ArrayList<Integer>(temp));

		System.out.println(main);

	}

}
