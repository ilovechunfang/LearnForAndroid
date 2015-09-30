package com.sophie.newlearn;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Window;
import android.widget.ListView;

import com.sophie.adapter.BookItemAdapter;
import com.sophie.adapter.CategoryBooksAdapter;
import com.sophie.entity.Book;
import com.sophie.entity.BookCategory;

public class BookMainActivity extends Activity {

	
	private ListView mBookList;
	
	private int[] sections = BookCategory.categories;
	
	private CategoryBooksAdapter booksAdapter;
	
	private LayoutInflater layoutInflater;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_book_main);
        
        mBookList = (ListView) findViewById(R.id.bookList);
        booksAdapter = new CategoryBooksAdapter(this);
        layoutInflater = LayoutInflater.from(this);
        initAdapters();
        mBookList.setAdapter(booksAdapter);
    }
    
    
    private void initAdapters() {
    	List<Book> list = null;
    	for (int i =0; i < sections.length; i++) {
    		list = BookCategory.category_books.get(Integer.valueOf(sections[i]));
    		for (int j = 0; j < list.size(); j ++) {
    			Log.v("TAG", "list[]" + list.get(j));
    		}
    		if (list != null && list.size() > 0) {
    			BookItemAdapter itemAdapter = new BookItemAdapter(R.layout.book_item, list, layoutInflater);
    			Log.v("TAG", "section[]" + getResources().getString(sections[i]));
    			booksAdapter.addSection(getResources().getString(sections[i]), itemAdapter);
    		}
    	}
    }

}
