package com.artqiyi.dahuashai.share.mapper;

import com.artqiyi.dahuashai.share.domain.ShareInfo;
import com.artqiyi.dahuashai.share.domain.ShareInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface ShareInfoMapper {
    @SelectProvider(type=ShareInfoSqlProvider.class, method="countByExample")
    int countByExample(ShareInfoExample example);

    @DeleteProvider(type=ShareInfoSqlProvider.class, method="deleteByExample")
    int deleteByExample(ShareInfoExample example);

    @Delete({
        "delete from share_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into share_info (id, share_content, ",
        "content_type, share_type, ",
        "create_time, update_time)",
        "values (#{id,jdbcType=BIGINT}, #{shareContent,jdbcType=VARCHAR}, ",
        "#{contentType,jdbcType=INTEGER}, #{shareType,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(ShareInfo record);

    @InsertProvider(type=ShareInfoSqlProvider.class, method="insertSelective")
    int insertSelective(ShareInfo record);

    @SelectProvider(type=ShareInfoSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="share_content", property="shareContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="content_type", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="share_type", property="shareType", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<ShareInfo> selectByExample(ShareInfoExample example);

    @Select({
        "select",
        "id, share_content, content_type, share_type, create_time, update_time",
        "from share_info",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="share_content", property="shareContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="content_type", property="contentType", jdbcType=JdbcType.INTEGER),
        @Result(column="share_type", property="shareType", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    ShareInfo selectByPrimaryKey(Long id);

    @UpdateProvider(type=ShareInfoSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") ShareInfo record, @Param("example") ShareInfoExample example);

    @UpdateProvider(type=ShareInfoSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") ShareInfo record, @Param("example") ShareInfoExample example);

    @UpdateProvider(type=ShareInfoSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(ShareInfo record);

    @Update({
        "update share_info",
        "set share_content = #{shareContent,jdbcType=VARCHAR},",
          "content_type = #{contentType,jdbcType=INTEGER},",
          "share_type = #{shareType,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(ShareInfo record);
}