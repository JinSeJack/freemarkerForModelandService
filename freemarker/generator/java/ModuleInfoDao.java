package lj.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import lj.dao.base.JdbcDao;
import lj.global.PlatformConst;
import lj.model.base.Pager;
import lj.model.base.QueryContext;
import lj.service.BaseServiceConst;
import lj.util.IntUtils;
import lj.util.StringUtils;
import lj.util.query.QueryObject;
import lj.model.user.ModuleInfo;


@Repository
public class ModuleInfoDao extends JdbcDao<ModuleInfo> implements IModuleInfoDao {
	
	 /**
	 * 根据标识查询对象
	 * @param id
	 * @return
	 */
	@Override
	public ModuleInfo find(Long moduleId){
		String sql="select * from ModuleInfo where moduleId=:moduleId";
		ModuleInfo obj=this.find(sql,"moduleId",moduleId);
		return obj;
	}
	
	/**
	 * 查询所有对象数组
	 */
	@Override
	public ModuleInfo[] findAll()
	{
		String sql="select * from ModuleInfo";
		List<ModuleInfo> list=this.findAll(sql);
		return list.toArray(new ModuleInfo[0]);
	}
	
	/**
	 * 新增对象
	 * @param obj
	 * @return
	 */
	@Override
	public long insert(ModuleInfo obj){
	   PreparedStatementCreator stat = new PreparedStatementCreator() {
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
			    String sql="insert into ModuleInfo (moduleId,parentModuleId,moduleName,moduleCode,moduleTitle,moduleKind,entityName,entityIdName,moduleUrl) ";
		        sql=sql+" values(seqmoduleId.NEXTVAL,?,?,?,?,?,?,?,?)";
				String generatedColumns[] = {"moduleId"};
				PreparedStatement ps = con.prepareStatement(sql,generatedColumns);
				  
				  ps.setLong(1, obj.getParentModuleId());
				  
				  
				  
				  
				  
				  
				  ps.setString(2, obj.getModuleName());
				  
				  
				  
				  
				  ps.setString(3, obj.getModuleCode());
				  
				  
				  
				  
				  ps.setString(4, obj.getModuleTitle());
				  
				  
				  
				  
				  ps.setString(5, obj.getModuleKind());
				  
				  
				  
				  
				  ps.setString(6, obj.getEntityName());
				  
				  
				  
				  
				  ps.setString(7, obj.getEntityIdName());
				  
				  
				  
				  
				  ps.setString(8, obj.getModuleUrl());
				  
				return ps;
			}
		};
		KeyHolder keyHolder = new GeneratedKeyHolder();
		int intRet = this.jdbcTemplate.update(stat, keyHolder);
		if (intRet <= 0)
			return IntUtils.INT_FAIL;
		long insertId = keyHolder.getKey().longValue();
		return insertId;
	}
	
	/**
	 * 更新对象
	 */
	@Override
	public String update(ModuleInfo obj){
		String msg = StringUtils.STR_EMPTY;
		String sql = "update ModuleInfo set ";
		sql=sql+" parentModuleId=?,moduleName=?,moduleCode=?,moduleTitle=?,moduleKind=?,entityName=?,entityIdName=?,moduleUrl=?";
		sql=sql+" where moduleId=?";
		int intRet = this.jdbcTemplate.update(sql
		,obj.getParentModuleId(),obj.getModuleName(),obj.getModuleCode(),obj.getModuleTitle(),obj.getModuleKind(),obj.getEntityName(),obj.getEntityIdName(),obj.getModuleUrl(),obj.getModuleId());
		if (intRet <= 0)
			msg = BaseServiceConst.MSG_UPDATE_FAIL;
		return msg;
	}
	
	/**
	 * 删除对象
	 * @param id
	 * @return
	 */
	public String delete(Long id)
	{
		String sql="delete from ModuleInfo where moduleId=:moduleId";
		int ret=this.execute(sql, "moduleId",id);
		if(ret>0)
			return StringUtils.STR_EMPTY;
		else
			return BaseServiceConst.MSG_DELETE_FAIL;
	}
	
	/**
     * 分页查询
     * @param pageIndex：请求页index
     * @param sortField：排序字段
     * @param sortType：排序类型(asc/desc)
     * @return
     */
	@Override
	public Pager<ModuleInfo> findAllPaged(long pageIndex,String sortField,String sortType){
		String sql="select * from ModuleInfo";
		Map<String,Object> params=new HashMap<String,Object>();
		QueryObject query=JdbcDao.wrapperSqlWithCondition(sql,params);
		Pager<ModuleInfo> pager=super.findAllPaged(query.sql, query.params,
				pageIndex,sortField,sortType);
		return pager;
	}
	
	/**
	 * 某个字段值是否重复
	 * @param fieldName
	 * @param fieldValue
	 * @param id
	 * @return
	 */
	@Override
	public boolean isRepeat(String fieldName,Object fieldValue,Long id)
	{
		String sql="select * from ModuleInfo where "+fieldName+"=:"+fieldName;
		ModuleInfo oldObj=this.find(sql, fieldName, fieldValue);
		if(oldObj==null)
			return false;
		if(oldObj.getModuleId().equals(id)==true)
			return false;
		else
			return true;
	}
	
}
