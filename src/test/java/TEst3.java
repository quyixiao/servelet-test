public class TEst3 {


    public static void main(String[] args) {
        boolean IS_TOKEN []= new boolean[] {false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, true, true, true, true, true, false, false, true, true, false, true, true, false, true, true, true, true, true, true, true, true, true, true, false, false, false, false, false, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, true, true, true, true, true, true,
                true , true ,true ,true , true , true ,true ,true ,true , true ,true ,true , true , true ,true ,true ,true , true ,true ,true,
                true,true ,true , false , true ,false , true ,false
        };
        for(byte i = 0 ;i < 127;i ++){
           /* if(!IS_TOKEN[i]){
                System.out.print((char)i + "=" + IS_TOKEN[i] + " " + i +" ");
            }
            if(i %8 ==0){
                System.out.println();
            }*/
          if(!IS_TOKEN[i]){
                System.out.print(i +" ");
            }
        }
    }
}
