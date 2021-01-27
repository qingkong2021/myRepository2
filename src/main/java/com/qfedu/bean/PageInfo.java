package com.qfedu.bean;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo<T> {
    private Integer currentPage;//当前页数
    private Long totalPage;//总页数
    private Long totalSize;//总记录数
    private Integer pageSize;//每页记录数
    private List<T> list;//当前页数据

}
