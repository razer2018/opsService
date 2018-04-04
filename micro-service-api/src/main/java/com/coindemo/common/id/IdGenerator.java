package com.coindemo.common.id;

import org.apache.log4j.Logger;

/**
 * 全局Id生成器
 * 
 * @author kaihu
 */
public class IdGenerator {
	private static Logger logger = Logger.getLogger(IdGenerator.class);

	public static <T> Long generateId(Class<T> clazz) {
		IdCreator idCreator = IdCreatorFactory.getTimeIdCreator(1);
		try {
			return idCreator.nextId(clazz.getName());
		} catch (Exception e) {
			logger.error("generate global id exception:", e);
			return -1L;
		}
	}

	public static void main(String[] args) {
		System.out.println(IdGenerator.generateId(IdGenerator.class));
	}
}
