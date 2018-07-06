package object;

import java.security.Timestamp;

public class Problem {
	public String title;
	public String description;
	public String input_description;
	public String out_description;
	public String samples;// json
	public String test_case_id;
	public String test_case_score;// json
	public String hint;
	public String languages;// json
	public String template;// Json
	public Timestamp create_time;// timestamp
	public int time_limit;
	public int memory_limit;
	public boolean spj;
	public String rule_type;
	public boolean visible;
	public String difficulty;
	public String source;
	public int submission_number;
	public int accepted_number;
	public int created_by_id;
	public String _id;
	public String statistic_info;// json
	public int total_score;
	public boolean is_public;
	public boolean spj_compile_ok;
	
	
	@Override
	public String toString() {
		return "Problem [title=" + title + ", description=" + description + ", input_description=" + input_description
				+ ", out_description=" + out_description + ", samples=" + samples + ", test_case_id=" + test_case_id
				+ ", test_case_score=" + test_case_score + ", hint=" + hint + ", languages=" + languages + ", template="
				+ template + ", create_time=" + create_time + ", time_limit=" + time_limit + ", memory_limit="
				+ memory_limit + ", spj=" + spj + ", rule_type=" + rule_type + ", visible=" + visible + ", difficulty="
				+ difficulty + ", source=" + source + ", submission_number=" + submission_number + ", accepted_number="
				+ accepted_number + ", created_by_id=" + created_by_id + ", _id=" + _id + ", statistic_info="
				+ statistic_info + ", total_score=" + total_score + ", is_public=" + is_public + ", spj_compile_ok="
				+ spj_compile_ok + "]";
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getInput_description() {
		return input_description;
	}
	public void setInput_description(String input_description) {
		this.input_description = input_description;
	}
	public String getOut_description() {
		return out_description;
	}
	public void setOut_description(String out_description) {
		this.out_description = out_description;
	}
	public String getSamples() {
		return samples;
	}
	public void setSamples(String samples) {
		this.samples = samples;
	}
	public String getTest_case_id() {
		return test_case_id;
	}
	public void setTest_case_id(String test_case_id) {
		this.test_case_id = test_case_id;
	}
	public String getTest_case_score() {
		return test_case_score;
	}
	public void setTest_case_score(String test_case_score) {
		this.test_case_score = test_case_score;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	public String getLanguages() {
		return languages;
	}
	public void setLanguages(String languages) {
		this.languages = languages;
	}
	public String getTemplate() {
		return template;
	}
	public void setTemplate(String template) {
		this.template = template;
	}
	public Timestamp getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Timestamp create_time) {
		this.create_time = create_time;
	}
	public int getTime_limit() {
		return time_limit;
	}
	public void setTime_limit(int time_limit) {
		this.time_limit = time_limit;
	}
	public int getMemory_limit() {
		return memory_limit;
	}
	public void setMemory_limit(int memory_limit) {
		this.memory_limit = memory_limit;
	}
	public boolean isSpj() {
		return spj;
	}
	public void setSpj(boolean spj) {
		this.spj = spj;
	}
	public String getRule_type() {
		return rule_type;
	}
	public void setRule_type(String rule_type) {
		this.rule_type = rule_type;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getDifficulty() {
		return difficulty;
	}
	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}
	public int getSubmission_number() {
		return submission_number;
	}
	public void setSubmission_number(int submission_number) {
		this.submission_number = submission_number;
	}
	public int getAccepted_number() {
		return accepted_number;
	}
	public void setAccepted_number(int accepted_number) {
		this.accepted_number = accepted_number;
	}
	public int getCreated_by_id() {
		return created_by_id;
	}
	public void setCreated_by_id(int created_by_id) {
		this.created_by_id = created_by_id;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getStatistic_info() {
		return statistic_info;
	}
	public void setStatistic_info(String statistic_info) {
		this.statistic_info = statistic_info;
	}
	public int getTotal_score() {
		return total_score;
	}
	public void setTotal_score(int total_score) {
		this.total_score = total_score;
	}
	public boolean isIs_public() {
		return is_public;
	}
	public void setIs_public(boolean is_public) {
		this.is_public = is_public;
	}
	public boolean isSpj_compile_ok() {
		return spj_compile_ok;
	}
	public void setSpj_compile_ok(boolean spj_compile_ok) {
		this.spj_compile_ok = spj_compile_ok;
	}


}
