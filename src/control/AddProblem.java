package control;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import databasecon.PostgreSQLcon;

public class AddProblem {

	static int id;
	static String ur = "http://poj.org/problem?id=";

	public static void Select(int id) throws IOException {
		// TODO Auto-generated method stub
		String ID = Integer.toString(id);
		String url = ur + ID;
		Document doc = Jsoup.connect(url).timeout(20000).userAgent(
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/58.0.3029.110 Safari/537.36 Edge/16.16299")
				.get();

		String title = doc.select("body > table:nth-child(3) > tbody > tr > td > div.ptt").text();
		// String tmta=doc.select("body > table:nth-child(3) > tbody > tr > td > div.plm
		// > table > tbody").toString();
		String des = doc.select("body > table:nth-child(3) > tbody > tr > td > div:nth-child(5)").toString();
		String description = des.replaceAll("\\t|\\n|\\r", "");
		String input_des = doc.select("body > table:nth-child(3) > tbody > tr > td > div:nth-child(7)").toString();
		String input_description = input_des.replaceAll("\t|\n|\r", "");
		String output_des = doc.select("body > table:nth-child(3) > tbody > tr > td > div:nth-child(9)").toString();
		String output_description = output_des.replaceAll("\\t|\\n|\\r", "");

		String samples;
		String sample_in = doc.select("body > table:nth-child(3) > tbody > tr > td > pre:nth-child(11)").text();
		String sample_out = doc.select("body > table:nth-child(3) > tbody > tr > td > pre:nth-child(13)").text();
		String sample_input = sample_in.replaceAll("\n|\r|\t", "");
		String sample_output = sample_out.replaceAll("\n|\r|\t", "");
		JsonUtil stu = new JsonUtil();
		stu.put("input", sample_input);
		stu.put("output", sample_output);
		samples = stu.toString();
		// System.out.println(samples);
		String test_case_id;
		// RandomUtil random=new RandomUtil();
		test_case_id = RandomUtil.generate();
		Makedir md = new Makedir();
		md.makedir(test_case_id,sample_input,sample_output);

		String test_case_score;
		JsonUtil stu1 = new JsonUtil();
		stu1.put("score", "100");
		stu1.put("input_name", "1.in");
		stu1.put("output_name", "1.out");
		test_case_score = stu1.toString();

		String hint = doc.select("body > table:nth-child(3) > tbody > tr > td > div:nth-child(15)").text();
		String source = doc.select("body > table:nth-child(3) > tbody > tr > td > div:nth-child(17)").text();
		if (source == null || "".equals(source)) {
			source = doc.select("body > table:nth-child(3) > tbody > tr > td > div:nth-child(15)").text();
			hint = doc.select("body > table:nth-child(3) > tbody > tr > td > div:nth-child(17)").text();
		}
		String languages = "[\"C++\",\"Python2\",\"Python3\",\"Java\",\"C\"]";
		/*
		 * JsonUtil stu2 = new JsonUtil(); stu2.put("l1", "C++"); stu2.put("l2",
		 * "Python2"); stu2.put("l3", "Python3"); stu2.put("l4", "Java"); stu2.put("l5",
		 * "C"); languages = stu2.toString();
		 */

		String template;
		JsonUtil stu3 = new JsonUtil();
		template = stu3.toString();

		String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date());// 将时间格式转换成符合Timestamp要求的格式.
		Timestamp create_time = Timestamp.valueOf(nowTime);// 把时间转换timestamp

		String time_li = doc.select(
				"body > table:nth-child(3) > tbody > tr > td > div.plm > table > tbody > tr:nth-child(1) > td:nth-child(1)")
				.text();
		Pattern p = Pattern.compile("\\d+");
		Matcher m = p.matcher(time_li);
		int time_limit = 0;
		if (m.find()) {
			time_limit = Integer.parseInt(m.group(0).trim());
		}

		String memory_li = doc.select(
				"body > table:nth-child(3) > tbody > tr > td > div.plm > table > tbody > tr:nth-child(1) > td:nth-child(3)")
				.text();
		Pattern p1 = Pattern.compile("\\d+");
		Matcher m1 = p1.matcher(memory_li);
		int memory_limit = 0;
		if (m1.find()) {
			memory_limit = Integer.parseInt(m1.group(0).trim()) / 1000;
		}

		boolean spj = false;
		String rule_type = "ACM";
		boolean visible = true;
		String difficulty = "Low";
		// String source="http://poj.org/";
		/*
		 * String submissions = doc.select(
		 * "body > table:nth-child(3) > tbody > tr > td > div.plm > table > tbody > tr:nth-child(2) > td:nth-child(1)"
		 * ) .text(); Pattern p = Pattern.compile("\\d+"); Matcher m =
		 * p.matcher(submissions);
		 */
		int submission_number = 0;
		/*
		 * if (m.find()) { submission_number = Integer.parseInt(m.group(0).trim()); }
		 */
		/*
		 * String accepted = doc.select(
		 * "body > table:nth-child(3) > tbody > tr > td > div.plm > table > tbody > tr:nth-child(2) > td:nth-child(3)"
		 * ) .text(); Pattern p1 = Pattern.compile("\\d+"); Matcher m1 =
		 * p1.matcher(accepted);
		 */
		int accepted_number = 0;
		/*
		 * if (m1.find()) { accepted_number = Integer.parseInt(m1.group(0).trim()); }
		 */

		int created_by_id = 1;
		String _id = ID;
		// json
		JsonUtil stu4 = new JsonUtil();
		String statistic_info = stu4.toString();

		int total_score = 100;
		boolean is_public = true;
		boolean spj_compile_ok = false;

		// Problem pro=new Problem();
		Connection conn = null;
		try {
			PreparedStatement ps = null;
			conn = PostgreSQLcon.getConnection();
			String sql = "insert into problem(title,description,input_description,output_description,samples,test_case_id,test_case_score,hint,languages,template,create_time,time_limit,memory_limit,spj,rule_type,visible,difficulty,source,submission_number,accepted_number,created_by_id,_id,statistic_info,total_score,is_public,spj_compile_ok)values(?,?,?,?,?::jsonb,?,?::jsonb,?,?::jsonb,?::jsonb,?,?,?,?,?,?,?,?,?,?,?,?,?::jsonb,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, title);
			ps.setString(2, description);
			ps.setString(3, input_description);
			ps.setString(4, output_description);
			ps.setString(5, samples);
			ps.setString(6, test_case_id);
			ps.setString(7, test_case_score);
			ps.setString(8, hint);
			ps.setString(9, languages);
			ps.setString(10, template);
			ps.setTimestamp(11, create_time);
			ps.setInt(12, time_limit);
			ps.setInt(13, memory_limit);
			ps.setBoolean(14, spj);
			ps.setString(15, rule_type);
			ps.setBoolean(16, visible);
			ps.setString(17, difficulty);
			ps.setString(18, source);
			ps.setInt(19, submission_number);
			ps.setInt(20, accepted_number);
			ps.setInt(21, created_by_id);
			ps.setString(22, _id);
			ps.setString(23, statistic_info);
			ps.setInt(24, total_score);
			ps.setBoolean(25, is_public);
			ps.setBoolean(26, spj_compile_ok);
			ps.executeUpdate();
			conn.close();
			/*
			 * PreparedStatement ps = null; conn = PostgreSQLcon.getConnection(); String
			 * sql="insert into Htmlentity(Htmlbody) values(?)";
			 * ps=conn.prepareStatement(sql); ps.setObject(1, Problem); ps.executeUpdate();
			 * conn.close();
			 */
			System.out.println(ID + "Input Success");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Input Fail");
		}
	}

	public static void main(String[] args) {

		try {
			for (id = 1000; id <= 4000; id++) {
				Select(id);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
