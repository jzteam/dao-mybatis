package cn.jzteam.dao.generate;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.Map;

public class FreemakerUtil {

    //主要的方法来了
    public static void generateFileByTemplate(final String templateName, File file, Map<String,Object> dataMap) throws Exception{
        //new 一个cfg
        Configuration cfg = new Configuration();
        //获取我们的模板类。这里有写了两种，注释掉的是通过绝对路径，下面一个是通过类路径。
//        cfg.setDirectoryForTemplateLoading(new File("/Users/liuwei/mysqllogs"));
        //这个/template是在我们resources目录下的一个文件夹名，然后吧模板类EnumClass.ftl放在这个文件夹下面就好
        cfg.setClassForTemplateLoading(FreemakerUtil.class,"/template");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        Template template = cfg.getTemplate(templateName);
        FileOutputStream fos = new FileOutputStream(file);
        //其他的参数
//        dataMap.put("date", CURRENT_DATE);
//        dataMap.put("package_name", packageName);
//        dataMap.put("enum_class_name", enumClassName);
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, "utf-8"),10240);
        template.process(dataMap,out);
    }
}
