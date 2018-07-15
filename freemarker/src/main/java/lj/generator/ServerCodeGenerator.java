package lj.generator;

import org.springframework.beans.factory.BeanFactory;

import lj.global.AppFun;
import lj.util.GeneratorUtils;
import lj.util.SpringUtils;

public class ServerCodeGenerator {

	/**
	 * 生成实体类
	 * 
	 * @param tableName
	 */
	private static void testGenerateEntityClass(String packageName, String tableName) {
		GeneratorUtils.generatorEntityClass(packageName, tableName);
	}

	private static void testGenerateDaoInterface(String packageName, String tableName, String modelClassPath) {
		GeneratorUtils.generatorDaoInterface(packageName, tableName, modelClassPath);
	}

	private static void testGeneratorDaoClass(String packageName, String tableName, String modelClassPath,
			String indexName) {
		GeneratorUtils.generatorDaoClass(packageName, tableName, modelClassPath, indexName);

	}

	public static void main(String[] args) {

		AppFun.preLoad();
		BeanFactory factory=SpringUtils.getBeanFactory();
		
		// 需要设置信息
		String parentCateogry = "user";
		String tableName = "ModuleInfo";
		String indexName = "moduleId";
		String modelClassPath = "lj.model." + parentCateogry;
		String daoClassPath = "lj.dao." + parentCateogry;
		String serviceClassPath = "lj.service." + parentCateogry;
		testGenerateEntityClass(modelClassPath, tableName);
		testGenerateDaoInterface(daoClassPath, tableName, modelClassPath);
		testGeneratorDaoClass(daoClassPath, tableName, modelClassPath, indexName);
		GeneratorUtils.generateServiceCode(tableName, daoClassPath, serviceClassPath, modelClassPath);
		
		
		//4-生成C#模型
//		String csPath=AppVar.appPath+File.separator+GeneratorUtils.PATH_GENERATOR_CS;
//		String nameSpace = "Model." + StringUtils.toTypeName(parentCateogry);
//	    GeneratorUtils.generatorEntityClassCs(nameSpace, tableName, indexName,csPath);
	}
}
