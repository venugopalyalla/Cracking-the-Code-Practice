import java.util.LinkedList;

abstract class Animal {
	String name;
	int order;

	public Animal(String n) {
		name = n;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	public int getOrder() {
		return order;
	}

	public boolean isOlderThan(Animal a) {
		return order < a.getOrder();
	}
}

class Dog extends Animal {
	Dog(String n) {
		super(n);
	}
}

class Cat extends Animal {
	Cat(String n) {
		super(n);
	}
}

public class AnimalShelter {
	private int order = 0;
	LinkedList<Dog> dogs = new LinkedList<Dog>();
	LinkedList<Cat> cats = new LinkedList<Cat>();

	public void enqueue(Animal a) {
		a.setOrder(order);
		order++;
		if (a instanceof Dog) {
			dogs.addLast((Dog) a);
		} else if (a instanceof Cat) {
			cats.addLast((Cat) a);
		}
	}

	public Dog deQueueDogs() {
		return dogs.poll();
	}

	public Cat deQueueCats() {
		return cats.poll();
	}

	public boolean isEmpty() {
		return dogs.size()==0 && cats.size()==0;
	}
	public Animal dequeueAny() {
		if (dogs.size() == 0) {
			return deQueueCats();
		}
		if (cats.size() == 0) {
			return deQueueDogs();
		}
		Dog dog = dogs.peek();
		Cat cat = cats.peek();
		if (dog.isOlderThan(cat)) {
			return deQueueDogs();
		} else {
			return deQueueCats();
		}
	}
	public static void main(String[] args) {
		Dog dog1 = new Dog("dog1");
		Dog dog2 = new Dog("dog2");
		Dog dog3 = new Dog("dog3");
		Dog dog4 = new Dog("dog4");
		Dog dog5 = new Dog("dog5");

		Cat cat1 = new Cat("cat1");
		Cat cat2 = new Cat("cat2");
		Cat cat3 = new Cat("cat3");
		Cat cat4 = new Cat("cat4");
		Cat cat5 = new Cat("cat5");

		AnimalShelter shelter = new AnimalShelter();
		shelter.enqueue(dog1);
		shelter.enqueue(cat1);
		shelter.enqueue(dog3);
		shelter.enqueue(cat2);
		shelter.enqueue(cat5);
		
		while(!shelter.isEmpty()) {
			System.out.println(shelter.dequeueAny().name);
		}
	}
}
