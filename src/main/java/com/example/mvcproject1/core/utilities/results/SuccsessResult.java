package com.example.mvcproject1.core.utilities.results;

public class SuccsessResult extends Result {
	
	public SuccsessResult() {
		super(true);
	}
	
	public SuccsessResult(String message) {
		super(true, message);
	}

}
