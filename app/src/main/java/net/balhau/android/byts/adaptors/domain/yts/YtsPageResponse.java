package net.balhau.android.byts.adaptors.domain.yts;

import java.util.List;

/**
 * Created by balhau on 1/14/17.
 */

public class YtsPageResponse {
    private List<YtsEntry> message;
    private Boolean error;
    private String statusMessage;

    public YtsPageResponse(){

    }

    public List<YtsEntry> getMessage() {
        return message;
    }

    public void setMessage(List<YtsEntry> message) {
        this.message = message;
    }

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
}
