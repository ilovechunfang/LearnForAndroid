package com.sophie.entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.sophie.newlearn.R;


@SuppressWarnings("unchecked")
public class BookCategory {
	public static final int ART_PHOTOGRAPHY = R.string.cc001;
	public static final int ECONOMIC_MANAGEMENT = R.string.ce002;
	public static final int HOME_EDUCATION = R.string.cc003;
	public static final int TRAVEL_MAP = R.string.cc004;
	public static final int YOUTH_ANIMATION = R.string.cc005;
	public static final int LOVE_MARRIAGE = R.string.cc006;
	public static final int HISTORY = R.string.cc007;
	public static final int COMPUTER_INTERNET = R.string.cc008;
	
	
	
	public final static int[] categories = new int[]{
		ART_PHOTOGRAPHY,
		ECONOMIC_MANAGEMENT,
		HOME_EDUCATION,
	};
	
	public final static Map<Integer, ArrayList<Book>> category_books = new HashMap<Integer, ArrayList<Book>>();
	
	public final static Map<String, String> category_names = new HashMap<String, String>();
	
	static {
		category_books.put(ART_PHOTOGRAPHY, new ArrayList(){
			{
				add(new Book("", "��Ӱ�ľ���", "��Ʒ", "", "2014-07-07", "www.baidu.com", ""));
				add(new Book("", "���ʦ����������", "����", "", "2014-07-08", "www.baidu.com", ""));
			}
		});
		
		category_books.put(ECONOMIC_MANAGEMENT, new ArrayList(){
			{
				add(new Book("", "��Zero��One", "�����ˡ���˹��˹", "", "2014-07-07", "www.baidu.com", ""));
				add(new Book("", "���ʦ����������", "����", "", "2014-07-08", "www.baidu.com", ""));
			}
		});
		
		category_books.put(HOME_EDUCATION, new ArrayList(){
			{
				add(new Book("", "������ʤ������ʦ", "������", "", "2014-07-07", "www.baidu.com", ""));
				add(new Book("", "���ʦ����������", "����", "", "2014-07-08", "www.baidu.com", ""));
			}
		});
	}
	
}
