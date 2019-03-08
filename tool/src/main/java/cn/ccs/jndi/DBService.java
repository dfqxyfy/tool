package cn.ccs.jndi;

public interface DBService {
    String getLocation(); //获取数据库位置

    String getState(); //获取数据库状态

    void accessDB(); //访问数据库

    void setProperty(int index, String property); //设置数据库信息
}