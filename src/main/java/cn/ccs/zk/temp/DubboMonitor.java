package cn.ccs.zk.temp;

/**
 * Created by chaichuanshi on 2016/12/9.
 */
public class DubboMonitor {
    private String anyhost;
    private String application;
    private String defaultGroup;
    private String dubbo;
    private String dubboInterface;
    private String methods;
    private String pid;
    private String revision;
    private String side;
    private String timestamp;

    public String getAnyhost() {
        return anyhost;
    }

    public void setAnyhost(String anyhost) {
        this.anyhost = anyhost;
    }

    public String getApplication() {
        return application;
    }

    public void setApplication(String application) {
        this.application = application;
    }

    public String getDefaultGroup() {
        return defaultGroup;
    }

    public void setDefaultGroup(String defaultGroup) {
        this.defaultGroup = defaultGroup;
    }

    public String getDubbo() {
        return dubbo;
    }

    public void setDubbo(String dubbo) {
        this.dubbo = dubbo;
    }

    public String getDubboInterface() {
        return dubboInterface;
    }

    public void setDubboInterface(String dubboInterface) {
        this.dubboInterface = dubboInterface;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getRevision() {
        return revision;
    }

    public void setRevision(String revision) {
        this.revision = revision;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
