package com.learn.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class CompileClassLoader extends ClassLoader {

    //读取一个文件内容
    private byte[] getBytes(String fileName) throws IOException {
        File file = new File(fileName);
        long len = file.length();
        byte[] raw = new byte[(int)len];

        try(FileInputStream in = new FileInputStream(file)) {
            //一次性读取全部文件
            int r = in.read(raw);
            if(len != r)throw new IOException("无法读取文件：" + r + " != " + len);
            return raw;
        }
    }

    private boolean compile(String javaFile) throws IOException{
        System.out.println("CompileClassLoader：正在编译"+javaFile+"...");

        Process p = Runtime.getRuntime().exec("javac " + javaFile);

        try {
            //其他线程都等待这个线程完成
            p.waitFor();
        } catch (InterruptedException e) {
//            e.printStackTrace();
            System.out.println(e);
        }
        //获取javac线程的退出值
        int ret = p.exitValue();
        //返回编译是否成功
        return ret == 0;
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class clazz = null;
        //将包路径中的（.）替换成斜线（/）
        String fileSub = name.replace(".","/");
        String javaFileName = fileSub + ".java";
        String classFileName = fileSub + ".class";
        File javaFile = new File(javaFileName);
        File classFile = new File(classFileName);

        //当指定源文件存在，且Class文件不存在，或者Java源文件的修改时间比Class文件修改时间晚时，重新编译
        if(javaFile.exists() && (!classFile.exists()) || javaFile.lastModified() > classFile.lastModified()){

            try {
                //如果编译失败或者该文件不存在
                if(!compile(javaFileName) || !classFile.exists()){
                    throw new ClassNotFoundException("ClassNotFoundException:"+javaFileName);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //如果Class文件存在，系统负责将该文件转换成Class对象
        if(classFile.exists()){
            try {
                //将Class二进制数据读入数组
                byte[] raw = getBytes(classFileName);
                //调用ClassLoader的defineClass方法将二进制数据转换成Class对象
                clazz = defineClass(name,raw,0,raw.length);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //如果clazz为null，表明加载失败，则抛出异常
        if(clazz == null){
            throw new ClassNotFoundException("name");
        }

        return clazz;
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 1){
            System.out.println("缺少目标类，请安如下格式运行Java源文件：\njava CompileClassLoader ClassName");
            return;
        }
        String progClass  = args[0];
        String[] progArgs = new String[args.length - 1];
        System.arraycopy(args,1,progArgs,0,progArgs.length);
        CompileClassLoader ccl = new CompileClassLoader();
        Class<?> clazz = ccl.loadClass(progClass);
        Method main = clazz.getMethod("main",(new String[0]).getClass());
        Object[] argsArray = {progArgs};
        main.invoke(null,argsArray);
    }
}
