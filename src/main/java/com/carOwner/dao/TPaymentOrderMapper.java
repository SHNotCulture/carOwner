package com.carOwner.dao;

import com.carOwner.dao.sqlProvider.TPaymentOrderSqlProvider;
import com.carOwner.entity.TPaymentOrder;
import com.carOwner.entity.TPaymentOrderCriteria;
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

public interface TPaymentOrderMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @SelectProvider(type= TPaymentOrderSqlProvider.class, method="countByExample")
    long countByExample(TPaymentOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @DeleteProvider(type=TPaymentOrderSqlProvider.class, method="deleteByExample")
    int deleteByExample(TPaymentOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @Delete({
        "delete from t_payment_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @Insert({
        "insert into t_payment_order (id, deal_id, ",
        "mch_id, body, payment_method, ",
        "fee, car_plate, open_id, ",
        "park_id, time_start, ",
        "create_time, update_time, ",
        "flag)",
        "values (#{id,jdbcType=INTEGER}, #{dealId,jdbcType=INTEGER}, ",
        "#{mchId,jdbcType=VARCHAR}, #{body,jdbcType=VARCHAR}, #{paymentMethod,jdbcType=VARCHAR}, ",
        "#{fee,jdbcType=DOUBLE}, #{carPlate,jdbcType=VARCHAR}, #{openId,jdbcType=VARCHAR}, ",
        "#{parkId,jdbcType=INTEGER}, #{timeStart,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=VARCHAR}, #{updateTime,jdbcType=VARCHAR}, ",
        "#{flag,jdbcType=INTEGER})"
    })
    int insert(TPaymentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @InsertProvider(type=TPaymentOrderSqlProvider.class, method="insertSelective")
    int insertSelective(TPaymentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @SelectProvider(type=TPaymentOrderSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="deal_id", property="dealId", jdbcType=JdbcType.INTEGER),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_method", property="paymentMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee", property="fee", jdbcType=JdbcType.DOUBLE),
        @Result(column="car_plate", property="carPlate", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="time_start", property="timeStart", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER)
    })
    List<TPaymentOrder> selectByExample(TPaymentOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @Select({
        "select",
        "id, deal_id, mch_id, body, payment_method, fee, car_plate, open_id, park_id, ",
        "time_start, create_time, update_time, flag",
        "from t_payment_order",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="deal_id", property="dealId", jdbcType=JdbcType.INTEGER),
        @Result(column="mch_id", property="mchId", jdbcType=JdbcType.VARCHAR),
        @Result(column="body", property="body", jdbcType=JdbcType.VARCHAR),
        @Result(column="payment_method", property="paymentMethod", jdbcType=JdbcType.VARCHAR),
        @Result(column="fee", property="fee", jdbcType=JdbcType.DOUBLE),
        @Result(column="car_plate", property="carPlate", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_id", property="openId", jdbcType=JdbcType.VARCHAR),
        @Result(column="park_id", property="parkId", jdbcType=JdbcType.INTEGER),
        @Result(column="time_start", property="timeStart", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="flag", property="flag", jdbcType=JdbcType.INTEGER)
    })
    TPaymentOrder selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TPaymentOrderSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") TPaymentOrder record, @Param("example") TPaymentOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TPaymentOrderSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") TPaymentOrder record, @Param("example") TPaymentOrderCriteria example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @UpdateProvider(type=TPaymentOrderSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(TPaymentOrder record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_payment_order
     *
     * @mbg.generated
     */
    @Update({
        "update t_payment_order",
        "set deal_id = #{dealId,jdbcType=INTEGER},",
          "mch_id = #{mchId,jdbcType=VARCHAR},",
          "body = #{body,jdbcType=VARCHAR},",
          "payment_method = #{paymentMethod,jdbcType=VARCHAR},",
          "fee = #{fee,jdbcType=DOUBLE},",
          "car_plate = #{carPlate,jdbcType=VARCHAR},",
          "open_id = #{openId,jdbcType=VARCHAR},",
          "park_id = #{parkId,jdbcType=INTEGER},",
          "time_start = #{timeStart,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=VARCHAR},",
          "flag = #{flag,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(TPaymentOrder record);
}