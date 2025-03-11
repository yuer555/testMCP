package com.flight.client;

import com.flight.model.BookingResponse;
import com.flight.model.Flight;
import com.flight.model.FlightSearchResponse;
import io.modelcontextprotocol.sdk.MCPServer;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class FlightClientTest {
    private FlightClient client;
    private static final int TEST_PORT = 8889;

    @Mock
    private MCPServer mockServer;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        client = new FlightClient("localhost", TEST_PORT);
    }

    @Test
    public void testSearchFlights() {
        FlightSearchResponse expectedResponse = new FlightSearchResponse(
            Arrays.asList(
                new Flight("CA123", "PEK", "LAX", "2024-03-20", "1000"),
                new Flight("MU456", "PEK", "LAX", "2024-03-20", "1200")
            )
        );

        when(mockServer.handle(eq("searchFlights"), any())).thenReturn(expectedResponse);

        FlightSearchResponse response = client.searchFlights("PEK", "LAX", "2024-03-20");
        
        assertNotNull(response);
        assertEquals(2, response.getFlights().size());
        assertEquals("CA123", response.getFlights().get(0).getFlightNo());
    }

    @Test
    public void testBookFlight() {
        BookingResponse expectedResponse = new BookingResponse(true, "预订成功", "BOK123456");
        
        when(mockServer.handle(eq("bookFlight"), any())).thenReturn(expectedResponse);

        BookingResponse response = client.bookFlight("CA123", "张三");
        
        assertNotNull(response);
        assertTrue(response.isSuccess());
        assertEquals("预订成功", response.getMessage());
        assertEquals("BOK123456", response.getBookingNumber());
    }
} 