import java.util.Arrays;
// Create a Main class
public class MyMinHeap {
  int heapSize;  // Create a class attribute
  int next; // pointer and line counter
  String [] storage; //Where the lines are stored


  // Create a class constructor for the Main class
    public MyMinHeap(int heapVal){
        if(heapVal<1 ){ // If memory size is too small
            heapSize = 31;  // set to default 31
        } else { // Set heap size to given value
            heapSize = heapVal;
        }
        next=0; // init pointer
        storage = new String [heapSize+1]; // init storage array for heap 
    }

    // while(i>1 && H[i] < H[i/2])
	// swap i with i/2
	// set i to i/2
    public void insert(String line){
        next++; // set pointer to next available node
        int i = next;  // temp var for sorting
        storage[i] = line; // set node
        String temp; // temp var for node swapping
        while(i > 1 && storage[i].compareTo(storage[i/2])<0){ // while not root node, and new line smaller than parent
            temp = storage[i]; // hold onto new line
            storage[i] = storage[i/2]; // move parent of new line into node
            storage[i/2] = temp; // set new line as parent.
            i = i/2;  // change effective pointer for further sorting
        }
    }

    // remove and return root node
    public String remove(){
        if(next < 1){ // If nothing in heap
            return null; 
        }
        String deletedroot = storage[1];  // get root node
        storage[1] = storage[next]; // swap root with final node
        //Decrement next 
        next--; // "delete" final node
        reheap(1); // reheap   
        return deletedroot; // return old root node.
    }

    // replace root node
    public void replace(String line){
        //replace the first node in the array 
        storage[1] = line; 
       //restore the heap order
       reheap(1);
    }

    // return (but not remove) root node
    public String peek(){
        return storage[1];
    }

    // Load array into heap
    public void load(String [] newStorage, int newNext){
        storage = newStorage;  // Assign array to storage
        next = newNext-1; // set pointer 
        reheap(1); // reheap to organise
    }

    public void reheap(int i){
        String temp; 
        int leftChild = i*2; 
        int rightChild= (2*i)+1; 
        while( 2*i < next){
            //if the left child is smaller than the node I and the right child 
            if(storage[i].compareTo(storage[leftChild]) > 0 && storage[leftChild].compareTo(storage[rightChild])<0){
                temp = storage[i];
                storage[i] = storage[leftChild]; 
                storage[leftChild] = temp; 
            }
           else if(storage[i].compareTo(storage[rightChild])>0&& storage[rightChild].compareTo(storage[leftChild])<0){
            //if the right child is smaller than node i and theleft child 
                temp = storage[i];
                storage[i] = storage[rightChild]; 
                storage[rightChild] = temp;
            }
            else{
                break;
            }
        }
    }

    // return size of heap (number of elements)
    public int getSize(){
        return next;
    }

    // Print heap to std output
    public void print(){
        System.out.println(Arrays.toString(storage));
    }
}