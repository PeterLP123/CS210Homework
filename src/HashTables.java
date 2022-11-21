public class HashTables {
    public static void main(String [] args){
        int size = 99877;
        String arr[] = new String [90000];
        int count1 = 0;
        int count2 = 0;
        Dictionary input = new Dictionary();
        while(count1 < arr.length){
            while(true){
                count2++;
                if(input.getWord(count2).matches("^[a-z]+$")){
                    arr[count1] = input.getWord(count2);
                    break;
                }
            }
            count1++;
        }
        String [] finished = fill(size, arr);
        for(int i = 0; i < finished.length; i++){
            System.out.println(finished[i]);
        }
        HashTable hash1 = new HashTable(finished);
        for(int i = 0; i < arr.length; i++){
            find(size, hash1, arr[i]);
        }
        System.out.println(hash1.countnull());
        System.out.println(hash1.gettotal());
    }

    public static int find(int size, HashTable mytable, String word){
       
        //fill this in so as to minimize collisions
        //takes in the HashTable object and the word to be found
        //the only thing you can do with the HashTable object is call "check"
        //this method should return the slot in the hashtable where the word is
        
        long sum = 0;
        int count = 0;
        for(int j = 0; j < word.length() && j < 12; j++){     
            long charno = word.charAt(j);
            long powers = (long) (charno * Math.pow(27, j));
            sum += powers;
        }
        sum %= size;
        //sum *= sum;
        //sum %= size;
        while(true){
            if(sum >= size){
                sum -= size;
            }
            if(mytable.check((int)sum, word)){
                return (int)sum;
            }
            count++;
            sum += Math.pow(count, 2);
        }
    }
   
    public static String[] fill(int size, String[] array){
       
        //takes in the size of the hashtable, and the array of Strings to be placed in the hashtable
        //this should add all the words into the hashtable using some system
        //then it should return the hashtable array
        String[] hashtable = new String[size];
        for(int i=0;i<array.length;i++){
            long sum = 0;
            int count = 0;
            for(int j = 0; j < array[i].length() && j < 12; j++){     
                long charno = array[i].charAt(j);
                long powers = (long) (charno * Math.pow(27, j));
                sum += powers;
            }
            sum %= size;
            //sum *= sum;
            System.out.println(sum);
            //sum %= size;
            while(true){
                if(sum >= size){
                    sum -= size;
                }
                if(hashtable[(int)sum] == null){
                    hashtable[(int)sum] = array[i];
                    break;
                }
                count++;
                sum += Math.pow(count, 2);
            }
        }
        return hashtable;
    }  
}

class HashTable{
   
    private String[] hashTable;
    private long total=0;

    public HashTable(String[] input){
        hashTable = input;
    }

    public boolean check(int slot, String check){
        if(hashTable[slot].equals(check)){
            return true;
        }else{
            total++;
            return false;
        }
    }
   
    public long gettotal(){
        return total;
    }

    public int countnull(){
        int nulls = 0;
        for(int i = 0; i < hashTable.length; i++){
            if(hashTable[i] == null){
                nulls++;
            }
        }
        return nulls;
    }
}