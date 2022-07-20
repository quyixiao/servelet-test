public class TEst4 {


    public static void main(String[] args) {
        boolean IS_TOKEN []= new boolean[] {true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, false, true, false, false, false,
                false ,false ,false ,false ,false,false ,false ,false ,false ,false,false ,false ,false ,false ,false,false ,false ,false ,false ,false,
                false,false,false , true ,true , true , false ,true
        };
        for(byte i = 0 ;i < 127;i ++){
           if(IS_TOKEN[i]){
                System.out.print((char)i +  " " + i +" ");
            }
            if(i %8 ==0){
                System.out.println();
            }
         /* if(is_query_relaxed[i]){
                System.out.print(i +" ");
            }*/
        }
    }
}
