package com.payoneer.payoneerchallenge.network.models;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Networks {

    @SerializedName("applicable")
    private List<ApplicableItem> applicableItems;

    public Networks(List<ApplicableItem> applicableItems) {
        this.applicableItems = applicableItems;
    }

    public List<ApplicableItem> getApplicable() {
        return applicableItems;
    }
}