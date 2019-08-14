package com.dh.fullstack.project.salesservice.commons;

import java.io.Serializable;
import java.util.List;

/**
 * @author Julio Daviu
 */
public class Pagination <T extends Serializable> implements Serializable{

    private List<T> content;

    private Integer totalPages;

    private Long totalElements;

    public List<T> getContent() {
        return content;
    }

    public void setContent(List<T> content) {
        this.content = content;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public Long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(Long totalElements) {
        this.totalElements = totalElements;
    }
}
