package com.klicks.klicks.entities;

import java.util.List;

public class Result<T> {

	private int count;

	private List<T> results;

	public Result() {
	}

	public Result(int count, List<T> results) {
		this.count = count;
		this.results = results;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<T> getResults() {
		return results;
	}

	public void setResults(List<T> results) {
		this.results = results;
	}

}