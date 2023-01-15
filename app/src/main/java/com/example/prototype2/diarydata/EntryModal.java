package com.example.prototype2.diarydata;

public class EntryModal {
    // variables for our entryname,
    // entryDate, entryDescription and id.
    private String entryName;
    private String entryDate;
    private String entryDescription;
    private int id;

    public String getEntryName() {
        return entryName;
    }

    public void setEntryName(String entryName) {
        this.entryName = entryName;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public String getEntryDescription() {
        return entryDescription;
    }

    public void setEntryDescription(String entryDescription) {
        this.entryDescription = entryDescription;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public EntryModal(String entryName, String entryDate,  String entryDescription) {
        this.entryName = entryName;
        this.entryDate = entryDate;
        this.entryDescription = entryDescription;
    }
}
