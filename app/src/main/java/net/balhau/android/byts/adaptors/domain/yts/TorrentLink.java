package net.balhau.android.byts.adaptors.domain.yts;

/**
 * Created by balhau on 1/15/17.
 */

public class TorrentLink {
    private String descricao;
    private String url;

    public TorrentLink(){}

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
