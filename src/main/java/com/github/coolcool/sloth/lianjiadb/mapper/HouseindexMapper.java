package com.github.coolcool.sloth.lianjiadb.mapper;
import java.util.*;
import com.github.coolcool.sloth.lianjiadb.model.Houseindex;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.*;

@Generated(
	value = {
		"https://github.com/coolcooldee/sloth",
		"Sloth version:1.0"
	},
	comments = "This class is generated by Sloth"
)
public interface HouseindexMapper{

	@Select("SELECT COUNT(*) FROM houseindex ")
	Integer count();


	@Select("SELECT * FROM houseindex WHERE id = #{primaryKey} LIMIT 1 ")
	Houseindex getByPrimaryKey(@Param("primaryKey") Object primaryKey);


	@Select("SELECT * FROM houseindex WHERE code = #{code} LIMIT 1 ")
	Houseindex getByCode(@Param("code") String code);


	@Delete("DELETE FROM houseindex WHERE id = #{primaryKey} ")
	Integer deleteByPrimaryKey(@Param("primaryKey") Object primaryKey);

	@Update({
		"UPDATE houseindex SET id=#{id}, code=#{code}, url=#{url}, status=#{status}, createtime=#{createtime}, updatetime=#{updatetime} where id = #{id}"
	})
	Integer updateByPrimaryKey(Houseindex houseindex);

	@Insert({
		"INSERT INTO houseindex (code, url, createtime)",
		"VALUE (#{code}, #{url}, now()) ON DUPLICATE KEY UPDATE code=code"
	})
	Integer insert(Houseindex houseindex);


	@Select("SELECT * FROM houseindex LIMIT 10 ")
	List<Houseindex> list();


	@Select("SELECT * FROM houseindex where status=0 LIMIT #{start}, #{step}")
	List<Houseindex> page(@Param("start") int start, @Param("step") int step);

	@Select("SELECT * FROM houseindex where status>0 and (lastcheckdate is null or lastcheckdate < to_days(now()) )  LIMIT #{start}, #{step}")
	List<Houseindex> pageTodayUnCheck(@Param("start") int start, @Param("step") int step);

	@Update({
			"UPDATE houseindex SET lastcheckdate = now() where code = #{code}"
	})
	void setTodayChecked(@Param("code")String code);

	@Select("SELECT `AUTO_INCREMENT` as number FROM  INFORMATION_SCHEMA.TABLES WHERE TABLE_SCHEMA = 'test' AND TABLE_NAME = 'houseindex'")
	Integer increment();
	
}