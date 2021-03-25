package com.hyd.financial.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/3/22 18:49
 */
@Slf4j
public class CodeGenerator {
    public static final String ENTITY_PATH="C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-base-dao\\src\\main\\java\\com\\hyd\\financial\\entity";
    public static final String VO_PATH="C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-base-dao\\src\\main\\java\\com\\hyd\\financial\\entity\\vo";
    public static final String DTO_PATH="C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-server\\src\\main\\java\\com\\hyd\\financial\\web\\dto";
    public static final String QO_PATH="C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-server\\src\\main\\java\\com\\hyd\\financial\\web\\qo";

    public static final String ENTITY_PACKAGE_NAME="com.hyd.financial.entity";
    public static final String VO_PACKAGE_NAME="com.hyd.financial.entity.vo";
    public static final String DTO_PACKAGE_NAME="com.hyd.financial.web.dto";
    public static final String QO_PACKAGE_NAME="com.hyd.financial.web.qo";

    public static final String MAPPER_PATH = "C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-server\\src\\main\\java\\com\\hyd\\financial\\dao";
    public static final String SERVICE_PATH="C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-server\\src\\main\\java\\com\\hyd\\financial\\service";
    public static final String SERVICE_IMPL_PATH="C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-server\\src\\main\\java\\com\\hyd\\financial\\service\\impl";
    public static final String CONTROLLER_PATH="C:\\work\\graduation-project\\nontax-financial-service\\nontax-financial-service-server\\src\\main\\java\\com\\hyd\\financial\\web";

    public static final String MAPPER_PACKAGE_NAME="com.hyd.financial.dao";
    public static final String SERVICE_PACKAGE_NAME="com.hyd.financial.service";
    public static final String SERVICE_IMPL_PACKAGE_NAME="com.hyd.financial.service.impl";
    public static final String CONTROLLER_PACKAGE_NAME="com.hyd.financial.web";

    public static final String MAPPER_TEMPLATE_PATH="C:\\Users\\test\\Desktop\\template\\ENTITY_NAMEMapper.java";
    public static final String SERVICE_TEMPLATE_PATH="C:\\Users\\test\\Desktop\\template\\IENTITY_NAMEService.java";
    public static final String SERVICE_IMPL_TEMPLATE_PATH="C:\\Users\\test\\Desktop\\template\\ENTITY_NAMEService.java";
    public static final String CONTROLLER_TEMPLATE_PATH="C:\\Users\\test\\Desktop\\template\\ENTITY_NAMEController.java";

    public static final String CONTROLLER_URL="/ticket/store";
    public static final String ENTITY_NAME="TicketStore";
    public static final String ENTITY_NAME_CAMEL_CASE="ticketStore";
    public static final String ENTITY_NAME_CHINESE="票据库存";

    public static void generate() throws IOException {
        File entityFile = new File(ENTITY_PATH + "\\" + ENTITY_NAME + ".java");
        File dtoFile = new File(DTO_PATH + "\\" + ENTITY_NAME + "DTO.java");
        File voFile = new File(VO_PATH + "\\" + ENTITY_NAME + "VO.java");
        File qoFile = new File(QO_PATH + "\\" + ENTITY_NAME + "QO.java");

        copyPoJo(entityFile,dtoFile,ENTITY_NAME,ENTITY_NAME+"DTO",DTO_PACKAGE_NAME);
        copyPoJo(entityFile,voFile,ENTITY_NAME,ENTITY_NAME+"VO",VO_PACKAGE_NAME);
        copyPoJo(entityFile,qoFile,ENTITY_NAME,ENTITY_NAME+"QO",QO_PACKAGE_NAME);

        File mapperTemplateFile = new File(MAPPER_TEMPLATE_PATH);
        File serviceTemplateFile = new File(SERVICE_TEMPLATE_PATH);
        File serviceImplTemplateFile = new File(SERVICE_IMPL_TEMPLATE_PATH);
        File controllerTemplateFile = new File(CONTROLLER_TEMPLATE_PATH);

        File mapperFile = new File(MAPPER_PATH + "\\" + ENTITY_NAME + "Mapper.java");
        File serviceFile = new File(SERVICE_PATH + "\\I" + ENTITY_NAME + "Service.java");
        File serviceImplFile = new File(SERVICE_IMPL_PATH + "\\" + ENTITY_NAME + "Service.java");
        File controllerFile = new File(CONTROLLER_PATH + "\\" + ENTITY_NAME + "Controller.java");

        copy(mapperTemplateFile,mapperFile,MAPPER_PACKAGE_NAME);
        copy(serviceTemplateFile,serviceFile,SERVICE_PACKAGE_NAME);
        copy(serviceImplTemplateFile,serviceImplFile,SERVICE_IMPL_PACKAGE_NAME);
        copy(controllerTemplateFile,controllerFile,CONTROLLER_PACKAGE_NAME);
    }
    public static void copyPoJo(File src,File des,String target,String replace,String packageName) throws IOException {
        List<String> lines = FileUtils.readLines(src, "UTF-8");
        lines.set(0,lines.get(0).replace(ENTITY_PACKAGE_NAME,packageName));
        for (int i = 1; i < lines.size(); i++) {
            lines.set(i,lines.get(i).replace(target,replace));
        }
        FileUtils.writeLines(des,lines);
        log.info(des.getName()+"生成完毕");
    }
    public static void copy(File src,File des,String packageName) throws IOException {
        List<String> lines = FileUtils.readLines(src, "UTF-8");
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            line = line.replace("PACKAGE_NAME", packageName);
            line = line.replace("CREATED_DATE", LocalDate.now().format(DateTimeFormatter.ISO_DATE));
            line = line.replace("ENTITY_NAME",ENTITY_NAME);
            line = line.replace("CAMEL_CASE",ENTITY_NAME_CAMEL_CASE);
            line = line.replace("CHINESE",ENTITY_NAME_CHINESE);
            line = line.replace("CONTROLLER_URL",CONTROLLER_URL);
            line = line.replace("ENTITY_PN",ENTITY_PACKAGE_NAME);
            lines.set(i,line);
        }
        FileUtils.writeLines(des,lines);
        log.info(des.getName()+"生成完毕");
    }
    public static void main(String[] args) {
        try {
            generate();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private CodeGenerator(){}

}
