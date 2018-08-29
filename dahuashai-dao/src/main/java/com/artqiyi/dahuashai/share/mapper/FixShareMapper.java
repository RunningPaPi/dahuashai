package com.artqiyi.dahuashai.share.mapper;

import com.artqiyi.dahuashai.share.domain.FixShare;
import com.artqiyi.dahuashai.share.domain.FixShareExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface FixShareMapper {
    @SelectProvider(type=FixShareSqlProvider.class, method="countByExample")
    int countByExample(FixShareExample example);

    @DeleteProvider(type=FixShareSqlProvider.class, method="deleteByExample")
    int deleteByExample(FixShareExample example);

    @Delete({
        "delete from fix_share",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into fix_share (share_text, share_img, ",
        "share_type, status, ",
        "create_time, update_time)",
        "values (#{shareText,jdbcType=VARCHAR}, #{shareImg,jdbcType=VARCHAR}, ",
        "#{shareType,jdbcType=INTEGER}, #{status,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(FixShare record);

    @InsertProvider(type=FixShareSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(FixShare record);

    @SelectProvider(type=FixShareSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="share_text", property="shareText", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_img", property="shareImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_type", property="shareType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<FixShare> selectByExample(FixShareExample example);

    @Select({
        "select",
        "id, share_text, share_img, share_type, status, create_time, update_time",
        "from fix_share",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="share_text", property="shareText", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_img", property="shareImg", jdbcType=JdbcType.VARCHAR),
        @Result(column="share_type", property="shareType", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    FixShare selectByPrimaryKey(Long id);

    @UpdateProvider(type=FixShareSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") FixShare record, @Param("example") FixShareExample example);

    @UpdateProvider(type=FixShareSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") FixShare record, @Param("example") FixShareExample example);

    @UpdateProvider(type=FixShareSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(FixShare record);

    @Update({
        "update fix_share",
        "set share_text = #{shareText,jdbcType=VARCHAR},",
          "share_img = #{shareImg,jdbcType=VARCHAR},",
          "share_type = #{shareType,jdbcType=INTEGER},",
          "status = #{status,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(FixShare record);
}