package com.naveen.test.mapper;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.util.*;

import com.naveen.test.ObjectMapperConfig;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.MethodUtils;
import org.apache.commons.beanutils.PropertyUtils;

import uk.co.britishgas.bertha.*;
import uk.co.britishgas.bertha.Class;

import javax.xml.bind.JAXBException;

public class ObjectMapper
{
	public static void main(String[] args) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, JAXBException, ClassNotFoundException, FileNotFoundException {
		List<Map<String,Object>> dataList = new ArrayList<Map<String,Object>>();
		Map<String,Object> data = new HashMap<String, Object>();
		data.put("EMPLOYEE_ID", 20l);
		data.put("DEPARTMENT_ID", 30);
        data.put("SUB_EMPLOYEE_ID", 421l);
        data.put("SUB_SUB_EMPLOYEE_ID", 4421l);
		dataList.add(data);
		data = new HashMap<String, Object>();
		data.put("EMPLOYEE_ID", 20l);
		data.put("DEPARTMENT_ID", 30);
        data.put("SUB_EMPLOYEE_ID", 431l);
        data.put("SUB_SUB_EMPLOYEE_ID", 4321l);
        dataList.add(data);

        List list = new ObjectMapper().mapObjectHierarchy(dataList);
        System.out.println("Hello");
	}

    public List mapObjectHierarchy(List<Map<String, Object>> dataList) throws JAXBException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException, ClassNotFoundException, FileNotFoundException {
        ObjectMapperConfig objectMapperConfig = new ObjectMapperConfig();
        Classes objectMapperClass = objectMapperConfig.getObjectMapper("classpath:objectmapper.xml");
        Class clazz = objectMapperClass.getClazz();
        List<Column> columns = clazz.getColumn();
        List<CollectionColumns> collectionColumns =  clazz.getCollectionColumns();
        List objectList = new ArrayList();
        Object objectToBeMapped = null;
        for (Map<String, Object> stringObjectMap : dataList) {
            Object creationConditionValue = getPropertyValues(clazz.getObjectCreateCondition(),stringObjectMap);
            if(objectToBeMapped == null || (creationConditionValue != null && !creationConditionValue.
                    equals(getPropertyValues(clazz.getObjectCreateConditionJavaProperty(), objectToBeMapped))))
            {
                objectToBeMapped = java.lang.Class.forName(clazz.getClassName()).newInstance();
                objectList.add(objectToBeMapped);
                mapFields(columns, stringObjectMap, objectToBeMapped);
            }
            mapCollections(collectionColumns, stringObjectMap,objectToBeMapped);
        }
        return objectList;
    }

    private Object getPropertyValues(String property, Object stringObjectMap) throws
            IllegalAccessException, InvocationTargetException, NoSuchMethodException
    {
        String[] split = property.split(",");
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : split) {
            stringBuilder.append(BeanUtils.getProperty(stringObjectMap, s));
        }
        return stringBuilder.toString();
    }

    private void mapCollections(List<CollectionColumns> collectionColumns, Map<String, Object> stringObjectMap,
                                       Object employee) throws ClassNotFoundException, IllegalAccessException,
            InstantiationException, InvocationTargetException, NoSuchMethodException {
        for (CollectionColumns collectionColumn : collectionColumns) {
            Object property = PropertyUtils.getProperty(employee, collectionColumn.getCollectionJavaProperty());
            String className = collectionColumn.getClassName();
            String objectCreateCondition = collectionColumn.getObjectCreateCondition();
            String objectCreateConditionJavaProperty = collectionColumn.getObjectCreateConditionJavaProperty();
            List<Column> columns = collectionColumn.getCollectionColumn();
            if(property == null)
            {
                java.lang.Class propertyType = PropertyUtils.getPropertyType(employee, collectionColumn.getCollectionJavaProperty());
                if(propertyType.isAssignableFrom(List.class))
                {
                    propertyType = ArrayList.class;
                }
                else if(propertyType.isAssignableFrom(Set.class))
                {
                    propertyType = HashSet.class;
                }
                property = propertyType.newInstance();
                BeanUtils.setProperty(employee,collectionColumn.getCollectionJavaProperty(), property);
            }
            Iterator iterator = (Iterator) MethodUtils.invokeMethod(property, "iterator", null);
            Object collectionObject = null;
            for (; iterator.hasNext();) {
                collectionObject =  iterator.next();
            }
            Object creationConditionValue = getPropertyValues(objectCreateCondition, stringObjectMap);

            if(collectionObject == null || (creationConditionValue != null && !creationConditionValue.equals(getPropertyValues(objectCreateConditionJavaProperty,collectionObject))))
            {
                collectionObject = java.lang.Class.forName(className).newInstance();
                MethodUtils.invokeMethod(property,"add", collectionObject);
                mapFields(columns, stringObjectMap, collectionObject);
            }
            if(collectionColumn.getCollectionColumns() != null)
            {
                mapCollections(collectionColumn.getCollectionColumns(), stringObjectMap, collectionObject);
            }
        }
    }

    private void mapFields(List<Column> columns, Map<String, Object> stringObjectMap, Object employee) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException, InstantiationException {
        for (Column column : columns) {
            String javaProperty = column.getJavaProperty();
            String name = column.getName();
            String[] fieldHierarchy = javaProperty.split("\\.");
            StringBuilder fieldName = new StringBuilder();
            for(int i=0;i<fieldHierarchy.length -1;i++)
            {
                fieldName.append(fieldHierarchy[i]);
                Object property = PropertyUtils.getProperty(employee, fieldName.toString());
                if(property == null)
                {
                    java.lang.Class propertyType = PropertyUtils.getPropertyType(employee, fieldName.toString());
                    Object newInstance = propertyType.newInstance();
                    BeanUtils.setProperty(employee, fieldName.toString(), newInstance);
                }
            }
            BeanUtils.setProperty(employee, javaProperty, stringObjectMap.get(name));
        }
    }
}
