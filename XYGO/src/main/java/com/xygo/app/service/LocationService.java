package com.xygo.app.service;

import java.util.List;

import com.xygo.app.dto.LocationDto;
import com.xygo.app.entity.Location;

public interface LocationService {

	Location saveLocation(LocationDto locationDto);

	List<Location> getLocations();

	Location getLocationById(Long id);

	Location updateLocation(Long id, LocationDto locationDto);

	void deleteLocationById(Long id);

}
