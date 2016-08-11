package jp.qqjy.android.demo_timeline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.List;

import jp.qqjy.android.demo_timeline.R;
import jp.qqjy.android.demo_timeline.bean.TimeLineContentBean;
import jp.qqjy.android.demo_timeline.bean.TimeLineTitleBean;

public class AgendaListAdapter extends BaseExpandableListAdapter {

	private LayoutInflater inflater = null;
	private List<TimeLineTitleBean> beanList;

	public AgendaListAdapter(Context context, List<TimeLineTitleBean> list) {
		this.beanList = list;
		inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getGroupCount() {
		return beanList.size();
	}

	@Override
	public int getChildrenCount(int groupPosition) {
		if (beanList.get(groupPosition).getContentList() == null)
			return 0;
		else
			return beanList.get(groupPosition).getContentList().size();
	}

	@Override
	public TimeLineTitleBean getGroup(int groupPosition) {
		return beanList.get(groupPosition);
	}

	@Override
	public TimeLineContentBean getChild(int groupPosition, int childPosition) {
		return beanList.get(groupPosition).getContentList().get(childPosition);
	}

	@Override
	public long getGroupId(int groupPosition) {
		return groupPosition;
	}

	@Override
	public long getChildId(int groupPosition, int childPosition) {
		return childPosition;
	}

	@Override
	public boolean hasStableIds() {
		return false;
	}

	@Override
	public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

		GroupViewHolder holder = new GroupViewHolder();
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.timeline_left, null);
		}
		holder.titleTime = (TextView) convertView.findViewById(R.id.time);
		holder.titleTime.setText(beanList.get(groupPosition).getTime());

		return convertView;
	}

	@Override
	public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
		ChildViewHolder holder = null;
		TimeLineContentBean bean = (TimeLineContentBean) getChild(groupPosition, childPosition);

		if (convertView != null) {
			holder = (ChildViewHolder) convertView.getTag();
		} else {
			holder = new ChildViewHolder();
			convertView = inflater.inflate(R.layout.timeline_content, null);
			holder.auther = (TextView) convertView.findViewById(R.id.auther);
			holder.contactCount = (TextView) convertView.findViewById(R.id.contacts);
			holder.content = (TextView) convertView.findViewById(R.id.content);
		}
		holder.auther.setText(bean.getAutherName());
		holder.contactCount.setText("参与者" + bean.getContactCounts() + "人" + " - 10分钟前");
		holder.content.setText(bean.getContent());

		convertView.setTag(holder);
		return convertView;
	}

	@Override
	public boolean isChildSelectable(int groupPosition, int childPosition) {
		return false;
	}

	private class GroupViewHolder {
		public TextView titleTime;
	}

	private class ChildViewHolder {

		public TextView auther;
		public TextView contactCount;
		public TextView content;
	}

}
