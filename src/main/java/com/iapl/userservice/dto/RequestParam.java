package com.iapl.userservice.dto;

import java.util.Arrays;
import java.util.List;

public  class RequestParam {

    public static final int DEFAULT_CURRENT_PAGE = 0;
    public static final int DEFAULT_SIZE = 10;
    public static final String DEFAULT_DIRECTION = "ASC";



    private String currentPage = String.valueOf(DEFAULT_CURRENT_PAGE);
    private String size = String.valueOf(DEFAULT_SIZE);
    private String sortDirection = DEFAULT_DIRECTION;
    private List<String> sortBy = Arrays.asList("id");

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }


    public List<String> getSortBy() {
        return sortBy;
    }

    public void setSortBy(List<String> sortBy) {
        this.sortBy = sortBy;
    }

    public String getSortDirection() {
        return sortDirection;
    }

    public void setSortDirection(String sortDirection) {
        this.sortDirection = sortDirection;
    }

    public void validate(){
        try{
            int currentPage = Integer.parseInt(getCurrentPage());
        }catch (NumberFormatException e){
            setCurrentPage(String.valueOf(DEFAULT_CURRENT_PAGE));
        }

        try{
            int size = Integer.parseInt(getSize());
        }catch (NumberFormatException e){
            setSize(String.valueOf(DEFAULT_SIZE));
        }
    }

    @Override
    public String toString() {
        return "RequestParam{" +
                "currentPage=" + currentPage +
                ", size=" + size +
                ", sortDirection='" + sortDirection + '\'' +
                ", sortBy=" + sortBy +
                '}';
    }
}
