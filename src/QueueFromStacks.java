import java.util.Scanner;
import java.util.Stack;

public class QueueFromStacks {
    private static int ENQUEUE = 1;
    private static int DEQUEUE = 2;
    private static int PEEK = 3;

    public static void main(String[] args) {
        StackQueue<Integer> queue = new StackQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; ++i) {
            int operation = scan.nextInt();
            if (operation == ENQUEUE) {
                queue.enqueue(scan.nextInt());
            } else if (operation == DEQUEUE) {
                queue.dequeue();
            } else if (operation == PEEK) {
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class StackQueue<Integer> {
        private Stack<Integer> front = new Stack<>();
        private Stack<Integer> back = new Stack<>();

        public void enqueue(Integer num) {
            front.push(num);
        }

        public Integer dequeue() {
            if (size() == 0) {
                return null;
            }
            if (back.isEmpty()) {
                shift();
            }
            return back.pop();
        }

        public Integer peek() {
            if (size() == 0) {
                return null;
            }
            if (back.isEmpty()) {
                shift();
            }
            return back.peek();
        }

        private void shift() {
            if (back.isEmpty()) {
                while (!front.isEmpty()) {
                    back.push(front.pop());
                }
            }
        }

        public int size() {
            return front.size() + back.size();
        }
    }
}
