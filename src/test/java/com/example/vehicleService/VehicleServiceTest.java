package com.example.vehicleService;

import com.example.vehicleService.entity.Vehicle;
import com.example.vehicleService.repository.VehicleRepository;
import com.example.vehicleService.service.VehicleService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class VehicleServiceTest {

    // Step 1: Create a FAKE version of the repository (a mock)
    @Mock
    private VehicleRepository vehicleRepository;

    // Step 2: Put that fake into the service
    @InjectMocks
    private VehicleService vehicleService;

    // Step 3: Tell Mockito to activate the mocks
    public VehicleServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAllVehicles() {
        // Step 1: Arrange
        Vehicle v1 = new Vehicle(1L, "Toyota", "Camry", 2015);
        Vehicle v2 = new Vehicle(2L, "Honda", "Civic", 2018);
        List<Vehicle> fakeList = Arrays.asList(v1, v2);

        // Tell the mock: “Whenever someone calls findAll(), return fakeList”
        when(vehicleRepository.findAll()).thenReturn(fakeList);

        // Step 2: Act
        List<Vehicle> result = vehicleService.getAllVehicles();

        // Step 3: Assert
        assertEquals(2, result.size());                      // ✅ Check number of items
        assertEquals("Toyota", result.get(0).getMake());     // ✅ Check first item's make

        // Step 4: Verify
        verify(vehicleRepository, times(1)).findAll();       // ✅ Check it was called once
    }

    @Test
    void testGetVehicleById(){
        //Arrange
        Vehicle v1 = new Vehicle(1L, "Toyota", "Camry", 2020);
        Vehicle v2 = new Vehicle(2L,"Honda","CRV", 2030);

        when(vehicleRepository.findById(1L)).thenReturn(Optional.of(v1));

        //Act
        Optional<Vehicle> vehicleById = vehicleService.getVehicleById(1L);

        //Assert
        assertEquals("Toyota", vehicleById.get().getMake());

        //Verify
        verify(vehicleRepository, times(1)).findById(1L);



    }
}
