import net.bytebuddy.asm.Advice;
import net.bytebuddy.implementation.bytecode.assign.Assigner;

import java.util.Arrays;

public class AdviceLogic {

    @Advice.OnMethodEnter
    public static void onMethodEnter(
            @Advice.Origin("#t #m") String method,
            @Advice.AllArguments(readOnly = false, typing = Assigner.Typing.DYNAMIC) Object[] args) {
        if (method != null) {
            try {
                System.out.println(" ---------- enter" + method + Arrays.toString(args));
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("method = " + method);
        }
    }
    
//    @Advice.OnMethodEnter
//    public static void onMethodEnter(@Advice.AllArguments Object[] args){
//        for(;;){
//            System.out.println(" ---------- ");
//        }
////        if(args != null){
////            System.out.println("Arrays.toString(args) = " + Arrays.toString(args));
////        }
//
//    }

}