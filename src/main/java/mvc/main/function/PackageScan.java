package mvc.main.function;

import org.springframework.beans.factory.wiring.ClassNameBeanWiringInfoResolver;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

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
        public   List<String> getAllClassNamesFromPackage(){

            return scanPackages(packages,new ArrayList<String>());
        }

        public List<String> scanPackages(String scanPath,List<String> classList){

            // 点换成斜线
            //String splashPath = scanPath.replaceAll("\\.","/");
            //得到URL路径  是file:/开头
            URL url = classLoader.getResource(scanPath);
            String FilePath =getFilePath(url);
            //是jar包还是 文件目录
            List<String> classNames;
            if(isJarPath(FilePath)){
                classNames = readFromJarFile(FilePath);
            }else{
                classNames = readFromDirectory(FilePath);
            }


            return classList;
        }


        public String getFilePath(URL urlPath{

            String a = "1";

            return a;
        }

        public Boolean isJarPath(String FilePath){


            return true;
        }


        public List<String> readFromJarFile(String FilaPath){
            List<String> classNames = new ArrayList<String>();

            return classNames;
        }
        public List<String> readFromDirectory(String FilaPath){
        List<String> classNames = new ArrayList<String>();

        return classNames;
    }

}
