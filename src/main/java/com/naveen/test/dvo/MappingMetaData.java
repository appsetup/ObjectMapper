package com.naveen.test.dvo;

import java.util.HashMap;
import java.util.Map;

public class MappingMetaData {
	private String name;
	private Map<String, String> fieldMap = new HashMap<String, String>();
	private Map<String, MappingMetaData> collectionFieldMap = new HashMap<String, MappingMetaData>();
	private String objectcreateConditionProperty;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Map<String, String> getFieldMap() {
		return fieldMap;
	}
	public void setFieldMap(Map<String, String> fieldMap) {
		this.fieldMap = fieldMap;
	}
	public String getObjectcreateConditionProperty() {
		return objectcreateConditionProperty;
	}
	public void setObjectcreateConditionProperty(String newObjectCreationCondition) {
		this.objectcreateConditionProperty = newObjectCreationCondition;
	}
	
	
	public Map<String, MappingMetaData> getCollectionFieldMap() {
		return collectionFieldMap;
	}
	public void setCollectionFieldMap(
			Map<String, MappingMetaData> collectionFieldMap) {
		this.collectionFieldMap = collectionFieldMap;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "::" + fieldMap + "::" + objectcreateConditionProperty;
	}
	
	
	
	
}
