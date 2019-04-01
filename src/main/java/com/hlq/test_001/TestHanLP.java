package com.hlq.test_001;

import java.util.List;

import com.hankcs.hanlp.HanLP;
import com.hankcs.hanlp.collection.AhoCorasick.AhoCorasickDoubleArrayTrie;
import com.hankcs.hanlp.dictionary.CoreDictionary;
import com.hankcs.hanlp.dictionary.CustomDictionary;
import com.hankcs.hanlp.seg.Segment;
import com.hankcs.hanlp.seg.CRF.CRFSegment;
import com.hankcs.hanlp.seg.Dijkstra.DijkstraSegment;
import com.hankcs.hanlp.seg.NShort.NShortSegment;
import com.hankcs.hanlp.seg.common.Term;
import com.hankcs.hanlp.tokenizer.IndexTokenizer;
import com.hankcs.hanlp.tokenizer.NLPTokenizer;
import com.hankcs.hanlp.tokenizer.SpeedTokenizer;

public class TestHanLP {
	/**
	 * 普通分词
	 */
	public static void test1() {
		System.out.println(HanLP.segment("你好啊 , 我就是随便试试"));
	}

	/**
	 * NLP分词 , 需要額外的data文件
	 */
	public static void test2() {
		System.out.println(NLPTokenizer.segment("你好啊 , 我就是随便试试"));
	}

	/**
	 * 索引分词
	 */
	public static void test3() {
		List<Term> termList = IndexTokenizer.segment("主副食品");
		for (Term term : termList) {
			System.out.println(term + " [" + term.offset + ":" + (term.offset + term.word.length()) + "]");
		}
	}

	/**
	 * N-最短路径分词 N最短路分词器NShortSegment比最短路分词器慢，但是效果稍微好一些，对命名实体识别能力更强。
	 * 一般场景下最短路分词的精度已经足够，而且速度比N最短路分词器快几倍，请酌情选择
	 */
	public static void test4() {
		Segment nShortSegment = new NShortSegment().enableCustomDictionary(false).enablePlaceRecognize(true)
				.enableOrganizationRecognize(true);
		Segment shortestSegment = new DijkstraSegment().enableCustomDictionary(false).enablePlaceRecognize(true)
				.enableOrganizationRecognize(true);
		String[] testCase = new String[] { "今天，刘志军案的关键人物,山西女商人丁书苗在市二中院出庭受审。这事演习", "刘喜杰石国祥会见吴亚琴先进事迹报告团成员", };
		for (String sentence : testCase) {
			System.out.println("N-最短分词：" + nShortSegment.seg(sentence) + "\n最短路分词：" + shortestSegment.seg(sentence));
		}
	}

	/**
	 * CRF对新词有很好的识别能力，但是开销较大。需要額外的data文件
	 */
	public static void test5() {
		Segment segment = new CRFSegment();
		segment.enablePartOfSpeechTagging(true);
		List<Term> termList = segment.seg("你看过穆赫兰道吗");
		System.out.println(termList);
		for (Term term : termList) {
			if (term.nature == null) {
				System.out.println("识别到新词：" + term.word);
			}
		}
	}

	/**
	 * 演示极速分词，基于AhoCorasickDoubleArrayTrie实现的词典分词，适用于“高吞吐量”“精度一般”的场合
	 */
	public static void test6() {
		String text = "江西鄱阳湖干枯，中国最大淡水湖变成大草原";
		System.out.println(SpeedTokenizer.segment(text));
		long start = System.currentTimeMillis();
		int pressure = 1000000;
		for (int i = 0; i < pressure; ++i) {
			SpeedTokenizer.segment(text);
		}
		double costTime = (System.currentTimeMillis() - start) / (double) 1000;
		System.out.printf("分词速度：%.2f字每秒", text.length() * pressure / costTime);
	}

	/**
	 * 演示用户词典的动态增删
	 */
	public static void test7() {
		// 动态增加
		CustomDictionary.add("攻城狮");
		// 强行插入
		CustomDictionary.insert("白富美", "nz 1024");
		// 删除词语（注释掉试试）
		CustomDictionary.remove("攻城狮");
		System.out.println(CustomDictionary.add("单身狗", "nz 1024 n 1"));
		System.out.println(CustomDictionary.get("单身狗"));

		String text = "攻城狮逆袭单身狗，迎娶白富美，走上人生巅峰"; // 怎么可能噗哈哈！

		// AhoCorasickDoubleArrayTrie自动机扫描文本中出现的自定义词语
		final char[] charArray = text.toCharArray();
		CustomDictionary.parseText(charArray, new AhoCorasickDoubleArrayTrie.IHit<CoreDictionary.Attribute>() {
			public void hit(int begin, int end, CoreDictionary.Attribute value) {
				System.out.printf("[%d:%d]=%s %s\n", begin, end, new String(charArray, begin, end - begin), value);
			}
		});

		// 自定义词典在所有分词器中都有效
		System.out.println(HanLP.segment(text));
	}
}
