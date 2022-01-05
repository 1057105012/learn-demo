import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.agent.builder.ResettableClassFileTransformer;
import net.bytebuddy.asm.Advice;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.io.IOException;
import java.lang.instrument.Instrumentation;

/**
 * @author cntos
 * @Description 
 * fixme: java -javaagent:E:\environment\plugin\git_project\learn-demo\target\demo-1.0-SNAPSHOT-pg.jar -jar demo-1.0-SNAPSHOT-pg.jar 
 * this command will throw execption
 * fixme: java -javaagent:E:\environment\plugin\git_project\learn-demo\target\demo-1.0-SNAPSHOT.jar -jar demo-1.0-SNAPSHOT.jar 
 * this command is normal
 * @createTime 2022年01月05日 14:50:00
 */
public class BytebuddyTest {

    public static void premain(String args, Instrumentation instrumentation) throws IOException {
        System.out.println("------ mock execption");
        ResettableClassFileTransformer transformer = new AgentBuilder.Default()
                .with(AgentBuilder.PoolStrategy.Default.EXTENDED)
                .with(new AgentBuilder.Listener() {
                    @Override
                    public void onDiscovery(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {
                        
                    }

                    @Override
                    public void onTransformation(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded, DynamicType dynamicType) {

                    }

                    @Override
                    public void onIgnored(TypeDescription typeDescription, ClassLoader classLoader, JavaModule module, boolean loaded) {

                    }

                    @Override
                    public void onError(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded, Throwable throwable) {
                        System.out.println("typeName = " + typeName);
                        System.out.println("throwable = " + throwable);
                    }

                    @Override
                    public void onComplete(String typeName, ClassLoader classLoader, JavaModule module, boolean loaded) {

                    }
                })
                .type(ElementMatchers.any())
                .transform((builder, typeDescription, classLoader, module) -> {
                    System.out.println("--- begin transform " +typeDescription.getTypeName());
                    return builder.visit(Advice.to(AdviceLogic.class).on(ElementMatchers.any()));
                }).installOn(instrumentation);
    }

    public static void main(String[] args) {
        new Cooker().hello();
    }
}
