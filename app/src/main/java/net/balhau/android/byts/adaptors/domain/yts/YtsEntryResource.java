package net.balhau.android.byts.adaptors.domain.yts;

/**
 * Created by balhau on 1/14/17.
 */

public class YtsEntryResource {
    private String description;
    private String url;
    private String value;

    public YtsEntryResource(){}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
