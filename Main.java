public class Main {
    public static void main(String[] args) {

        MyMinHeap minHeap = new MyMinHeap(10); 
        minHeap.insert("balled");
        minHeap.insert("apple");
        minHeap.insert("catdog");
        minHeap.insert("doghouse");
        minHeap.print();
        minHeap.replace("bounce");
        minHeap.print();
        minHeap.remove();
        minHeap.print();
    }    
}
