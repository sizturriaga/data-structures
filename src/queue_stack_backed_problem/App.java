package queue_stack_backed_problem;

public class App {

	public static void main(String[] args) {
		
		Queue<String> queue = new Queue<>();
		queue.enqueue("Hi");
		queue.enqueue("how");
		System.out.println(queue.dequeue());
		queue.enqueue("are");
		queue.enqueue("you?");
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		

	}

}
