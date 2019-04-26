package com.helloworld.easyexcel;

import com.alibaba.excel.EasyExcelFactory;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

public class EasyExcelRunner {

    public static void main(String[] args) throws FileNotFoundException {

        OutputStream out = new FileOutputStream("78.xlsx");

        ExcelWriter writer = EasyExcelFactory.getWriter(out, ExcelTypeEnum.XLSX , true);
        Sheet sheet = new Sheet(1, 3, ProjectModel.class);
        writer.write(getData(), sheet);
        writer.finish();


    }

    private static List<? extends BaseRowModel> getData() {
        List<ProjectModel> list = new ArrayList<>();

        list.add(ProjectModel.builder().id(1).name("test").desc("描述").build());
        list.add(ProjectModel.builder().id(1).name("test").desc("描述").build());
        list.add(ProjectModel.builder().id(1).name("test").desc("描述").build());

        return list;
    }


}
