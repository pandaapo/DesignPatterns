package com.pattern.proxy.dynamicproxy.myproxy;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

public class MyClassLoader extends ClassLoader{
    //声明类路径
    private File classPathFile;

    public MyClassLoader(){
        String classPath = MyClassLoader.class.getResource("").getPath();
        this.classPathFile = new File(classPath);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // 获取类环境
        String className  =  MyClassLoader.class.getPackage().getName() + "." + name;
        //把类转换成文件
        if(classPathFile != null){
            File classFile = new File(classPathFile, name.replaceAll("\\.","/") + ".class");
            if(classFile.exists()){
                //再通过字节码读取文件，转换成类对象
                FileInputStream in = null;
                ByteArrayOutputStream out = null;
                try{
                    in = new FileInputStream(classFile);
                    out = new ByteArrayOutputStream();
                    byte[] buff = new byte[1024];
                    int len;
                    while ((len = in.read(buff)) != -1) {
                        out.write(buff, 0,len);
                    }
                    return  defineClass(className,out.toByteArray(),0,out.size());
                }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }
}
