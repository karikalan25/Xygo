package com.xygo.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.xygo.app.dto.LocationDto;
import com.xygo.app.entity.Location;
import com.xygo.app.service.LocationService;
import com.xygo.app.utils.APIResponse;
import com.xygo.app.utils.Response;

@RestController
public class LocationController {

	@Autowired
	private LocationService locationService;

	@PostMapping("/location")
	public APIResponse<?> saveEmployeePay(@RequestBody LocationDto locationDto) {
		try {
			Location location = locationService.saveLocation(locationDto);
			return Response.getSuccessResponse(location, "Location Saved Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/locations")
	public APIResponse<?> getLocations() {
		try {
			List<Location> location = locationService.getLocations();
			return Response.getSuccessResponse(location, "success", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/location/{id}")
	public APIResponse<?> getLocationById(@PathVariable("id") Long id) {
		try {
			Location location = locationService.getLocationById(id);
			return Response.getSuccessResponse(location, "success", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/location/{id}")
	public APIResponse<?> updateLocation(@PathVariable Long id, @RequestBody LocationDto locationDto) {
		try {
			Location location = locationService.updateLocation(id, locationDto);
			return Response.getSuccessResponse(location, "Location Updated Successfully", HttpStatus.OK);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@DeleteMapping("/location/{id}")
	public APIResponse<?> deleteLocationById(@PathVariable("id") Long id) {
		try {
			locationService.deleteLocationById(id);
			return Response.getSuccessResponse(null, "Location Deleted Successfully", HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return Response.getFailureResponse(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
