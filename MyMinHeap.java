
// Create a Main class
public class MyMinHeap {
  int heapSize;  // Create a class attribute
  int size =0; 
  int next; 
  String [] storage; //Where the lines are stored


  // Create a class constructor for the Main class
    public MyMinHeap(int heapVal){
        if(heapVal<1 ){
            heapSize = 31; 
        } else {
            heapSize = heapVal;
        }
        next=0;
        storage = new String [heapSize+1]; 
    }

    //insert(), remove(), replace(), peek(), load() and reheap()
    // while(i>1 && H[i] < H[i/2])
	// swap i with i/2
	// set i to i/2
    public void insert(String line){
        next++;
        int i = next;  
        storage[i] =line;
        String temp; 
        while(i > 1 && storage[i].compareTo(storage[i/2])<0){
            temp = storage[i];
            storage[i] = storage[i/2];
            storage[i/2] = temp;
            i = i/2;
        }
    }

    public String remove(){
        if(next < 1){
            return null; 
        }
        
        String deletedroot = storage[1];  
        storage[1] = storage[storage.length]; 
        //Decrement next 
        next--;
        int i =  1;
        reheap(i);   
        return deletedroot; 
    }

    public void replace(String line){
        //replace the first node in the array 
        storage[1] = line; 
       //restore the heap order
       reheap(1);
    }

    public String peek(){
        return storage[1];
    }

    public void load(String [] newStorage){
        storage = newStorage;
        reheap(1);
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


    public int getSize(){
        return next; 
    }
}