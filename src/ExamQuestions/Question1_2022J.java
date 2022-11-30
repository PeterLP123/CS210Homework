public class Question1_2022J {
    public static void main(String [] args){
        int num = 1;
        boolean found = false;
        while(!found){
            for(int i = 1; i <= 20; i++){
                if(num % i != 0){
                    break;
                }
                if(i == 20){
                    found = true;
                }
            }
            if(!found){
                num++;
            }
        }
        System.out.println(num);
    }
}