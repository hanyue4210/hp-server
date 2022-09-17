package com.hp.server.dto;

import javax.validation.constraints.NotNull;

public class PageDTO {

	@NotNull(message = "missing parameters: beginRow")
    private Integer beginRow;
	@NotNull(message = "missing parameters: limitRow")
    private Integer limitRow;
	public Integer getBeginRow() {
		return beginRow;
	}
	public void setBeginRow(Integer beginRow) {
		this.beginRow = beginRow;
	}
	public Integer getLimitRow() {
		return limitRow;
	}
	public void setLimitRow(Integer limitRow) {
		this.limitRow = limitRow;
	}


}
