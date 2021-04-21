package com.atlassian.tutorial.macro;


import org.radeox.macro.parameter.MacroParameter;

import java.util.*;

public class ConnectionDepResult<T> {
    public boolean success;
    public String message;
    public String domain;
    public String query;
    public String depUrl;
    public int total;
    public T data;
    public String filterId;
    public LinkedHashMap<String,String> expandColumns;
    public void ConnectionDepResult(){
        this.success=true;
    }
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }


    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getDepUrl() {
        return depUrl;
    }

    public void setDepUrl(String depUrl) {
        this.depUrl = depUrl;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getFilterId() {
        return filterId;
    }

    public void setFilterId(String filterId) {
        this.filterId = filterId;
    }

    public LinkedHashMap<String, String> getExpandColumns() {
        return expandColumns;
    }

    public void setExpandColumns(LinkedHashMap<String, String> expandColumns) {
        this.expandColumns = expandColumns;
    }
}
