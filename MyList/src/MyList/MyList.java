package MyList;

public class MyList {
    int[] array;
    int sizer;
    static int capacity=5;

    public MyList(){
        sizer=0;
        this.array = new int[5];
    }
    
    public void add(int num) throws ArrayFullException {
        try {
            array[sizer] = num;
            sizer++;
        }
        catch(ArrayIndexOutOfBoundsException e){
            throw new ArrayFullException(num);
        }
    }

    public void addAt(int pos, int num) throws ArrayFullException {
        if(pos > sizer+1){
            throw new InvalidPositionException(sizer+1);
        }

        if(sizer>=5){
            throw new ArrayFullException(num);
        }

            for (int i = sizer; i >= pos; i--) {
                array[i] = array[i - 1];
            }
            array[pos - 1] = num;
            sizer++;
    }

    public boolean remove(int num){
        for (int i = 0; i < sizer; i++) {
            if (array[i] == num) {
                // Step 2: MOVE the elements to left
                for (int j = i; j < sizer-1; j++) {
                    array[j] = array[j+1];
                }
                // Step 3: Set the size
                array[sizer-1] = 0;
                sizer = sizer-1;
                // Step 4: Return
                return true;
            }
        }
        return false;
    }

    public int removeAt(int pos){
        if(pos>sizer || pos < 0){
            throw new InvalidPositionException(sizer);
        }
        int posi = array[pos-1];
        for(int i=pos-1;i<sizer;i++){
            array[i]=array[i+1];
        }
        array[sizer-1] = 0;
        sizer--;
        return posi;
    }

    public boolean contains(int num){
        for(int i=0;i<sizer;i++){
            if(array[i]==num){
                return true;
            }
        }
        return false;
    }

    public int size(){
        return sizer;
    }

    public boolean isEmpty(){
        if(sizer<=0){
            return true;
        }
        return false;
    }

    public int get(int pos){
        if(pos>sizer || (pos-1) < 0){
            throw new InvalidPositionException(sizer);
        }
        return array[pos-1];
    }

    public int set(int pos, int num){
        if(pos>sizer || pos < 0){
            throw new InvalidPositionException(sizer);
        }
        int getNum = array[pos-1];
        array[pos-1] = num;
        return getNum;
    }


}

