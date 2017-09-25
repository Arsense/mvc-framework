package mvc.main.function;

import org.springframework.beans.factory.wiring.ClassNameBeanWiringInfoResolver;
import sun.swing.FilePane;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarInputStream;

/**
 * Created by 伟 on 2017/9/22.
 */

//获取一个包下所有的类
public class PackageScan {

        private String packages;
        private ClassLoader classLoader;
        public PackageScan(String packages,ClassLoader classLoader){
            this.classLoader = classLoader;
            this.packages = packages;
        }
    /**
     * Construct an instance and specify the base package it should scan.
     * @param packages The base package to scan.
     */
        public PackageScan(String packages) {
            this.packages = packages;
            this.classLoader = getClass().getClassLoader();//获得类加载器

        }
        public   List<String> getAllClassNamesFromPackage() throws IOException {

            return scanPackages(packages,new ArrayList<String>());
        }

        public List<String> scanPackages(String scanPath,List<String> classList) throws IOException {

            // 点换成斜线
            String splashPath = scanPath.replaceAll("\\.","/");
            //得到URL路径  是file:/开头
            URL url = classLoader.getResource(splashPath);
            String FilePath =getFilePath(url);
            //是jar包还是 文件目录
            List<String> classNames;
            if(isJarPath(FilePath)){
                classNames = readFromJarFile(FilePath);
            }else{
                classNames = readFromDirectory(FilePath);
            }
            for(String Name:classNames){
                if(isClassFile(Name)){
                    classList.add(toFullPathName(scanPath,Name));
                }else {
                    //迭代读取
                    scanPackages(scanPath+"."+"Name",classList);
                }
            }
            return classList;
        }

        public boolean isClassFile(String file){
            return  file.endsWith(".class");
        }
        //这里去掉文件后缀
        public String toFullPathName(String packagePath,String fileName){
            //
            StringBuilder stringBuilder = new StringBuilder(packagePath);
            stringBuilder.append(".");

            int pos = fileName.indexOf('.');
            //去掉TestController.class 的后缀
            if (-1 != pos) {
                stringBuilder.append(fileName.substring(0, pos)) ;
            }
            else {
                stringBuilder.append(fileName);
            }
            return stringBuilder.toString();


        }



    /**
     * "file:/home/whf/cn/fh" -> "/home/whf/cn/fh"
     * "jar:file:/home/whf/foo.jar!cn/fh" -> "/home/whf/foo.jar"
     */
        public String getFilePath(URL urlPath){
            String urlFile = urlPath.getFile();
            int pos = urlFile.indexOf("!");
            if(-1 == pos){
                return urlFile;
            }
            //去掉  "file:"
            return urlFile.substring(5,pos);
        }

    /**
     * 判断是否jar文件
     * @param FilePath
     * @return
     */
    public Boolean isJarPath(String FilePath){
            return  FilePath.endsWith(".jar");
        }

    /**
     * 读取jar包里的东西
     * @param jarPath
     * @return
     * @throws IOException
     */
        public List<String> readFromJarFile(String jarPath) throws IOException {
            //遍历读取jar包
            JarInputStream jarIn = new JarInputStream(new FileInputStream(jarPath));
            JarEntry jarEntry = jarIn.getNextJarEntry();
            List<String> names = new ArrayList<String>();

            while(jarEntry != null){
                String name = jarEntry.getName();
                if(isClassFile(name)){
                    names.add(name);
                }
                jarEntry= jarIn.getNextJarEntry();
            }


            return names;
        }

    /**
     *  从文件目录读取文件
     * @param FilePath
     * @return
     */
    public List<String> readFromDirectory(String FilePath){
            //根据路径获取文件对象
            File file = new File(FilePath);
            String[] names = file.list();
            if(names == null){
                return null;
            }
            return Arrays.asList(names);
    }

}
