package cn.ccs.ssh;

/**
 * @author ccs
 */
public class Disk {
    private Float total;
    private Float used;

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Float getUsed() {
        return used;
    }

    public void setUsed(Float used) {
        this.used = used;
    }

    @Override
    public String toString() {
        return "Disk{" +
                "total=" + total +
                ", used=" + used +
                '}';
    }
}
