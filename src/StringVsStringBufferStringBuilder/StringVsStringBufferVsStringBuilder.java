package StringVsStringBufferStringBuilder;

public class StringVsStringBufferVsStringBuilder {
    public static void main(String[] args) {
         String s1 = "";
         int iterator = 100000;
         long startTime = System.currentTimeMillis();

//         step 1
//         for(int i=0;i<iterator; i++){
//             s1+= "String";
//         }
//         long endtime = System.currentTimeMillis();
//        System.out.println("Strting time : "+(endtime-startTime)+" ms");

//        step 2
//        StringBuffer sBuffer = new StringBuffer();
//        for(int i = 0; i < iterator; i++){
//            sBuffer.append("java");
//        }
//       long endtime = System.currentTimeMillis();
//        System.out.println("StringBuffer time : "+(endtime-startTime)+" ms");
//
//        step 3
//         StringBuilder stringBuilder = new StringBuilder();
//
//         for (int i = 0; i < iterator; i++){
//             stringBuilder.append("java");
//         }
        long endtime = System.currentTimeMillis();

        System.out.println("String builder time : "+(endtime - startTime)+" ms");


    }

}
