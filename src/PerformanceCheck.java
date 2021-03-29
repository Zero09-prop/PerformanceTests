import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class PerformanceCheck {

	public static void main(String[] args) {
		
		ArrayList<Integer> array = new ArrayList<Integer>();
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		System.out.println("ArrayList timing: \n");
		AddOperationTimeTest(array);
		GetSizeTimeTest(array);
		ContainsTimeTest(array);
		IsEmptyTimeTest(array);
		IndexOfTimeTest(array);
		GetTimeTest(array);
		SortOperationTimeTest(array);
		ToArrayTimeTest(array);
		ReplaceAllTimeTest(array);
		RemoveOperationTimeTest(array);
		ClearTimeTest(array);
		
		System.out.println("\nLinkedList timing: \n");
		AddOperationTimeTest(list);
		GetSizeTimeTest(list);
		ContainsTimeTest(list);
		IsEmptyTimeTest(list);
		IndexOfTimeTest(list);
		GetTimeTest(list);
		SortOperationTimeTest(list);
		ToArrayTimeTest(list);
		ReplaceAllTimeTest(list);
		RemoveOperationTimeTest(list);
		ClearTimeTest(list);
	}
	
	public static void AddOperationTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		for(int i = 0;i < 5000;i++) {
			collection.add(i);
		}
		long end = System.nanoTime();
		System.out.println("'Add(int i)' operation: " + (double)(end - begin)/1000000 + " ms");
		
		begin = System.nanoTime();
		for(int i = 0;i < 5000;i++) {
			collection.add(i,i);
		}
		end = System.nanoTime();
		System.out.println("'Add(int index,int element)' operation: " + (double)(end - begin)/1000000 + " ms");
		
		begin = System.nanoTime();
		collection.addAll(collection);
		end = System.nanoTime();
		System.out.println("'addAll(Collection <? extends E> collection)' operation: " + (double)(end - begin)/1000000 + " ms");
		
		begin = System.nanoTime();
		collection.addAll(0,collection);
		end = System.nanoTime();
		System.out.println("'addAll(int index, Collection <? extends E> collection)' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void RemoveOperationTimeTest(List<Integer> collection) {

		
		long begin = System.nanoTime();
		for(int i = 1000; i < 2000; i++) {
			collection.remove(i);
		}
		long end = System.nanoTime();
		System.out.println("'remove(int index)' operation: " + (double)(end - begin)/1000000 + " ms");
		
		begin = System.nanoTime();
		for(int i = 0; i < 3000; i++) {
			collection.removeAll(Arrays.asList(4500,3498,1));
		}
		end = System.nanoTime();
		
		System.out.println("'removeAll(Collection<?> c)' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void SortOperationTimeTest(List<Integer> collection) {

			
			long begin = System.nanoTime();
			collection.sort(null);
			long end = System.nanoTime();
			
			System.out.println("'sort(Comparator<? super E> c)' operation: " + (double)(end - begin)/1000000 + " ms");
		}
	public static void GetSizeTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.size();
		long end  = System.nanoTime();
		
		System.out.println("'size()' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void ContainsTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.contains(3567);
		long end = System.nanoTime();
		System.out.println("'contains(Object o)' operation: " + (double)(end - begin)/1000000 + " ms");
		
		ArrayList<Integer> lst = new ArrayList<Integer>(1);
		lst.add(123);
		lst.add(4999);
		begin = System.nanoTime();
		collection.containsAll(lst);
		end = System.nanoTime();
		
		System.out.println("'containsAll(Collection<?> c)' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void IsEmptyTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.isEmpty();
		long end = System.nanoTime();
		System.out.println("'isEmpty()' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void IndexOfTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.indexOf(3700);
		long end = System.nanoTime();
		System.out.println("'indexOf(Object o)' operation: " + (double)(end - begin)/1000000 + " ms");
		
		begin = System.nanoTime();
		collection.lastIndexOf(4057);
		end = System.nanoTime();
		
		System.out.println("'lastIndexOf(Object o)' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void GetTimeTest(List<Integer> collection) {
		
		Iterator<Integer> iter = collection.iterator();
		long begin = System.nanoTime();
		while(iter.hasNext()) {
			iter.next();
		}
		long end = System.nanoTime();
		
		System.out.println("'Get' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void ToArrayTimeTest(List<Integer> collection) {
		long begin = System.nanoTime();
		collection.toArray();
		long end = System.nanoTime();
		System.out.println("'ToArray' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void ReplaceAllTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.replaceAll(e -> -e);
		long end = System.nanoTime();
		
		System.out.println("'replaceAll(UnaryOperator<Integer> operator)' operation: " + (double)(end - begin)/1000000 + " ms");
	}
	public static void ClearTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.clear();
		long end = System.nanoTime();
		
		System.out.println("'clear()' operation: " + (double)(end - begin)/1000000 + " ms");
	}




}
