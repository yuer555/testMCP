package com.flight.client;

import io.modelcontextprotocol.sdk.MCP;
import io.modelcontextprotocol.sdk.MCPClient;
import io.modelcontextprotocol.sdk.model.Context;
import com.flight.model.*;
import java.util.List;

/**
 * 国际航班预订系统客户端
 * 提供与服务端交互的接口封装
 */
public class FlightClient {
    private final MCPClient client;

    /**
     * 构造函数
     * @param host 服务器地址
     * @param port 服务器端口
     */
    public FlightClient(String host, int port) {
        this.client = MCP.createClient(host, port);
    }

    /**
     * 搜索航班
     * @param criteria 搜索条件
     * @return 航班搜索结果
     */
    public FlightSearchResponse searchFlights(FlightSearchCriteria criteria) {
        Context context = new Context();
        context.put("criteria", criteria);
        return client.invoke("searchFlights", context, FlightSearchResponse.class);
    }

    /**
     * 获取航班详情
     * @param flightNo 航班号
     * @param date 航班日期
     * @return 航班详细信息
     */
    public Flight getFlightDetails(String flightNo, String date) {
        Context context = new Context();
        context.put("flightNo", flightNo);
        context.put("date", date);
        return client.invoke("getFlightDetails", context, Flight.class);
    }

    // 3. 检查舱位可用性
    public AvailabilityResponse checkAvailability(String flightNo, String cabinClass, int passengerCount) {
        Context context = new Context();
        context.put("flightNo", flightNo);
        context.put("cabinClass", cabinClass);
        context.put("passengerCount", passengerCount);
        return client.invoke("checkAvailability", context, AvailabilityResponse.class);
    }

    // 4. 预订航班
    public BookingResponse bookFlight(String flightNo, List<Passenger> passengers, String cabinClass) {
        Context context = new Context();
        context.put("flightNo", flightNo);
        context.put("passengers", passengers);
        context.put("cabinClass", cabinClass);
        return client.invoke("bookFlight", context, BookingResponse.class);
    }

    // 5. 查询订单
    public BookingDetails getBooking(String bookingNumber) {
        Context context = new Context();
        context.put("bookingNumber", bookingNumber);
        return client.invoke("getBooking", context, BookingDetails.class);
    }

    // 6. 取消预订
    public CancellationResponse cancelBooking(String bookingNumber) {
        Context context = new Context();
        context.put("bookingNumber", bookingNumber);
        return client.invoke("cancelBooking", context, CancellationResponse.class);
    }

    public static void main(String[] args) {
        FlightClient client = new FlightClient("localhost", 8080);
        
        // 测试查询航班
        FlightSearchResponse searchResponse = client.searchFlights(new FlightSearchCriteria("PEK", "LAX", "2024-03-20"));
        System.out.println("查询结果：" + searchResponse);

        // 测试预订航班
        BookingResponse bookingResponse = client.bookFlight("CA123", List.of(new Passenger("张三", "身份证", "123456789012345678", "2000-01-01", "中国", "男", "12345678901", "zhangsan@example.com")), "经济舱");
        System.out.println("预订结果：" + bookingResponse);
    }
} 
} 