package com.back.common.exception.user;

import com.back.common.exception.base.BaseException;

/**
 * 用户信息异常类
 * 
 * @author back
 */
public class UserException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args)
    {
        super("user", code, args, null);
    }
}
