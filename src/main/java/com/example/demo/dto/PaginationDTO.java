package com.example.demo.dto;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class PaginationDTO {
    private List<QuestionDTO> questions;
    private boolean showPrev = true;
    private boolean showNext = true;
    private boolean showFirstPage = true;
    private boolean showEndPage = true;
    private Integer page;
    private Integer totalPage;
    private List<Integer> pages = new ArrayList<>();

    public void setPagination(Integer totalCnt, Integer page, Integer size) {
        this.totalPage = (totalCnt % size == 0) ? totalCnt / size : totalCnt / size + 1;

        page = Math.max(page, 1);
        page = Math.min(page, totalPage);
        this.page = page;

        Integer len = 3; // prev 3 and next 3 if not out of bound
        pages.add(page);
        for (int i = 1; i <= len; i++) {
            if (page - i > 0) pages.add(0,page - i);
            if (page + i <= totalPage) pages.add(page + i);
        }

        if (page.equals(1)) showPrev = false;
        if (page.equals(totalPage)) showNext = false;

        if (page - 1 <= len) showFirstPage = false;
        if (totalPage - page <= len) showEndPage = false;
    }
}
