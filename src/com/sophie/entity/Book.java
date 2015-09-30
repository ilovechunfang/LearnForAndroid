package com.sophie.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class Book implements Parcelable {

	private String id;
	private String name;
	private String author;
	private String digest;
	private String date;
	private String url;
	private String type;
	
	public Book(Parcel in) {
		id = in.readString();
		name = in.readString();
		author = in.readString();
		digest = in.readString();
		date = in.readString();
		url = in.readString();
		type = in.readString();
	}
	
	public Book(String id, String name, String author, String digest,
			String date, String url, String type) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.digest = digest;
		this.date = date;
		this.url = url;
		this.type = type;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	public static final Parcelable.Creator<Book> CREATOR = new Parcelable.Creator<Book>() {
		
		@Override
		public Book[] newArray(int size) {
			return new Book[size];
		}
		
		@Override
		public Book createFromParcel(Parcel source) {
			return new Book(source);
		}
	};

	@Override
	public int describeContents() {
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		dest.writeString(id);
		dest.writeString(name);
		dest.writeString(author);
		dest.writeString(digest);
		dest.writeString(date);
		dest.writeString(url);
		dest.writeString(type);
	}

}
