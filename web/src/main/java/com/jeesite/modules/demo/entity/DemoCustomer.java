/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.demo.entity;


import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * demo_customerEntity
 * @author czz
 * @version 2020-07-28
 */
@Table(name="demo_customer", alias="a", columns={
		@Column(name="id", attrName="id", label="id", isPK=true),
		@Column(name="create_by", attrName="createBy", label="create_by", isUpdate=false, isQuery=false),
		@Column(name="create_date", attrName="createDate", label="create_date", isUpdate=false, isQuery=false),
		@Column(name="update_by", attrName="updateBy", label="update_by", isQuery=false),
		@Column(name="remarks", attrName="remarks", label="remarks", queryType=QueryType.LIKE),
		@Column(name="status", attrName="status", label="status", isUpdate=false),
	}, orderBy="a.id DESC"
)
public class DemoCustomer extends DataEntity<DemoCustomer> {
	
	private static final long serialVersionUID = 1L;
	
	public DemoCustomer() {
		this(null);
	}

	public DemoCustomer(String id){
		super(id);
	}
	
}