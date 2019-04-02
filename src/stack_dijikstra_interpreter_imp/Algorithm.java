package stack_dijikstra_interpreter_imp;

import java.util.Stack;

public class Algorithm {

	private Stack<String> operationStack;
	private Stack<Double> valueStack;

	public Algorithm() {
		this.operationStack = new Stack<>();
		this.valueStack = new Stack<>();
	}

	public void interpreterExpression(String expression) {

		String[] expressionArray = expression.split(" ");

		for (String string : expressionArray) {

			if (string.equals("(")) {
				continue;
			} else if (string.equals("+") || string.equals("*") || string.equals("-") || string.equals("/")) {
				this.operationStack.push(string);
			} else if (string.equals(")")) {
				String operation = this.operationStack.pop();

				if (operation.equals("+")) {
					this.valueStack.push(this.valueStack.pop() + this.valueStack.pop());
				}

				if (operation.equals("*")) {
					this.valueStack.push(this.valueStack.pop() * this.valueStack.pop());
				}
			} else {
				this.valueStack.push(Double.parseDouble(string));
			}
		}
	}
	
	public void getResult() {
		System.out.println(this.valueStack.pop());
	}
}
