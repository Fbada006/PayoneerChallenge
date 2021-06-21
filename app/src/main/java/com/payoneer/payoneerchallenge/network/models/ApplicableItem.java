package com.payoneer.payoneerchallenge.network.models;

import java.util.List;
import java.util.Objects;

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

    private Links links;

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

    public Links getLinks() {
        return links;
    }

    public boolean isSelected() {
        return selected;
    }

    public List<InputElementsItem> getInputElements() {
        return inputElements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ApplicableItem)) return false;
        ApplicableItem item = (ApplicableItem) o;
        return isRedirect() == item.isRedirect() &&
                isSelected() == item.isSelected() &&
                getRecurrence().equals(item.getRecurrence()) &&
                getCode().equals(item.getCode()) &&
                getMethod().equals(item.getMethod()) &&
                getRegistration().equals(item.getRegistration()) &&
                getOperationType().equals(item.getOperationType()) &&
                getLabel().equals(item.getLabel()) &&
                getGrouping().equals(item.getGrouping()) &&
                getLinks().equals(item.getLinks()) &&
                getInputElements().equals(item.getInputElements());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getRecurrence(), isRedirect(), getCode(), getMethod(), getRegistration(), getOperationType(), getLabel(), getGrouping(), isSelected(), getLinks(), getInputElements());
    }
}