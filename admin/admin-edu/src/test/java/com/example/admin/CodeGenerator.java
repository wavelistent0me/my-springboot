package com.example.admin;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class CodeGenerator {
    public static void main(String[] args) {
        //1 代码生成器
        AutoGenerator mpg = new AutoGenerator();

        //2 全局配置
        GlobalConfig gc = new GlobalConfig();
        //TODO:看下相对路径和绝对路径有什么影响
        //相对路径
        //String projectPath = System.getProperty("user.dir");
        //绝对路径
        String projectPath = "C:\\MineApp\\WebProject\\my-springboot\\admin\\admin-edu";
        //生成文件的目录
        gc.setOutputDir(projectPath + "/src/main/java");
        //作者 不重要
        gc.setAuthor("Wave");
        //生成后自动展开文件夹 不重要
        gc.setOpen(false);
        //重新生成时文件是否覆盖 一般false
        gc.setFileOverride(false);

        //去掉Service接口的首字母I
        //gc.setServiceName("%sService");

        //主键策略
        gc.setIdType(IdType.ID_WORKER_STR);
        //gc.setIdType(IdType.ID_WORKER);

        // gc.setSwagger2(true); 实体属性 Swagger2 注解

        mpg.setGlobalConfig(gc);

        //3 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl("jdbc:mysql://localhost:3306/my_project?serverTimezone=GMT%2B8");
        // dsc.setSchemaName("public");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("admin123");
        mpg.setDataSource(dsc);

        //4 生成包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent("com.example");
        pc.setModuleName("admin");
        pc.setController("controller");
        pc.setEntity("entity");
        pc.setService("service");
        pc.setMapper("mapper");
        mpg.setPackageInfo(pc);

        // 自定义配置
        /*InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };*/

        // 如果模板引擎是 freemarker
        //String templatePath = "/templates/mapper.xml.ftl";
        // 如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        //List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        /*focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + pc.getModuleName()
                        + "/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });*/
        /*
        cfg.setFileCreate(new IFileCreate() {
            @Override
            public boolean isCreate(ConfigBuilder configBuilder, FileType fileType, String filePath) {
                // 判断自定义文件夹是否需要创建
                checkDir("调用默认方法创建的目录，自定义目录用");
                if (fileType == FileType.MAPPER) {
                    // 已经生成 mapper 文件判断存在，不想重新生成返回 false
                    return !new File(filePath).exists();
                }
                // 允许生成模板文件
                return true;
            }
        });
        */
        //cfg.setFileOutConfigList(focList);
        //mpg.setCfg(cfg);

        // 配置模板
        //TemplateConfig templateConfig = new TemplateConfig();

        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        // templateConfig.setEntity("templates/entity2.java");
        // templateConfig.setService();
        // templateConfig.setController();

        //templateConfig.setXml(null);
        //mpg.setTemplate(templateConfig);

        //5 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setNaming(NamingStrategy.underline_to_camel); //数据库表映射到实体的命名策略
        strategy.setColumnNaming(NamingStrategy.underline_to_camel); //数据库表字段映射到实体的命名策略
        //strategy.setSuperEntityClass("你自己的父类实体,没有就不用设置!");
        strategy.setEntityLombokModel(true); //lombox 模型 @Accessors(chain = true) setter链式操作
        strategy.setRestControllerStyle(true); //restful api风格控制器
        // 公共父类
        //strategy.setSuperControllerClass("你自己的父类控制器,没有就不用设置!");
        // 写于父类中的公共字段
        //strategy.setSuperEntityColumns("id");

        //执行哪张表
        //strategy.setInclude(scanner("表名，多个英文逗号分割").split(","));
        strategy.setInclude("user");

        strategy.setControllerMappingHyphenStyle(true); //url中驼峰转连字符
        strategy.setTablePrefix(pc.getModuleName() + "_"); //生成实体时去掉表前缀
        mpg.setStrategy(strategy);

        //非默认模板引擎需要设置
        //mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        //6 执行
        mpg.execute();
    }
}
