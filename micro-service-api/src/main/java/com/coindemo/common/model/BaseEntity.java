package com.coindemo.common.model;

import org.apache.commons.lang.StringUtils;
import org.springframework.data.annotation.Transient;

import com.coindemo.common.message.Message;
import com.coindemo.common.utils.StringEx;

import lombok.Data;

/**
 * @author kerfer
 */
@Data
public abstract class BaseEntity extends PrimaryKeyObject<Long>{

	private static final long serialVersionUID = 1L;
	/**
	 * 是否包含转义字符
	 */
	@Transient
	protected Boolean escapeChar;
	
	
	/**
	 * 模糊查询关键字
	 */
	protected String keyword;
	
	/**
	 * 
	 */
	protected String flagkeyword;
	
	/**
	 * 
	 */
	protected Message rMessage;
	
	/**
	 * @return the keyword
	 */
	public String getKeyword() {
		return keyword == null ? null : keyword.trim();
	}
	
	private void getNewKeyword(){
		if(escapeChar == null){
			escapeChar = false;
		}
		if(StringUtils.isNotEmpty(keyword)&&!escapeChar){
			String newkeyword = StringEx.checkSql(keyword);
			if(!keyword.equals(newkeyword)){
				this.setEscapeChar(true);
				this.setKeyword(newkeyword);
			}
		}
	}

	/**
	 * @param keyword the keyword to set
	 */
	public void setKeyword(String keyword) {
		this.keyword = keyword == null ? null : keyword.trim();
	}

	@Override
	public Long getCreatedTime() {
		return createdTime;
	}

	@Override
	public void setCreatedTime(Long createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public Long getUpdatedTime() {
		return updatedTime;
	}

	@Override
	public void setUpdatedTime(Long updatedTime) {
		this.updatedTime = updatedTime;
	}

	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getEscapeChar() {
		this.getNewKeyword();
		return escapeChar;
	}
	


	
}
