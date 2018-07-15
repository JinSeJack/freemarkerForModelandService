package ${packageName};

import java.util.Map;

import lj.dao.base.IJdbcDao;
import lj.model.base.Pager;
import ${modelClassPath}.${modelClassName};

public interface ${interfaceName} extends IJdbcDao<${modelClassName}> {
     /**
	 * 根据标识查询对象
	 * @param id
	 * @return
	 */
	${modelClassName} find(Long id);
	
	/**
	 * 查询所有对象
	 * @return
	 */
	${modelClassName}[] findAll();
	
	/**
	 * 新增对象
	 * @param obj
	 * @return
	 */
	long insert(${modelClassName} obj);
	
	/**
	 * 更新对象
	 * @param obj
	 * @return
	 */
	String update(${modelClassName} obj);
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 */
	String delete(Long id);
	
	/**
     * 分页查询
     * @return
     */
	Pager<${modelClassName}> findAllPaged();
	
	boolean isRepeat(String fieldName,Object fieldValue,Long id);
}
