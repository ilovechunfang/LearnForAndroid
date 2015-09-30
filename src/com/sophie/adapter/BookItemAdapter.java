package com.sophie.adapter;

import java.util.ArrayList;
import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.sophie.entity.Book;
import com.sophie.newlearn.R;

public class BookItemAdapter extends BaseAdapter {

	private List<Book> books = new ArrayList<Book>();
	
	private LayoutInflater layoutInflater;
	
	private int txtResourceId;
	
	public BookItemAdapter( int resourceid, List<Book> booklist, LayoutInflater layoutInflater) {
		this.txtResourceId = resourceid;
		this.books = booklist;
		this.layoutInflater = layoutInflater;
	}
	
	@Override
	public int getCount() {
		return books.size();
	}

	@Override
	public Object getItem(int position) {
		return books.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		BookListItem listItem = null;
		View view = convertView;
		if (view == null) {
			listItem = new BookListItem();
			view = layoutInflater.inflate(txtResourceId, null);
			listItem.bookName = (TextView) view.findViewById(R.id.bookname_txtview);
			listItem.bookAuthor = (TextView) view.findViewById(R.id.bookauthor_txtview);
			view.setTag(listItem);
		} else {
			listItem = (BookListItem) view.getTag();
		}
		listItem.bookName.setText(books.get(position).getName());
		listItem.bookAuthor.setText(books.get(position).getAuthor());
		return view;
	}
	
	
	public static class BookListItem{
		public TextView bookName;
		public TextView bookAuthor;
	}

}
