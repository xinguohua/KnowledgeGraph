package icdMangerSystem;

import java.util.List;

import org.junit.Test;

import com.icd.dal.RelationMapper;
import com.icd.model.RelationInfo;


/**
 * @author 李耀华
 * @since 2020年7月8日
 * 单元测试Mybatis数据操作
 */
public class DemoTest {

	@Test
	public void test() {
		RelationMapper testmapper=new RelationMapper();
		List<RelationInfo> list=testmapper.getRelationInfoByName("安倍晋三");
		for(RelationInfo item:list) {
			System.out.println(item.getName());
			System.out.println(item.getRelation());
			System.out.println(item.getDescript());
		}
	}

}
