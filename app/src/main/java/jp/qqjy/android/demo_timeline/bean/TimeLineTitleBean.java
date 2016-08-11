package jp.qqjy.android.demo_timeline.bean;

import java.util.List;

public class TimeLineTitleBean {
	private String time;
	
	private List<TimeLineContentBean> contentList;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public List<TimeLineContentBean> getContentList() {
		return contentList;
	}

	public void setContentList(List<TimeLineContentBean> contentList) {
		this.contentList = contentList;
	}
		
}
