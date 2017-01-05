package uchidb;

import java.util.*;

/**
 * @author Eric Liu
 */
public class HW0Runner {

	private static class SingletonContainers<T,S> implements Containers<T,S> {
		private Set<T> set;
		private List<T> list;
		private Map<S,T> map;

		//Create a set that stores the array of T objects
		public Set<T> initSet(T[] tArray) {
			set = new HashSet<T>();
			for (T elem: tArray)
				set.add(elem);
			return set;
		}
		
		//Create a list that stores an the array of T objects
		public List<T> initList(T[] tArray) {
			list = new ArrayList<T>();
			for (T elem: tArray)
				list.add(elem);
			return list;
		}
		
		//Create an empty map that will use type S as keys, and T as values
		public Map<S,T> initEmptyMap() {
			map = new HashMap<S,T>();
			return map;
		}
		
		//Store the map in a local field variable -- often called a setter 
		public void storeMap(Map<S,T> mapToStoreInClass) {
			map = mapToStoreInClass;
		}
		
		//add a key value to store map with a boolean indicating whether to overwrite existing value
		public boolean addToMap(S key, T value, boolean overwriteExistingKey) {
			if (map == null)
				initEmptyMap();

			if (map.containsKey(key)) {
				if (overwriteExistingKey) {
					map.put(key, value);
					return true;
				} else
					return false;
			}

			map.put(key, value);
			return true;
		}
		
		//get a value based on a key
		public T getValueFromMap(S key) {
			if (map == null)
				return null;

			return map.get(key);
		}
		
		//an overloaded function to get value from map but with a default value
		//if the key is not present
		public T getValueFromMap(S key, T defaultValue) {
			if (map == null || !map.containsKey(key))
				return defaultValue;
			else
				return map.get(key);
		}
	}

	private static SingletonContainers<Integer, String> instance = null;

	// This class is a factory for a singleton containers class.
	// https://www.tutorialspoint.com/java/java_using_singleton.htm
	public static Containers<Integer, String> getContainers() {
		if (instance == null)
			instance = new SingletonContainers<Integer, String>();

		return instance;
	}

	public static void main(String[] args){
		
	}
}
