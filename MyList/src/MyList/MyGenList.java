/*
package MyList;
public class MyGenList<T> {
    private T [] arr;
    int size;
    int capacity;
    public MyGenList() {
        this.size = size;
        this.capacity = 5;
        this.arr = (T[]) new Object[capacity];
    }
    public void add(T num) throws ArrayFullException {
        try{
            arr[size++] = num;
        }catch (IndexOutOfBoundsException e){
            size = 5;
            throw new ArrayFullException(num);
        }

    }
    public void addAt(int pos, T num) throws ArrayFullException {
        if(size+1 > capacity){
            throw new ArrayFullException(num);
        }
        if(pos > size+1){
            throw new InvalidPositionException(size+1);
        }
        size++;
        for(int j = size-1; j>=pos; j--){
            arr[j] = arr[j-1];
        }
        arr[pos-1] = num;
    }
    public boolean remove(Object num){
        for(int i = 0; i<size; i++){
            if(arr[i].equals(num)){
                for(int j = i; j<size; j++){
                    if(j != size-1){
                        arr[j] = arr[j+1];
                    }
                }
                size--;
                return true;
            }
        }
        return false;
    }
    public T removeAt(int pos) throws InvalidPositionException{
        if(pos>size){
            throw new InvalidPositionException(pos-1);
        }
        T temp = null;
        for(int i = 0; i<size; i++){
            if(i == pos-1){
                temp = arr[i];
                for(int j = i; j<size; j++){
                    if(j != size-1){
                        arr[j] = arr[j+1];
                    }
                }
                size--;
                return temp;
            }
        }
        return temp;
    }
    public boolean contains(Object num){
        for(int i = 0; i<size; i++){
            if(arr[i].equals(num))return true;
        }
        return false;
    }
    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public T get(int pos){
        if(pos<1|| pos>size){
            throw new InvalidPositionException(size);
        }
        for(int i = 0; i<size; i++){
            if(i == pos - 1) return arr[i];
        }
        return null;
    }
    public T set(int pos, T num) throws ArrayFullException {
        if(pos>size){
            throw new InvalidPositionException(pos-1);
        }
        T temp = arr[pos-1];
        removeAt(pos);
        addAt(pos, num);
        return temp;
    }

}
*/
