package com.huhuo.cmsystem.dict;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.huhuo.carservicecore.constant.Dictionary.ModelDict;
import com.huhuo.carservicecore.constant.Dictionary.ModelDictGroup;
import com.huhuo.carservicecore.db.GenericBaseExtenseServ;
import com.huhuo.carservicecore.sys.dictionary.IDaoDictionary;
import com.huhuo.carservicecore.sys.dictionary.ModelDictionary;
import com.huhuo.integration.base.IBaseExtenseDao;

@Service("cmsystemServDictionary")
public class ServDictionary extends GenericBaseExtenseServ<ModelDictionary> 
	implements IServDictionary {

	@Resource(name = "carservicecoreDaoDictionary")
	private IDaoDictionary iDaoDictionary;
	
	@Override
	public void inject(ModelDictionary t) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public IBaseExtenseDao<ModelDictionary> getDao() {
		return iDaoDictionary;
	}
	

	@Override
	public List<ModelDictionary> getGroupsBy(ModelDictGroup dictGroup) {
		return iDaoDictionary.getGroupsBy(dictGroup);
	}

	@Override
	public ModelDictionary getBy(ModelDictGroup dictGroup, Integer dictKey) {
		return iDaoDictionary.getBy(dictGroup, dictKey);
	}

	@Override
	public ModelDictionary getBy(ModelDict dict) {
		return iDaoDictionary.getBy(dict);
	}


}
