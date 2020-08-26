package cn.jzteam.dao.generate;

import cn.org.rapid_framework.generator.Generator;
import cn.org.rapid_framework.generator.GeneratorFacade;
import cn.org.rapid_framework.generator.GeneratorProperties;
import cn.org.rapid_framework.generator.provider.db.table.TableFactory;
import cn.org.rapid_framework.generator.provider.db.table.model.Column;
import cn.org.rapid_framework.generator.provider.db.table.model.Table;
import cn.org.rapid_framework.generator.util.GeneratorException;

import java.util.LinkedHashSet;
import java.util.List;

/**
 * 代码自动生成工具。
 */
public class GeneratorMain {

    /**
     * 请直接修改以下代码调用不同的方法以执行相关生成任务.
     */
    public static void main(String[] args) throws Exception {
        GeneratorFacade genFacade = new GeneratorFacade();

         // 打印数据库中的表名称
//         GeneratorFacade.printAllTableNames();

        // 删除生成器的输出目录
        genFacade.deleteOutRootDir();

        // 设置模版文件所在的路径。
        genFacade.getGenerator().addTemplateRootDir("classpath:/template_okcoin_users");

        // 自定义枚举
        String templateFullName = "java/${basepackage_dir}/common/enums/Enum${className}${tinyEnumName}.java";

        // 排除枚举类的模板
        genFacade.getGenerator().setExcludes(templateFullName);

        String[] tableNames = new String[]{"user_novice_reward_config", "user_novice_reward_record", "user_novice_special", "user_novice_zone_country", "partner_config", "partner_earnings_daily", "user_invitation_reward"};

        // 通过数据库表生成文件,template为模板的根目录
        genFacade.generateByTable(tableNames);

        // 生成枚举
        for (String tableName : tableNames) {
            Table table = TableFactory.getInstance().getTable(tableName);
            Generator.GeneratorModel m = GeneratorFacade.GeneratorModelUtils.newGeneratorModel("table", table);
            LinkedHashSet<Column> columns = table.getColumns();
            for (Column column : columns) {
                // 自定义：tinyint类型都是可穷举的，应该定义成枚举
                if (column.getJdbcSqlTypeName().equalsIgnoreCase("tinyint")) {
                    m.templateModel.put("tinyEnumName", column.getColumnName());
                    m.filePathModel.put("tinyEnumName", column.getColumnName());
                    FreemakerUtil.process(templateFullName, m.templateModel, m.filePathModel);
                }
            }
        }

        // 自动搜索数据库中的所有表并生成文件。
//        genFacade.generateByAllTable();

        // 根据指定的对象类生成文件。
        // genFacade.generateByClass(User.class);

        // 删除生成的文件
        // genFacade.deleteByTable("remit_transaction");

        //打开文件夹
        Runtime.getRuntime().exec("open " + GeneratorProperties.getRequiredProperty("outRoot"));
    }
    
}
