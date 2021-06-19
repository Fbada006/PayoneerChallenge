package com.payoneer.payoneerchallenge.network.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ApplicableItem {

    private String recurrence;

    private boolean redirect;

    private String code;

    private String method;

    private String registration;

    private String operationType;

    private String label;

    private String grouping;

    private boolean selected;

    private List<InputElementsItem> inputElements;

    public String getRecurrence() {
        return recurrence;
    }

    public boolean isRedirect() {
        return redirect;
    }

    public String getCode() {
        return code;
    }

    public String getMethod() {
        return method;
    }

    public String getRegistration() {
        return registration;
    }

    public String getOperationType() {
        return operationType;
    }

    public String getLabel() {
        return label;
    }

    public String getGrouping() {
        return grouping;
    }

    public boolean isSelected() {
        return selected;
    }

    public List<InputElementsItem> getInputElements() {
        return inputElements;
    }
}