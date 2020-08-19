package L16_StackQueueQs;

public class StackMin {

	private int[] data;
	private int tos;
	private int min;

	public StackMin() {
		data = new int[5];
		tos = -1;
		min = Integer.MAX_VALUE;
	}

	public StackMin(int cap) {
		data = new int[cap];
		tos = -1;
		min = Integer.MAX_VALUE;
	}

	public int size() {
		return tos + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public boolean isFull() {
		return size() == data.length;
	}

	public void push(int val) {

		if (isEmpty()) {
			data[++tos] = val;
			min = val;
		} else if (val >= min) {
			data[++tos] = val;
		} else {
			data[++tos] = 2 * val - min;
			min = val;
		}

	}

	public int peek() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		} else {

			// no encryption
			if (data[tos] >= min) {
				return data[tos];
			} else {
				return min;
			}

		}
	}

	public int pop() throws Exception {

		if (isEmpty()) {
			throw new Exception("Stack is Empty");
		} else {

			// no encryption
			if (data[tos] >= min) {
				int temp = data[tos];
				data[tos] = 0;
				tos--;
				return temp;
			} else {

				int temp = min;

				min = 2 * min - data[tos];

				// remove the top most value of stack which was in encrypted form
				data[tos] = 0;
				tos--;

				return temp;

			}

		}
	}

}
