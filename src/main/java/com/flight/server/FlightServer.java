package com.flight.server;

import io.modelcontextprotocol.sdk.MCP;
import io.modelcontextprotocol.sdk.MCPServer;
import io.modelcontextprotocol.sdk.model.Context;
import com.flight.model.*;
import java.util.*;

/**
 * 国际航班预订系统服务端
 * 提供航班查询、预订等核心服务
 * 基于MCP协议实现服务端功能
 */
public class FlightServer {
    private final MCPServer server;

    /**
     * 构造函数
     * @param port 服务器监听端口
     */
    public FlightServer(int port) {
        this.server = MCP.createServer(port);
        initializeHandlers();
    }

    /**
     * 初始化所有服务处理器
     * 包括：航班搜索、航班详情、舱位查询、预订等功能
     */
    private void initializeHandlers() {
        // 1. 航班搜索接口
        server.handle("searchFlights", (Context context) -> {
            FlightSearchCriteria criteria = context.get("criteria", FlightSearchCriteria.class);
            return searchFlights(criteria);
        });

        // 2. 航班详情查询接口
        server.handle("getFlightDetails", (Context context) -> {
            String flightNo = context.getString("flightNo");
            String date = context.getString("date");
            return getFlightDetails(flightNo, date);
        });

        // 3. 舱位可用性查询接口
        server.handle("checkAvailability", (Context context) -> {
            String flightNo = context.getString("flightNo");
            String cabinClass = context.getString("cabinClass");
            int passengerCount = context.getInteger("passengerCount");
            return checkAvailability(flightNo, cabinClass, passengerCount);
        });

        // 4. 航班预订接口
        server.handle("bookFlight", (Context context) -> {
            String flightNo = context.getString("flightNo");
            List<Passenger> passengers = context.getList("passengers", Passenger.class);
            String cabinClass = context.getString("cabinClass");
            return bookFlight(flightNo, passengers, cabinClass);
        });

        // 5. 订单查询接口
        server.handle("getBooking", (Context context) -> {
            String bookingNumber = context.getString("bookingNumber");
            return getBooking(bookingNumber);
        });

        // 6. 取消预订接口
        server.handle("cancelBooking", (Context context) -> {
            String bookingNumber = context.getString("bookingNumber");
            return cancelBooking(bookingNumber);
        });
    }

    /**
     * 搜索航班
     * @param criteria 搜索条件
     * @return 航班搜索结果
     */
    private FlightSearchResponse searchFlights(FlightSearchCriteria criteria) {
        // 实现航班搜索逻辑
        return new FlightSearchResponse(/* ... */);
    }

    /**
     * 获取航班详情
     * @param flightNo 航班号
     * @param date 航班日期
     * @return 航班详细信息
     */
    private Flight getFlightDetails(String flightNo, String date) {
        // 实现航班详情查询逻辑
        return new Flight(/* ... */);
    }

    /**
     * 检查舱位可用性
     * @param flightNo 航班号
     * @param cabinClass 舱位等级
     * @param passengerCount 乘客数量
     * @return 舱位可用性信息
     */
    private AvailabilityResponse checkAvailability(String flightNo, String cabinClass, int passengerCount) {
        // 实现舱位可用性查询逻辑
        return new AvailabilityResponse(/* ... */);
    }

    /**
     * 预订航班
     * @param flightNo 航班号
     * @param passengers 乘客信息列表
     * @param cabinClass 舱位等级
     * @return 预订结果
     */
    private BookingResponse bookFlight(String flightNo, List<Passenger> passengers, String cabinClass) {
        // 实现航班预订逻辑
        return new BookingResponse(/* ... */);
    }

    private BookingDetails getBooking(String bookingNumber) {
        // 实现订单查询逻辑
        return new BookingDetails(/* ... */);
    }

    private CancellationResponse cancelBooking(String bookingNumber) {
        // 实现取消预订逻辑
        return new CancellationResponse(/* ... */);
    }

    public void start() {
        server.start();
        System.out.println("Flight Server started on port " + server.getPort());
    }

    public void stop() {
        if (server != null) {
            server.stop();
            System.out.println("Flight Server stopped on port " + server.getPort());
        }
    }

    public static void main(String[] args) {
        new FlightServer(8080).start();
    }
} 