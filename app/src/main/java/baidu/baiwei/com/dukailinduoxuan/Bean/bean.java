package baidu.baiwei.com.dukailinduoxuan.Bean;

/**
 * Created by Administrator on 2017/5/12 0012.
 */

public class bean {
    private String name;
    private Boolean ischend;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIschend() {
        return ischend;
    }

    public void setIschend(Boolean ischend) {
        this.ischend = ischend;

    }

    public bean(String name, Boolean ischend) {
        this.name = name;
        this.ischend = ischend;
    }
}
