package com.helloworld.easyexcel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Builder
@Data
@EqualsAndHashCode(callSuper = false)
public class ProjectModel extends BaseRowModel {

    @ExcelProperty(value = {"ID"} , index = 0)
    private int id ;

    @ExcelProperty(value = "name" ,index = 1)
    private String name;

    @ExcelProperty(value = "desc",index = 2)
    private String desc;
}
