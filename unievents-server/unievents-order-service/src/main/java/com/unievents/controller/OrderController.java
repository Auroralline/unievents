package com.unievents.controller;

import com.unievents.common.ApiResponse;
import com.unievents.dto.AccountOrderCountDto;
import com.unievents.dto.OrderCancelDto;
import com.unievents.dto.OrderCreateDto;
import com.unievents.dto.OrderGetDto;
import com.unievents.dto.OrderListDto;
import com.unievents.dto.OrderPayCheckDto;
import com.unievents.dto.OrderPayDto;
import com.unievents.service.OrderService;
import com.unievents.vo.AccountOrderCountVo;
import com.unievents.vo.OrderGetVo;
import com.unievents.vo.OrderListVo;
import com.unievents.vo.OrderPayCheckVo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: 极度真实还原大麦网高并发实战项目。 添加 阿星不是程序员 微信，添加时备注 大麦 来获取项目的完整资料 
 * @description: 订单 控制层
 * @author: 阿星不是程序员
 **/
@RestController
@RequestMapping("/order")
@Tag(name = "order", description = "订单")
public class OrderController {
    
    @Autowired
    private OrderService orderService;
    
    @Operation(summary  = "订单创建(不提供给前端调用，只允许内部program服务调用)")
    @PostMapping(value = "/create")
    public ApiResponse<String> create(@Valid @RequestBody OrderCreateDto orderCreateDto) {
        return ApiResponse.ok(orderService.create(orderCreateDto));
    }
    
    @Operation(summary  = "订单支付")
    @PostMapping(value = "/pay")
    public ApiResponse<String> pay(@Valid @RequestBody OrderPayDto orderPayDto) {
        return ApiResponse.ok(orderService.pay(orderPayDto));
    }
    
    @Operation(summary  = "订单支付后状态检查")
    @PostMapping(value = "/pay/check")
    public ApiResponse<OrderPayCheckVo> payCheck(@Valid @RequestBody OrderPayCheckDto orderPayCheckDto) {
        return ApiResponse.ok(orderService.payCheck(orderPayCheckDto));
    }
    
    @Operation(summary  = "支付宝支付后回调通知")
    @PostMapping(value = "/alipay/notify")
    public String alipayNotify(HttpServletRequest request) {
        return orderService.alipayNotify(request);
    }
    
    @Operation(summary  = "查看订单列表")
    @PostMapping(value = "/select/list")
    public ApiResponse<List<OrderListVo>> selectList(@Valid @RequestBody OrderListDto orderListDto) {
        return ApiResponse.ok(orderService.selectList(orderListDto));
    }
    
    @Operation(summary  = "查看订单详情")
    @PostMapping(value = "/get")
    public ApiResponse<OrderGetVo> get(@Valid @RequestBody OrderGetDto orderGetDto) {
        return ApiResponse.ok(orderService.get(orderGetDto));
    }
    
    @Operation(summary  = "账户下某个节目的订单数量(不提供给前端调用，只允许内部program服务调用)")
    @PostMapping(value = "/account/order/count")
    public ApiResponse<AccountOrderCountVo> accountOrderCount(@Valid @RequestBody AccountOrderCountDto accountOrderCountDto) {
        return ApiResponse.ok(orderService.accountOrderCount(accountOrderCountDto));
    }
    
    @Operation(summary  = "查看缓存中的订单")
    @PostMapping(value = "/get/cache")
    public ApiResponse<String> getCache(@Valid @RequestBody OrderGetDto orderGetDto) {
        return ApiResponse.ok(orderService.getCache(orderGetDto));
    }
    
    @Operation(summary  = "订单详情取消")
    @PostMapping(value = "/cancel")
    public ApiResponse<Boolean> cancel(@Valid @RequestBody OrderCancelDto orderCancelDto) {
        return ApiResponse.ok(orderService.initiateCancel(orderCancelDto));
    }
}
