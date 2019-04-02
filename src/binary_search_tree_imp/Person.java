package binary_search_tree_imp;

public class Person implements Comparable<Person> {
	
	private String name;
	private Integer age;
	
	Person(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Person o) {
		return this.age.compareTo(o.getAge());
	}

}
