/**
 * @author dbxiao
 */
package com.db.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;

public class CreateData {
	String name1,name2,sex;
	public static void main(String[] args) {
		new CreateData().start();
	}
	public void start(){
		//Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement stat = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://192.168.0.87:3306/stup?characterEncoding=utf8&serverTimezone=UTC&user=root&password=");
			stat = conn.createStatement();
			/*ResultSet rs = stat.executeQuery("select * from class");
			while(rs.next()) {
				System.out.println(rs.getString(1)+"|"+rs.getString(2)+"|"+rs.getString(3)+"|");
			}*/
			name1 = new String("赵钱孙李周吴郑王冯陈楮卫蒋沈韩杨朱秦尤许何吕施张孔曹严华金魏陶姜戚谢邹喻柏水窦章云苏潘葛奚范彭郎鲁韦昌马苗凤花方俞任袁柳酆鲍史唐费廉岑薛雷贺倪汤滕殷罗毕郝邬安常乐于时傅皮卞齐康伍余元卜顾孟平黄和穆萧尹姚邵湛汪祁毛禹狄米贝明臧计伏成戴谈宋茅庞熊纪舒屈项祝董梁杜阮蓝闽席季麻强贾路娄危江童颜郭梅盛林刁锺徐丘骆高夏蔡田樊胡凌霍虞万支柯昝管卢莫经房裘缪干解应宗丁宣贲邓郁单杭洪包诸左石崔吉钮龚程嵇邢滑裴陆荣翁荀羊於惠甄麹家封芮羿储靳汲邴糜松井段富巫乌焦巴弓牧隗山谷车侯宓蓬全郗班仰秋仲伊宫宁仇栾暴甘斜厉戎祖武符刘景詹束龙叶幸司韶郜黎蓟薄印宿白怀蒲邰从鄂索咸籍赖卓蔺屠蒙池乔阴郁胥能苍双闻莘党翟谭贡劳逄姬申扶堵冉宰郦雍郤璩桑桂濮牛寿通边扈燕冀郏浦尚农温别庄晏柴瞿阎充慕连茹习宦艾鱼容向古易慎戈廖庾终暨居衡步都耿满弘匡国文寇广禄阙东欧殳沃利蔚越夔隆师巩厍聂晁勾敖融冷訾辛阚那简饶空曾毋沙乜养鞠须丰巢关蒯相查后荆红游竺权逑盖益桓公");
			name2 = new String("一二三四五六七八九十");
			sex = new String("mf");
			long time1 = System.currentTimeMillis();
			batchSql(stat,10000);
			long time2 = System.currentTimeMillis();
			System.out.println("batch time is "+(time2-time1));
			
			stat = conn.createStatement();
			long time3 = System.currentTimeMillis();
			singleSql(stat,10000);
			long time4 = System.currentTimeMillis();
			System.out.println("single time is "+(time4-time3));
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(stat != null) {
				try {
					stat.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				stat = null;
			}
			if(conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				conn = null;
			}
		}
		
	}
	
	public void batchSql(Statement s,int count){
		for(int i = 0;i < count;i++){
			DecimalFormat df = new DecimalFormat("00000");
			int i1 = (int) (name1.length()*Math.random());
			int i2 = (int) (name2.length()*Math.random());
			int i3 = (int) (sex.length()*Math.random());
			int i4 = (int) (1+3*Math.random());
			String sno = "'s2001"+df.format(i)+"'";
			String sname = "'"+name1.substring(i1,i1+1)+name2.substring(i2, i2+1)+"'";
			String ssex = "'"+sex.substring(i3, i3+1)+"'";
			String clno = "'"+"c00"+i4+"'";
			String sql = "insert into student values("+sno+","+sname+","+ssex+","+clno+")";
			try {
				s.addBatch(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		try {
			s.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void singleSql(Statement s,int count){
		for(int i = 0;i < count;i++) {
			DecimalFormat df = new DecimalFormat("00000");
			int i1 = (int) (name1.length()*Math.random());
			int i2 = (int) (name2.length()*Math.random());
			int i3 = (int) (sex.length()*Math.random());
			int i4 = (int) (1+3*Math.random());
			String sno = "'s2002"+df.format(i)+"'";
			String sname = "'"+name1.substring(i1,i1+1)+name2.substring(i2, i2+1)+"'";
			String ssex = "'"+sex.substring(i3, i3+1)+"'";
			String clno = "'"+"c00"+i4+"'";
			String sql = "insert into student values("+sno+","+sname+","+ssex+","+clno+")";
			try {
				s.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
