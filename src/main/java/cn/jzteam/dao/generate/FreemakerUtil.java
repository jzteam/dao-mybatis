package cn.jzteam.dao.generate;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.util.*;
import freemarker.cache.FileTemplateLoader;
import freemarker.cache.MultiTemplateLoader;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.*;
import java.util.*;

public class FreemakerUtil {

    public static final String sourceEncoding = "UTF-8";
    public static final String outputEncoding = "UTF-8";

    public static final String templateRootDir = "classpath:/template_okcoin_users";

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
        Writer out = new BufferedWriter(new OutputStreamWriter(fos, outputEncoding),10240);
        template.process(dataMap,out);
    }

    public static void process(String templateFullName, Map templateModel, Map filePathModel) {
        List<File> templateRootDirs = new ArrayList<>();
        templateRootDirs.add(FileHelper.getFile(templateRootDir));
        try {
            //生成 路径值,如 pkg=com.company.project 将生成 pkg_dir=com/company/project的值
            templateModel.putAll(getDirValuesMap(templateModel));
            filePathModel.putAll(getDirValuesMap(filePathModel));
            // 模板文件
            Template template = newFreeMarkerConfiguration(templateRootDirs, sourceEncoding, templateFullName).getTemplate(templateFullName);
            template.setOutputEncoding(outputEncoding);
            // 输出文件
            String outputFilepath = proceeForOutputFilepath(templateRootDirs, filePathModel, templateFullName);
            outputFilepath = filePathModel.get("outRoot_dir") + "/" + outputFilepath;
            File absoluteOutputFilePath = FileHelper.parentMkdir(outputFilepath);
            // 执行
            FreemarkerHelper.processTemplate(template, templateModel, absoluteOutputFilePath, outputEncoding);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Configuration newFreeMarkerConfiguration(List<File> templateRootDirs, String defaultEncoding, String templateName)
            throws IOException {
        Configuration conf = new Configuration();

        FileTemplateLoader[] templateLoaders = new FileTemplateLoader[templateRootDirs.size()];
        for (int i = 0; i < templateRootDirs.size(); i++) {
            templateLoaders[i] = new FileTemplateLoader((File) templateRootDirs.get(i));
        }
        MultiTemplateLoader multiTemplateLoader = new MultiTemplateLoader(templateLoaders);

        conf.setTemplateLoader(multiTemplateLoader);
        conf.setNumberFormat("###############");
        conf.setBooleanFormat("true,false");
        conf.setDefaultEncoding(defaultEncoding);

        List<String> autoIncludes = getParentPaths(templateName, "macro.include");
        List<String> availableAutoInclude = FreemarkerHelper.getAvailableAutoInclude(conf, autoIncludes);
        conf.setAutoIncludes(availableAutoInclude);
        return conf;
    }

    public static List<String> getParentPaths(String templateName, String suffix) {
        String array[] = StringHelper.tokenizeToStringArray(templateName, "\\/");
        List<String> list = new ArrayList<String>();
        list.add(suffix);
        list.add(File.separator + suffix);
        String path = "";
        for (int i = 0; i < array.length; i++) {
            path = path + File.separator + array[i];
            list.add(path + File.separator + suffix);
        }
        return list;
    }

    /**
     * 处理文件路径的变量变成输出路径
      * @param templateRootDirs
     * @param filePathModel
     * @param templateFile
     * @return
     * @throws IOException
     */
    public static String proceeForOutputFilepath(List<File> templateRootDirs, Map filePathModel, String templateFile)
            throws IOException {
        String outputFilePath = templateFile;

        Configuration conf = newFreeMarkerConfiguration(templateRootDirs, sourceEncoding, "/filepath/processor/");

        //使freemarker支持过滤,如 ${className?lower_case} 现在为 ${className^lower_case}
        outputFilePath = outputFilePath.replace('^', '?');
        return FreemarkerHelper.processTemplateString(outputFilePath, filePathModel, conf);
    }

    /**
     * 设置路径变量
     * @param map
     * @return
     */
    public static Map getDirValuesMap(Map map) {
        Map dirValues = new HashMap();
        Set<Object> keys = map.keySet();
        for (Object key : keys) {
            Object value = map.get(key);
            if (key instanceof String && value instanceof String) {
                String dirKey = key + "_dir";
                String dirValue = value.toString().replace('.', '/');
                dirValues.put(dirKey, dirValue);
            }
        }
        return dirValues;
    }

}
