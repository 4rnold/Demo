package com.example.springbootdemo.T7_Test_Mybatis_TypeHandler.TypeHandler;

import com.example.springbootdemo.T7_Test_Mybatis_TypeHandler.entity.UserStatus;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


@MappedTypes(UserStatus.class)
public class UserStatusTypeHandler extends BaseTypeHandler<UserStatus>{

    /**
     * 如何保存进数据库
     * @param ps
     * @param i
     * @param parameter
     * @param jdbcType
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, UserStatus parameter, JdbcType jdbcType) throws SQLException {
        ps.setString(i, String.valueOf(parameter.getCode()));
    }

    @Override
    public UserStatus getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int code = rs.getInt(columnName);
        UserStatus userStatusByCode = UserStatus.getUserStatusByCode(code);
        return userStatusByCode;
    }

    @Override
    public UserStatus getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int code = rs.getInt(columnIndex);
        UserStatus userStatusByCode = UserStatus.getUserStatusByCode(code);
        return userStatusByCode;
    }

    @Override
    public UserStatus getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int code = cs.getInt(columnIndex);
        UserStatus userStatusByCode = UserStatus.getUserStatusByCode(code);
        return userStatusByCode;
    }
}
