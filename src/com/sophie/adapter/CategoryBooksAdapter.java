package com.sophie.adapter;

import java.util.HashMap;
import java.util.Map;

import com.sophie.newlearn.R;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

public class CategoryBooksAdapter extends BaseAdapter {
	
	private final ArrayAdapter<String> sectionsAdapter;
	
	private final Map<String, Adapter> sectionsItemAdapter = new HashMap<String, Adapter>();
	
	public final static int TYPE_SECTION_HEADER = 0;  
	
	
	public CategoryBooksAdapter(Context context) {
		sectionsAdapter = new ArrayAdapter<String>(context, R.layout.category, R.id.text1);
	}
	
	public void addSection(String section, Adapter adapter) {
		this.sectionsAdapter.add(section);
		this.sectionsItemAdapter.put(section, adapter);
	}
	
	@Override
	public int getCount() {
		int total = 0;
		for (Adapter adapter : sectionsItemAdapter.values()) {
			total += (adapter.getCount() > 0 ? adapter.getCount() + 1 : 0);
		}
		return total;
	}

	@Override
	public Object getItem(int position) {
		
		for (int i = 0; i < sectionsAdapter.getCount(); i ++) {
			String section = sectionsAdapter.getItem(i);
			Adapter adapter = sectionsItemAdapter.get(section);
			if (adapter.getCount() > 0) {
				int size = adapter.getCount() + 1;
				
				if (position == 0) {
					return section;
				}
				
				if (position < size) {
					return adapter.getItem(position - 1);
				}
				position -= size;
			}
		}
		return null;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		int sectionnum = 0;
		for (int i = 0; i < sectionsAdapter.getCount(); i ++) {
			String section = sectionsAdapter.getItem(i);
			
			Adapter adapter = sectionsItemAdapter.get(section);
			
			if (adapter != null && adapter.getCount() > 0) {
				int size = adapter.getCount() + 1;
				
				if (position == 0) {
					return sectionsAdapter.getView(sectionnum, convertView, parent);
				}
				if (position < size) {
					return adapter.getView(position - 1, null, parent);
				}
				position -= size;
			}
			sectionnum ++;
		}
		return null;
	}
	
	@Override
	public int getViewTypeCount() {
		int count = 1;
		for (Adapter adapter : sectionsItemAdapter.values()) {
			count += adapter.getViewTypeCount();
		}
		return count;
	}
	
	@Override
	public int getItemViewType(int position) {
		  
        int type = 1;
        for(int i = 0; i < sectionsAdapter.getCount(); i++) {
        	String section = sectionsAdapter.getItem(i);
            Adapter adapter = sectionsItemAdapter.get(section);  
            
            // skip empty sections
            if(adapter.getCount() > 0)
            {
                int size = adapter.getCount() + 1;  
                
                // check if position inside this section  
                if(position == 0) return TYPE_SECTION_HEADER;
                if(position < size) return type + adapter.getItemViewType(position - 1);  
      
                // otherwise jump into next section  
                position -= size;  
                type += adapter.getViewTypeCount();              	
            }
        }  
        return -1;  
	}

	
	
}
