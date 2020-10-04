package com.base.bawbaw.model;

public class vaccineModel {
    private int vacId;
    private String vacName, vacDes;
    private long vacStart, vacEnd;

    public vaccineModel(){

    }

    public vaccineModel(int vacId, String vacName, String vacDes, long vacStart, long vacEnd) {
        this.vacId = vacId;
        this.vacName = vacName;
        this.vacDes = vacDes;
        this.vacStart = vacStart;
        this.vacEnd = vacEnd;
    }

    public vaccineModel(String vacName, String vacDes, long vacStart, long vacEnd) {
        this.vacName = vacName;
        this.vacDes = vacDes;
        this.vacStart = vacStart;
        this.vacEnd = vacEnd;
    }

    public int getVacId() {
        return vacId;
    }

    public void setVacId(int vacId) {
        this.vacId = vacId;
    }

    public String getVacName() {
        return vacName;
    }

    public void setVacName(String vacName) {
        this.vacName = vacName;
    }

    public String getVacDes() {
        return vacDes;
    }

    public void setVacDes(String vacDes) {
        this.vacDes = vacDes;
    }

    public long getVacStart() {
        return vacStart;
    }

    public void setVacStart(long vacStart) {
        this.vacStart = vacStart;
    }

    public long getVacEnd() {
        return vacEnd;
    }

    public void setVacEnd(long vacEnd) {
        this.vacEnd = vacEnd;
    }
}
