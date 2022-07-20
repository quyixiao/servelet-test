public class TEst2 {


    public static void main(String[] args) {
        boolean is_query_relaxed []= new boolean[] {
            false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, true, false, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, true, false, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, true, false, false, false, false, true, false, true, true, true,
            true , true ,true ,true , true , true ,true ,true ,true , true ,true ,true , true , true ,true ,true ,true , true ,true ,true,
            true,true ,true , false,false,false ,true ,false
        };
        for(byte i = 0 ;i < 127;i ++){
            if(!is_query_relaxed[i]){
                System.out.print((char)i + "=" + is_query_relaxed[i] + " " + i +" ");
            }
            if(i %8 ==0){
                System.out.println();
            }
        /*    if(!is_query_relaxed[i]){
                System.out.print(i +" ");
            }*/
        }
    }
}
