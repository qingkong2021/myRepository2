package com.qfedu.bean;

//import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Housenumber {
    private int housenum_id;//房产id
    private String housenum_village;//所属小区
    private String housenum_code;//栋数编号
    private String housenum_name;//栋数名称
    private String housenum_hushu;//总户数
    private String housenum_remark;//备注
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date housenum_createtime;//创建时间
}
