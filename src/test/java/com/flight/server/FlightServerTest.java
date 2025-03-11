package com.flight.server;

import com.flight.model.BookingResponse;
import com.flight.model.FlightSearchResponse;
import io.modelcontextprotocol.sdk.MCPClient;
import io.modelcontextprotocol.sdk.model.Context;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FlightServerTest {
    private FlightServer server;
    private MCPClient testClient;
    private static final int TEST_PORT = 8888;

    @Before
    public void setUp() {
        server = new FlightServer(TEST_PORT);
        server.start();
        testClient = MCP.createClient("localhost", TEST_PORT);
    }

    @After
    public void tearDown() {
        server.stop();  // 需要在FlightServer中添加stop方法
    }

    @Test
    public void testSearchFlights() {
        Context context = new Context();
        context.put("departure", "PEK");
        context.put("arrival", "LAX");
        context.put("date", "2024-03-20");

        FlightSearchResponse response = testClient.invoke("searchFlights", context, FlightSearchResponse.class);

        assertNotNull(response);
        assertNotNull(response.getFlights());
        assertEquals(2, response.getFlights().size());
        assertEquals("PEK", response.getFlights().get(0).getDeparture());
        assertEquals("LAX", response.getFlights().get(0).getArrival());
    }

    @Test
    public void testBookFlight() {
        Context context = new Context();
        context.put("flightNo", "CA123");
        context.put("passengerName", "张三");

        BookingResponse response = testClient.invoke("bookFlight", context, BookingResponse.class);

        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertNotNull(response.getBookingNumber());
        assertTrue(response.getBookingNumber().startsWith("BOK"));
    }
} 