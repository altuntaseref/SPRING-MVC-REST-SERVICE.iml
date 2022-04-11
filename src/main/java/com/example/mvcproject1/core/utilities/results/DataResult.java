package com.example.mvcproject1.core.utilities.results;

public class DataResult<T> extends Result {
	
	private T data;
	
	public DataResult (T data, boolean succsess, String message){
		super(succsess, message);
		this.data=data;
	}
	
	public DataResult(T data, boolean succsess) {
		super(succsess);
		this.data=data;
	}
	
	public T getData() {
		return this.data;
	}

}
