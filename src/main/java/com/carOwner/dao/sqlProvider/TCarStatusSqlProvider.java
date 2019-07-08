package com.carOwner.dao.sqlProvider;

import com.carOwner.entity.TCarStatus;
import com.carOwner.entity.TCarStatusCriteria.Criteria;
import com.carOwner.entity.TCarStatusCriteria.Criterion;
import com.carOwner.entity.TCarStatusCriteria;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class TCarStatusSqlProvider {

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    public String countByExample(TCarStatusCriteria example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("t_car_status");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    public String deleteByExample(TCarStatusCriteria example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("t_car_status");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    public String insertSelective(TCarStatus record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("t_car_status");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getMemberId() != null) {
            sql.VALUES("member_id", "#{memberId,jdbcType=INTEGER}");
        }
        
        if (record.getMemberName() != null) {
            sql.VALUES("member_name", "#{memberName,jdbcType=VARCHAR}");
        }
        
        if (record.getCarId() != null) {
            sql.VALUES("car_id", "#{carId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlate() != null) {
            sql.VALUES("car_plate", "#{carPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            sql.VALUES("park_id", "#{parkId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.VALUES("order_id", "#{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getInTime() != null) {
            sql.VALUES("in_time", "#{inTime,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTime() != null) {
            sql.VALUES("out_time", "#{outTime,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.VALUES("create_time", "#{createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.VALUES("update_time", "#{updateTime,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    public String selectByExample(TCarStatusCriteria example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("member_id");
        sql.SELECT("member_name");
        sql.SELECT("car_id");
        sql.SELECT("car_plate");
        sql.SELECT("park_id");
        sql.SELECT("order_id");
        sql.SELECT("in_time");
        sql.SELECT("out_time");
        sql.SELECT("status");
        sql.SELECT("create_time");
        sql.SELECT("update_time");
        sql.FROM("t_car_status");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    public String updateByExampleSelective(Map<String, Object> parameter) {
        TCarStatus record = (TCarStatus) parameter.get("record");
        TCarStatusCriteria example = (TCarStatusCriteria) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("t_car_status");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getMemberId() != null) {
            sql.SET("member_id = #{record.memberId,jdbcType=INTEGER}");
        }
        
        if (record.getMemberName() != null) {
            sql.SET("member_name = #{record.memberName,jdbcType=VARCHAR}");
        }
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlate() != null) {
            sql.SET("car_plate = #{record.carPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getInTime() != null) {
            sql.SET("in_time = #{record.inTime,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTime() != null) {
            sql.SET("out_time = #{record.outTime,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{record.updateTime,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("t_car_status");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("member_id = #{record.memberId,jdbcType=INTEGER}");
        sql.SET("member_name = #{record.memberName,jdbcType=VARCHAR}");
        sql.SET("car_id = #{record.carId,jdbcType=INTEGER}");
        sql.SET("car_plate = #{record.carPlate,jdbcType=VARCHAR}");
        sql.SET("park_id = #{record.parkId,jdbcType=INTEGER}");
        sql.SET("order_id = #{record.orderId,jdbcType=VARCHAR}");
        sql.SET("in_time = #{record.inTime,jdbcType=VARCHAR}");
        sql.SET("out_time = #{record.outTime,jdbcType=VARCHAR}");
        sql.SET("status = #{record.status,jdbcType=INTEGER}");
        sql.SET("create_time = #{record.createTime,jdbcType=VARCHAR}");
        sql.SET("update_time = #{record.updateTime,jdbcType=VARCHAR}");
        
        TCarStatusCriteria example = (TCarStatusCriteria) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    public String updateByPrimaryKeySelective(TCarStatus record) {
        SQL sql = new SQL();
        sql.UPDATE("t_car_status");
        
        if (record.getMemberId() != null) {
            sql.SET("member_id = #{memberId,jdbcType=INTEGER}");
        }
        
        if (record.getMemberName() != null) {
            sql.SET("member_name = #{memberName,jdbcType=VARCHAR}");
        }
        
        if (record.getCarId() != null) {
            sql.SET("car_id = #{carId,jdbcType=INTEGER}");
        }
        
        if (record.getCarPlate() != null) {
            sql.SET("car_plate = #{carPlate,jdbcType=VARCHAR}");
        }
        
        if (record.getParkId() != null) {
            sql.SET("park_id = #{parkId,jdbcType=INTEGER}");
        }
        
        if (record.getOrderId() != null) {
            sql.SET("order_id = #{orderId,jdbcType=VARCHAR}");
        }
        
        if (record.getInTime() != null) {
            sql.SET("in_time = #{inTime,jdbcType=VARCHAR}");
        }
        
        if (record.getOutTime() != null) {
            sql.SET("out_time = #{outTime,jdbcType=VARCHAR}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=INTEGER}");
        }
        
        if (record.getCreateTime() != null) {
            sql.SET("create_time = #{createTime,jdbcType=VARCHAR}");
        }
        
        if (record.getUpdateTime() != null) {
            sql.SET("update_time = #{updateTime,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_car_status
     *
     * @mbg.generated
     */
    protected void applyWhere(SQL sql, TCarStatusCriteria example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}