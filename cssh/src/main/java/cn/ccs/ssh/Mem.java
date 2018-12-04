package cn.ccs.ssh;

public class Mem {
    private Integer totalMem;
    private Integer usedMem;

    private Integer swapTotalMem;
    private Integer swapUsedMem;

    public Integer getTotalMem() {
        return totalMem;
    }

    public void setTotalMem(Integer totalMem) {
        this.totalMem = totalMem;
    }

    public Integer getUsedMem() {
        return usedMem;
    }

    public void setUsedMem(Integer usedMem) {
        this.usedMem = usedMem;
    }

    public Integer getSwapTotalMem() {
        return swapTotalMem;
    }

    public void setSwapTotalMem(Integer swapTotalMem) {
        this.swapTotalMem = swapTotalMem;
    }

    public Integer getSwapUsedMem() {
        return swapUsedMem;
    }

    public void setSwapUsedMem(Integer swapUsedMem) {
        this.swapUsedMem = swapUsedMem;
    }

    @Override
    public String toString() {
        return "Mem{" +
                "totalMem=" + totalMem +
                ", usedMem=" + usedMem +
                ", swapTotalMem=" + swapTotalMem +
                ", swapUsedMem=" + swapUsedMem +
                '}';
    }
}
