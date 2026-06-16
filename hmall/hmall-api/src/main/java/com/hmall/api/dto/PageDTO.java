package com.hmall.api.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageDTO<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 数据列表 */
    private List<T> records;

    /** 总记录数 */
    private Long total;

    /** 当前页码 */
    private Long pageNum;

    /** 每页大小 */
    private Long pageSize;

    /** 总页数 */
    private Long pages;

    public static <T> PageDTO<T> of(Page<T> page) {
        PageDTO<T> dto = new PageDTO<>();
        dto.setRecords(page.getRecords());
        dto.setTotal(page.getTotal());
        dto.setPageNum(page.getCurrent());
        dto.setPageSize(page.getSize());
        dto.setPages(page.getPages());
        return dto;
    }
}
