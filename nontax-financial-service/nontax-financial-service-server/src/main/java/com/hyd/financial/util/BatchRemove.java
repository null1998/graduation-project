package com.hyd.financial.util;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author yanduohuang
 * @date 2021/4/28 21:32
 */
public class BatchRemove {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\work\\graduation-project\\user-center\\user-center-server\\src\\main\\java\\com\\hyd\\user\\center\\web\\qo");
        help(file);

    }
    public static void help(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File file1 : files) {
                help(file1);
            }
        } else {
            remove(file);
        }
    }
    public static void remove(File file) throws IOException  {
        List<String> lines = FileUtils.readLines(file, "UTF-8");
        ArrayList<String> list = new ArrayList<>();
        for (String line : lines) {
            if (!line.contains("@Generated")){
                list.add(line);
            }
        }
        FileUtils.writeLines(file, list);
    }
}
