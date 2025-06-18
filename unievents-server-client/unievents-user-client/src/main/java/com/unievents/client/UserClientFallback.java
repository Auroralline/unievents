package com.unievents.client;

import com.unievents.common.ApiResponse;
import com.unievents.dto.TicketUserListDto;
import com.unievents.dto.UserGetAndTicketUserListDto;
import com.unievents.dto.UserIdDto;
import com.unievents.enums.BaseCode;
import com.unievents.vo.UserGetAndTicketUserListVo;
import com.unievents.vo.TicketUserVo;
import com.unievents.vo.UserVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 用户服务 feign 异常
 * @author: 阿星不是程序员
 **/
@Component
public class UserClientFallback implements UserClient {
    
    @Override
    public ApiResponse<UserVo> getById(final UserIdDto userIdDto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
    
    @Override
    public ApiResponse<List<TicketUserVo>> list(final TicketUserListDto dto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
    
    @Override
    public ApiResponse<UserGetAndTicketUserListVo> getUserAndTicketUserList(final UserGetAndTicketUserListDto dto) {
        return ApiResponse.error(BaseCode.SYSTEM_ERROR);
    }
}
