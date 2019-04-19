package com.pattern.proxy.dynamicproxy.myproxy;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.ToolProvider;
import java.io.File;
import java.io.FileWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

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

            //动态编译
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            StandardJavaFileManager manager = compiler.getStandardFileManager(null, null, null);
            Iterable iterable =  manager.getJavaFileObjects(f);
            //创建编译任务
            JavaCompiler.CompilationTask task = compiler.getTask(null,manager,null,null, null, iterable);
            task.call();
            manager.close();
            //将编译后的类加载到内存中
            Class proxyCLass = loader.findClass("$Proxy0");
            System.out.println(proxyCLass);
            Constructor c = proxyCLass.getConstructor(MyInvocationHandler.class);
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

        for(Method m: interfaces[0].getMethods()){
            sb.append("public " + m.getReturnType().getName() + " " + m.getName() + "(){" + ln);
                sb.append("try{" + ln);
                //通过反射调用
                sb.append("Method m =" + interfaces[0].getName()+ ".class.getMethod(\"" + m.getName() +"\", new Class[]{});" + ln);
                sb.append("this.h.invoke(this,m,null);" + ln);
                sb.append("}catch(Throwable e){"+ ln);
                sb.append("e.printStackTrace();" + ln);
                sb.append("}" + ln);
            sb.append("}");
        }

        sb.append("}");
        return sb.toString();
    }

}
