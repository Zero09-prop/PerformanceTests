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
	
	/***
	 * Method that counts the performance of add operations
	 * List.Add(Integer e)
	 * List.Add(int index,Integer element)
	 * List.addAll(Collection<? extends Integer> c)
	 * List.addAll(int index, Collection<? extends Integer> c)
	 * @param collection - ArrayList or LinkedList
	 */
	public static void AddOperationTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		for(int i = 0;i < 5000;i++) {
			collection.add(i);
		}
		long end = System.nanoTime();
		System.out.println("'Add(int i)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 5000 times");
		
		begin = System.nanoTime();
		for(int i = 0;i < 5000;i++) {
			collection.add(i,i);
		}
		end = System.nanoTime();
		System.out.println("'Add(int index,int element)' operation: " + (double)(end - begin)/1000000 + " ms Completed 5000 times");
		
		begin = System.nanoTime();
		collection.addAll(collection);
		end = System.nanoTime();
		System.out.println("'addAll(Collection <? extends E> collection)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
		
		begin = System.nanoTime();
		collection.addAll(0,collection);
		end = System.nanoTime();
		System.out.println("'addAll(int index, Collection <? extends E> collection)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}
	
	/***
	 * Method that counts the performance of delete operations
	 * List.remove(int index)
	 * List.removeAll(Collection<?> c)
	 * @param collection - ArrayList or LinkedList
	 */
	public static void RemoveOperationTimeTest(List<Integer> collection) {

		
		long begin = System.nanoTime();
		for(int i = 1000; i < 2000; i++) {
			collection.remove(i);
		}
		long end = System.nanoTime();
		System.out.println("'remove(int index)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1000 times");
		
		begin = System.nanoTime();
		for(int i = 0; i < 3000; i++) {
			collection.removeAll(Arrays.asList(4500,3498,1));
		}
		end = System.nanoTime();
		
		System.out.println("'removeAll(Collection<?> c)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 3000 times");
	}
	
	/**
	 * Method that counts the performance of sorting operations
	 * List.sort(Comparator<? super Integer> c)
	 * @param collection - ArrayList or LinkedList
	 */
	public static void SortOperationTimeTest(List<Integer> collection) {

			
			long begin = System.nanoTime();
			collection.sort(null);
			long end = System.nanoTime();
			
			System.out.println("'sort(Comparator<? super E> c)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
		}
	
	/***
	 * Method that counts the performance of size() operations
	 * List.size()
	 * @param collection - ArrayList or LinkedList
	 */
	public static void GetSizeTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.size();
		long end  = System.nanoTime();
		
		System.out.println("'size()' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}
	
	/**
	 * Method that counts the performance of contains() operations
	 * List.contains(Object o)
	 * List.containsAll(Collection<?> c)
	 * @param collection - ArrayList or LinkedList
	 */
	public static void ContainsTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.contains(3567);
		long end = System.nanoTime();
		System.out.println("'contains(Object o)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
		
		ArrayList<Integer> lst = new ArrayList<Integer>(1);
		lst.add(123);
		lst.add(4999);
		begin = System.nanoTime();
		collection.containsAll(lst);
		end = System.nanoTime();
		
		System.out.println("'containsAll(Collection<?> c)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}
	
	/**
	 * Method that counts the performance of isEmpty() operations
	 * List.isEmpty()
	 * @param collection - ArrayList or LinkedList
	 */
	public static void IsEmptyTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.isEmpty();
		long end = System.nanoTime();
		System.out.println("'isEmpty()' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}
	
	/**
	 * Method that counts the performance of IndexOf() operations
	 * List.indexOf(Object o)
	 * List.lastIndexOf(Object o)
	 * @param collection - ArrayList or LinkedList
	 */
	public static void IndexOfTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.indexOf(3700);
		long end = System.nanoTime();
		System.out.println("'indexOf(Object o)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
		
		begin = System.nanoTime();
		collection.lastIndexOf(4057);
		end = System.nanoTime();
		
		System.out.println("'lastIndexOf(Object o)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}
	
	/**
	 * Method that counts the performance of get() operations
	 * List.get(int index)
	 * @param collection - ArrayList or LinkedList
	 */
	public static void GetTimeTest(List<Integer> collection) {
		
		Iterator<Integer> iter = collection.iterator();
		long begin = System.nanoTime();
		while(iter.hasNext()) {
			iter.next();
		}
		long end = System.nanoTime();
		
		System.out.println("'Get' operation: " + (double)(end - begin)/1000000 + " ms. Completed " + collection.size() +" times");
	}
	
	/**
	 * Method that counts the performance of ToArray() operations
	 * List.toArray()
	 * @param collection - ArrayList or LinkedList
	 */
	public static void ToArrayTimeTest(List<Integer> collection) {
		long begin = System.nanoTime();
		collection.toArray();
		long end = System.nanoTime();
		System.out.println("'ToArray' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}
	
	/**
	 * Method that counts the performance of replaceAll() operations
	 * List.replaceAll(UnaryOperator<Integer> operator)
	 * @param collection - ArrayList or LinkedList
	 */
	public static void ReplaceAllTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.replaceAll(e -> -e);
		long end = System.nanoTime();
		
		System.out.println("'replaceAll(UnaryOperator<Integer> operator)' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}
	
	/**
	 * Method that counts the performance of clear() operations
	 * List.clear()
	 * @param collection - ArrayList or LinkedList
	 */
	public static void ClearTimeTest(List<Integer> collection) {
		
		long begin = System.nanoTime();
		collection.clear();
		long end = System.nanoTime();
		
		System.out.println("'clear()' operation: " + (double)(end - begin)/1000000 + " ms. Completed 1 times");
	}




}
