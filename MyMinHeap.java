final MAX_HEAP_VAL = 31; 
// Create a Main class
public class MyMinHeap {
  int heapVal;  // Create a class attribute
  int size =0; 
  int[] storage; 


  // Create a class constructor for the Main class
    public MyMinHeap(int heapVal){
        if(heapVal > MAX_HEAP_VAL || heapVal<1 ){
            heapVal = MAX_HEAP_VAL; 
        }
        int[] storage = new int [heapVal]; 
    }

    //insert(), remove(), replace(), peek(), load() and reheap()
    public void insert(int x){

        //if the storage array is emoty then insert the value
        //in the first space
        if(storage.length ==0){
            storage[1] == x; 
        }
        for(int i = 0; i>storageArray.length; i++){

        } 
    }


    public void remove(int x){

    }

    public void replace(int x){

    }

    public int peak(){
        
    }

    public void load(){
        
    }

    public void reheap(){

    }

    private void left-parent(int x){

    }

}