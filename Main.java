
public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("----------------TESTING MAXHEAP CONSTRUCTOR------------------\n");
        Comparable[] arr = {9,7,3,5,1,2};
        MaxHeap h0 = new MaxHeap(arr);
        System.out.println(h0.toString());
        System.out.println("----------------TESTING MAXHEAP PUSH------------------\n");
        h0.push(10);
        System.out.println(h0.toString());
        h0.push(4);
        System.out.println(h0.toString());
        h0.push(6);
        System.out.println(h0.toString());
        System.out.println("----------------TESTING MAXHEAP POP------------------\n");
        h0.pop();
        System.out.println(h0.toString());
        h0.pop();
        System.out.println(h0.toString());
        h0.pop();
        System.out.println(h0.toString());
        System.out.println("----------------TESTING MINHEAP PEEK------------------\n");
        System.out.println(h0.peek());

        System.out.println("----------------TESTING MINHEAP CONSTRUCTOR------------------\n");
        Comparable[] arr2 = {5,8,3,4,7,1,9};
        MinHeap h1 = new MinHeap(arr2);
        System.out.println(h1.toString());
        System.out.println("----------------TESTING MINHEAP PUSH------------------\n");
        h1.push(10);
        System.out.println(h1.toString());
        h1.push(6);
        System.out.println(h1.toString());
        h1.push(2);
        System.out.println(h1.toString());
        System.out.println("----------------TESTING MINHEAP POP------------------\n");
        h1.pop();
        System.out.println(h1.toString());
        h1.pop();
        System.out.println(h1.toString());
        h1.pop();
        System.out.println(h1.toString());
        h1.pop();
        System.out.println(h1.toString());
        h1.pop();
        System.out.println(h1.toString());
        h1.pop();
        System.out.println(h1.toString());
        System.out.println("----------------TESTING MINHEAP PEEK------------------\n");
        System.out.println(h1.peek());



    }
}
