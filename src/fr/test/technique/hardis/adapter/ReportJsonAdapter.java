package fr.test.technique.hardis.adapter;

import com.google.gson.Gson;

import fr.test.technique.hardis.item.Report;

public class ReportJsonAdapter{
	private final Gson gson;

    public ReportJsonAdapter() {
        gson = new Gson();
    }

    public Report toObject(final String json) {
        return gson.fromJson(json, Report.class);
    }

    public String toJson(final Report object) {
        return gson.toJson(object);
    }
}
