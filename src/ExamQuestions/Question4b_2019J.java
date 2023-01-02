public class Question4b_2019J {
    public static void main(String[] args){
        System.out.println((((11&19)|5))<<3);
    }       
}

/*  
00001011
AND
00010011
=
00000011

00000011
OR
00000101
=
00000111

00000111
<<3
=
00111000

8+16+32=56
*/