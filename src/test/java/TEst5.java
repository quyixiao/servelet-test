public class TEst5 {


    public static void main(String[] args) {
        boolean IS_ABSOLUTEPATH_RELAXED []= new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, true, false, true, true, true,
                    true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,true ,
                true,true,true,false,false,false,true ,false
        };
        for(byte i = 0 ;i < 127;i ++){
           if(!IS_ABSOLUTEPATH_RELAXED[i]){
                System.out.print((char)i +  " " + i +" ");
            }
            if(i %8 ==0){
                System.out.println();
            }
        }
        // IdentityInputFilter,VoidInputFilter,BufferedInputFilter,ChunkedInputFilter

        System.out.println();
        for(byte i = 0 ;i < 127;i ++){

          if(!IS_ABSOLUTEPATH_RELAXED[i]){
                System.out.print(i +" ");
            }
        }

    }
}
