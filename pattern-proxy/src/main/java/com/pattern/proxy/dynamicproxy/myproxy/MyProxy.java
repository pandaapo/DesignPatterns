package com.pattern.proxy.dynamicproxy.myproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

//主要功能：生成代码(——》自己编译、自己加载)
public class MyProxy {
    //换行符
    public static final String ln = "\r\n";

    public static Object newProxyInstance(MyClassLoader loader,
                                          Class<?>[] interfaces,
                                          MyInvocationHandler h){
        try{
            //动态生成源代码
            String src = generateSrc(interfaces);
            //java文件输出到磁盘
            String filePath = MyProxy.class.getResource("").getPath();
            File f = new File(filePath + "$Proxy0.java");
            FileWriter fw = new FileWriter(f);
            fw.write(src);
            fw.flush();
            fw.close();

            //动态编译上面生成的java文件
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable =  manager.getJavaFileObjects(f);
            //创建编译任务
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null, null, iterable);
            task.call();
            manager.close();
            //将编译后的类加载到JVM内存中
            Class proxyCLass = loader.findClass("$Proxy0");
            f.delete();
            //获取构造方法
            Constructor c = proxyCLass.getConstructor(MyInvocationHandler.class);
            //返回字节码重组以后的新的代理对象
            return c.newInstance(h);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    //创建$Proxy0代码
    private static String generateSrc(Class<?>[] interfaces) {
        //用代码写代码
        StringBuffer sb = new StringBuffer();
        sb.append("package com.pattern.proxy.dynamicproxy.myproxy;" + ln);
        sb.append("import com.pattern.proxy.Person;" + ln);
        sb.append("import java.lang.reflect.*;" + ln);
        //先只实现一个接口，interfaces[0]
        sb.append("public class $Proxy0 implements " + interfaces[0].getName() + "{" + ln);

        sb.append("MyInvocationHandler h;" + ln);
        //通过构造方法赋值
        sb.append("public $Proxy0(MyInvocationHandler h) {" + ln);
        sb.append("this.h = h;" + ln);
        sb.append("}" + ln);

        //生成接口中的方法
        for(Method m: interfaces[0].getMethods()){
            //动态获取方法的参数、类型、形参、返回值
            Class<?>[] params = m.getParameterTypes();

            StringBuffer paramNames = new StringBuffer();
            StringBuffer paramValues = new StringBuffer();
            StringBuffer paramClasses = new StringBuffer();

            for(int i = 0; i < params.length; i++){
                Class clazz = params[i];
                String type = clazz.getName();
                String paramName = toLowerFirstCase(clazz.getSimpleName());
                paramNames.append(type + " " + paramName);
                paramValues.append(paramName);
                paramClasses.append(clazz.getName() + ".class");
                if(i > 0 && i < params.length - 1){
                    paramNames.append(",");
                    paramClasses.append(",");
                    paramValues.append(",");
                }
            }

            //先只写无参的方法
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(" +paramNames.toString()+ "){" + ln);
                sb.append("try{" + ln);
                    //通过反射调用
                    sb.append("Method m =" + interfaces[0].getName()+ ".class.getMethod(\"" + m.getName() +"\", new Class[]{" + paramClasses.toString() + "});" + ln);
                    sb.append((hasReturnValue(m.getReturnType()) ? "return " : "") + getCaseCode("this.h.invoke(this, m, new Object[]{" +paramValues.toString()+ "})", m.getReturnType()) + ";");
                sb.append("}catch(Error e){"+ ln);
                sb.append("}catch(Throwable e){"+ ln);
                    sb.append("throw new UndeclaredThrowableException(e);" + ln);
                sb.append("}" + ln);
                sb.append(getReturnEmptyCode(m.getReturnType()));
            sb.append("}");
        }

        sb.append("}");
        return sb.toString();
    }

    private static String getReturnEmptyCode(Class<?> returnClazz) {
        if(mappings.containsKey(returnClazz)){
            return "return 0;";
        } else if (returnClazz == void.class) {
            return "";
        } else {
            return "return null;";
        }
    }

    private static Map<Class, Class> mappings = new HashMap<Class, Class>();
    static {
        mappings.put(int.class,Integer.class);
    }

    private static String getCaseCode(String s, Class<?> clazz) {
        if(mappings.containsKey(clazz)){
            return "((" +mappings.get(clazz).getName()+ ")" +s+ ")." + clazz.getSimpleName() + "Value()";
        }
        return s;
    }

    private static boolean hasReturnValue(Class<?> clazz) {
        return clazz != void.class;
    }

    private static String toLowerFirstCase(String src) {
        char[] chars = src.toCharArray();
        chars[0] += 32;
        return String.valueOf(chars);
    }

}
