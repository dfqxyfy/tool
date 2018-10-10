
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.Cell;
import org.apache.hadoop.hbase.CellUtil;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.ZooKeeperConnectionException;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Delete;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.util.Bytes;

public class HBaseTest {

	// 声明静态配置，配置zookeeper
	static Configuration configuration = null;
	static Connection connection = null;
	static {
		configuration = HBaseConfiguration.create();
		configuration.set("hbase.zookeeper.quorum", "study-90:2181,study-91:2181,study-92:2181");
		try {
			connection = ConnectionFactory.createConnection(configuration);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 创建表
	 * 
	 * @param tableName
	 */
	public static void createTable(String tableStr, String[] familyNames) {
		System.out.println("start create table ......");
		try {
			Admin admin = connection.getAdmin();
			TableName tableName = TableName.valueOf(tableStr);
			if (admin.tableExists(tableName)) {// 如果存在要创建的表，那么先删除，再创建
				admin.disableTable(tableName);
				admin.deleteTable(tableName);
				System.out.println(tableName + " is exist,detele....");
			}
			HTableDescriptor tableDescriptor = new HTableDescriptor(tableName);
			// 添加表列信息
			if (familyNames != null && familyNames.length > 0) {
				for (String familyName : familyNames) {
					tableDescriptor.addFamily(new HColumnDescriptor(familyName));
				}
			}
			admin.createTable(tableDescriptor);
		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end create table ......");
	}

	/**
	 * 添加行列数据数据
	 * 
	 * @param tableName
	 * @throws Exception
	 */
	public static void insertData(String tableName, String rowId, String familyName,String qualifier, String value) throws Exception {
		System.out.println("start insert data ......");
		Table table = connection.getTable(TableName.valueOf(tableName));
		Put put = new Put(rowId.getBytes());// 一个PUT代表一行数据，再NEW一个PUT表示第二行数据,每行一个唯一的ROWKEY，此处rowkey为put构造方法中传入的值
		put.addColumn(familyName.getBytes(), qualifier.getBytes(), value.getBytes());// 本行数据的第一列
		try {
			table.put(put);
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("end insert data ......");
	}

	/**
	 * 删除行
	 * 
	 * @param tablename
	 * @param rowkey
	 */
	public static void deleteRow(String tablename, String rowkey) {
		try {
			Table table = connection.getTable(TableName.valueOf(tablename));
			Delete d1 = new Delete(rowkey.getBytes());
			table.delete(d1);//d1.addColumn(family, qualifier);d1.addFamily(family);
			System.out.println("删除行成功!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 查询所有数据
	 * 
	 * @param tableName
	 * @throws Exception
	 */
	public static void queryAll(String tableName) throws Exception {
		Table table = connection.getTable(TableName.valueOf(tableName));
		try {
			ResultScanner rs = table.getScanner(new Scan());
			for (Result r : rs) {
				System.out.println("获得到rowkey:" + new String(r.getRow()));
				for (Cell keyValue : r.rawCells()) {
					System.out.println("列：" + new String(CellUtil.cloneFamily(keyValue))+":"+new String(CellUtil.cloneQualifier(keyValue)) + "====值:" + new String(CellUtil.cloneValue(keyValue)));
				}
			}
			rs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据rowId查询
	 * 
	 * @param tableName
	 * @throws Exception
	 */
	public static void queryByRowId(String tableName, String rowId) throws Exception {
		Table table = connection.getTable(TableName.valueOf(tableName));
		try {
			Get scan = new Get(rowId.getBytes());// 根据rowkey查询
			Result r = table.get(scan);
			System.out.println("获得到rowkey:" + new String(r.getRow()));
			for (Cell keyValue : r.rawCells()) {
				System.out.println("列：" + new String(CellUtil.cloneFamily(keyValue))+":"+new String(CellUtil.cloneQualifier(keyValue)) + "====值:" + new String(CellUtil.cloneValue(keyValue)));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 根据列条件查询
	 * 
	 * @param tableName
	 */
	public static void queryByCondition(String tableName, String familyName,String qualifier,String value) {

		try {
			Table table = connection.getTable(TableName.valueOf(tableName));
			Filter filter = new SingleColumnValueFilter(Bytes.toBytes(familyName), Bytes.toBytes(qualifier), CompareOp.EQUAL, Bytes.toBytes(value)); // 当列familyName的值为value时进行查询
			Scan s = new Scan();
			s.setFilter(filter);
			ResultScanner rs = table.getScanner(s);
			for (Result r : rs) {
				System.out.println("获得到rowkey:" + new String(r.getRow()));
				for (Cell keyValue : r.rawCells()) {
					System.out.println("列：" + new String(CellUtil.cloneFamily(keyValue))+":"+new String(CellUtil.cloneQualifier(keyValue)) + "====值:" + new String(CellUtil.cloneValue(keyValue)));
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 多条件查询
	 * 
	 * @param tableName
	 */
	public static void queryByConditions(String tableName, String[] familyNames, String[] qualifiers,String[] values) {

		try {
			Table table = connection.getTable(TableName.valueOf(tableName));
			List<Filter> filters = new ArrayList<Filter>();
			if (familyNames != null && familyNames.length > 0) {
				int i = 0;
				for (String familyName : familyNames) {
					Filter filter = new SingleColumnValueFilter(Bytes.toBytes(familyName), Bytes.toBytes(qualifiers[i]), CompareOp.EQUAL, Bytes.toBytes(values[i]));
					filters.add(filter);
					i++;
				}
			}
			FilterList filterList = new FilterList(filters);
			Scan scan = new Scan();
			scan.setFilter(filterList);
			ResultScanner rs = table.getScanner(scan);
			for (Result r : rs) {
				System.out.println("获得到rowkey:" + new String(r.getRow()));
				for (Cell keyValue : r.rawCells()) {
					System.out.println("列：" + new String(CellUtil.cloneFamily(keyValue))+":"+new String(CellUtil.cloneQualifier(keyValue)) + "====值:" + new String(CellUtil.cloneValue(keyValue)));
				}
			}
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除表
	 * 
	 * @param tableName
	 */
	public static void dropTable(String tableStr) {
		try {
			Admin admin = connection.getAdmin();
			TableName tableName = TableName.valueOf(tableStr);
			admin.disableTable(tableName);
			admin.deleteTable(tableName);
			admin.close();
		} catch (MasterNotRunningException e) {
			e.printStackTrace();
		} catch (ZooKeeperConnectionException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		//创建表
		createTable("t_table", new String[]{"f1","f2","f3"});
		//添加数据
		insertData("t_table", "row-0001", "f1","a", "fffaaa");
		insertData("t_table", "row-0001", "f2", "b","fffbbb");
		insertData("t_table", "row-0001", "f3", "c","fffccc");
		insertData("t_table", "row-0002", "f1", "a","eeeeee");
		//查询全部数据
		queryAll("t_table");
		//根据rowid查询数据
		queryByRowId("t_table", "row-0001");
		//列条件查询
		queryByCondition("t_table", "f1","a", "eeeeee");
		//多条件查询
		queryByConditions("t_table", new String[]{"f1","f3"},new String[]{"a","c"}, new String[]{"fffaaa","fffccc"});
		//删除记录
		deleteRow("t_table", "row-0001");
		//删除表
		dropTable("t_table");
	}
}
