package jp.qqjy.android.demo_timeline;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.ExpandableListView.OnGroupClickListener;

import java.util.ArrayList;
import java.util.List;

import jp.qqjy.android.demo_timeline.adapter.AgendaListAdapter;
import jp.qqjy.android.demo_timeline.bean.TimeLineContentBean;
import jp.qqjy.android.demo_timeline.bean.TimeLineTitleBean;

public class MainActivity extends ActionBarActivity {

	private List<TimeLineTitleBean> list;
	private ExpandableListView expandlistView;
	private AgendaListAdapter adapter;
	private Context context;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		context = this;
		expandlistView = (ExpandableListView) findViewById(R.id.expandlist);

		putInitData();

		adapter = new AgendaListAdapter(context, list);
		expandlistView.setAdapter(adapter);
		// 去掉默认带的箭头
		expandlistView.setGroupIndicator(null);

		// 遍历所有group,将所有项设置成默认展开
		int groupCount = expandlistView.getCount();
		for (int i = 0; i < groupCount; i++) {
			expandlistView.expandGroup(i);
		}

		expandlistView.setOnGroupClickListener(new OnGroupClickListener() {
			@Override
			public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
				return false;//true不可点击
			}
		});

	}

	/**
	 * 以下是模拟数据， 随便复制粘贴这几天的新闻<br>
	 * 实际的数据，就看项目需求了<br>
	 * 根据需求，改动bean的数据结构、xml的布局也是可以调整
	 */
	private void putInitData() {
		list = new ArrayList<TimeLineTitleBean>();

		TimeLineTitleBean time1 = new TimeLineTitleBean();
		List<TimeLineContentBean> contentList1 = new ArrayList<TimeLineContentBean>();
		TimeLineContentBean content1 = new TimeLineContentBean();
		TimeLineContentBean content2 = new TimeLineContentBean();
		TimeLineContentBean content3 = new TimeLineContentBean();

		content1.setDetaiTime("14:52");
		content1.setAnswer(14534);
		content1.setThumbs(10);
		content1.setContactCounts(4235);
		content1.setAutherName("南都周刊");
		content1.setContent("四川多地迎来高温天气，四川日报记者从四川省气象局官方网站获悉，当天成都、眉山、乐山、内江、遂宁、攀枝花、巴中等地最高气温达到33℃，达州、广安、南充、泸州、宜宾、资阳、自贡等地气温达35℃。位于遂宁市大英县的中国“死海”旅游度假区迎来避暑高峰，当天8000多人涌进游泳池避暑纳凉，现场犹如“下饺子”");

		content2.setDetaiTime("09:12");
		content2.setAnswer(15);
		content2.setThumbs(0);
		content2.setContacts("50");
		content2.setAutherName("人民日报");
		content2.setContent("国家互联网信息办公室12日发布通知要求，全面清理所有配资炒股的违法宣传广告信息，禁止任何机构和个人通过网络渠道发布此类违法宣传广告信息。");

		content3.setDetaiTime("01:12");
		content3.setAnswer(1523);
		content3.setThumbs(2);
		content3.setContactCounts(53);
		content3.setAutherName("腾讯新闻");
		content3.setContent("综合港媒报道，香港特首梁振英在立法会答问大会上多次炮轰泛民“拉布”(故意冗长演说阻挠政策审议)，7月11日，他出席电台节目时直指香港最大的挑战非没钱、没能力，而是内部有很多阻力，批评目前立法会的秩序比台湾议会更差。他表示，目前无计划连任，会先做好经济、民生工作。");

		contentList1.add(content1);
		contentList1.add(content2);
		contentList1.add(content3);
		time1.setTime("2015-03-11");
		time1.setContentList(contentList1);
		list.add(time1);

		TimeLineTitleBean time2 = new TimeLineTitleBean();
		List<TimeLineContentBean> contentList2 = new ArrayList<TimeLineContentBean>();
		TimeLineContentBean content4 = new TimeLineContentBean();
		content4.setDetaiTime("14:52");
		content4.setAnswer(0);
		content4.setThumbs(546732);
		content4.setContactCounts(0);
		content4.setAutherName("网易新闻");
		content4.setContent("综合港媒报道，香港特首梁振英在立法会答问大会上多次炮轰泛民“拉布”(故意冗长演说阻挠政策审议)，7月11日，他出席电台节目时直指香港最大的挑战非没钱、没能力，而是内部有很多阻力，批评目前立法会的秩序比台湾议会更差。他表示，目前无计划连任，会先做好经济、民生工作。");
		contentList2.add(content4);
		time2.setTime("2015-07-11");
		time2.setContentList(contentList2);
		list.add(time2);

		TimeLineTitleBean time3 = new TimeLineTitleBean();
		List<TimeLineContentBean> contentList3 = new ArrayList<TimeLineContentBean>();
		TimeLineContentBean content5 = new TimeLineContentBean();
		TimeLineContentBean content6 = new TimeLineContentBean();
		TimeLineContentBean content7 = new TimeLineContentBean();

		content5.setDetaiTime("14:52");
		content5.setAnswer(623);
		content5.setThumbs(41);
		content5.setContactCounts(59);
		content5.setAutherName("凤凰网");
		content5.setContent("1981年我在潜艇上工作过一年多，助民劳动中也帮助渔民在海上收割过海带，当时渔民用很粗的海带绳把海带苗夹在尼龙绳上，经常造成舰船螺旋桨受损，这是个很明显的道理。 二战中海军港口水下都有反潜网，潜艇艇首也有防雷网，70年代苏联一艘潜艇螺旋桨缠上渔网差点艇毁人亡。");

		content6.setDetaiTime("14:12");
		content6.setAnswer(3421);
		content6.setThumbs(542);
		content6.setContactCounts(886);
		content6.setAutherName("新华社");
		content6.setContent("中新网7月13日电 据中央纪委监察部网站消息，中纪委网站今日刊文《推动国有企业从严治党之一——全面从严治党 国企尤为紧迫 》，文章称对中管国有重要骨干企业专项巡视中发现有的企业以改革为名，打着建立现代企业制度的旗号，贱卖贵买、予取予求，侵吞国有资产如探囊取物。");

		content7.setDetaiTime("04:52");
		content7.setAnswer(16343);
		content7.setThumbs(54);
		content7.setContactCounts(658);
		content7.setAutherName("BBC");
		content7.setContent("近日，国内知名军事论坛发布了一组据称为国产“075型大型两栖攻击舰”的模型照片，从模型的照片中可以看到，该型两栖攻击舰采用直通甲板设计，具有4个直升机起降点，1台升降机，在机库下还设置有巨大的坞舱，可以搭载一定数量的国产气垫船。在整体外形上，这款据称为“075型”的两栖攻击舰与中国在在2012年阿布扎比防务展上展示的2.5万吨级出口两栖攻击舰非常相像，因此有分析认为出口型号有可能是解放军自用的075型两栖攻击舰的衍生产品。有军事专家分析，从模型上来看，该型两栖攻击舰未配置攻击性武器，表明其对海、反潜攻击任务主要由编队掩护舰艇担当，也可通过两栖攻击舰上搭载的武装直升机、反潜直升机担当对海、对陆、反潜攻击任务。");
		contentList3.add(content5);
		contentList3.add(content6);
		contentList3.add(content7);

		time3.setTime("2015-07-15");
		time3.setContentList(contentList3);
		list.add(time3);

	}
}
