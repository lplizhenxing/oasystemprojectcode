package com.zszd.ai.service.sensitivewords;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zszd.ai.dao.sensitivewords.SensitivewordsDao;
import com.zszd.ai.pojo.Sensitivewords;
/**
 * 敏感词接口实现
 * @author lizx 20180103
 *
 */
@Service
public class SensitivewordsServiceImpl implements SensitivewordsService {

	@Resource 
	private SensitivewordsDao sensitivewordsDao;
	
	@Override
	public List<Sensitivewords> getAllSensitivewords() {
		return sensitivewordsDao.getAllSensitivewords();
	}

	@Override
	public int addSensitiveWordsInfo(Sensitivewords sensitivewords) {
		return sensitivewordsDao.addSensitiveWordsInfo(sensitivewords);
	}

}
