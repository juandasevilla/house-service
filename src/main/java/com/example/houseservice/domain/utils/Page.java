package com.example.houseservice.domain.utils;

import java.util.List;
import java.util.stream.Collectors;

public class Page <T>{
    private List<T> content;
    private int page;
    private int size;
    private long totalElements;
    private int totalPages;
    private boolean orderAsc;
    private long totalObjects;

    public Page(List<T> content, int page, int size, boolean orderAsc, long totalObjects) {
        this.page = page;
        this.size = size;
        this.orderAsc = orderAsc;
        this.totalElements = content.size();
        this.totalPages = (int) Math.ceil((double) totalObjects / size);
        this.content = paginate(content);
        this.totalObjects = totalObjects;

    }

    private List<T> paginate(List<T> content) {
        if (!orderAsc) {
            content = content.stream()
                    .sorted((a, b) -> -1) // Assuming T implements Comparable, otherwise provide a Comparator
                    .collect(Collectors.toList());
        }
        int fromIndex = Math.min(page * size, content.size());
        int toIndex = Math.min((page + 1) * size, content.size());
        return content.subList(fromIndex, toIndex);
    }

    public List<T> getContent() {
        return content;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public boolean isOrderAsc() {
        return orderAsc;
    }

    public long getTotalObjects() {
        return totalObjects;
    }
}
