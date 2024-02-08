package com.xygo.app.service.impl;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xygo.app.dto.LocationDto;
import com.xygo.app.entity.Location;
import com.xygo.app.repo.LocationRepo;
import com.xygo.app.service.LocationService;

@Service
public class LocationServiceImpl implements LocationService {

	@Autowired
	private LocationRepo locationRepo;

	@Override
	public Location saveLocation(LocationDto locationDto) {
		Location locations = new Location();
		BeanUtils.copyProperties(locationDto, locations);
		Location location = locationRepo.save(locations);
		return location;
	}

	@Override
	public List<Location> getLocations() {
		return locationRepo.findAll();
	}

	@Override
	public Location getLocationById(Long id) {
		return locationRepo.findById(id).orElseThrow();
	}

	@Override
	public Location updateLocation(Long id, LocationDto locationDto) {
		Location location = locationRepo.findById(id).orElseThrow();
		BeanUtils.copyProperties(locationDto, location);
		return locationRepo.save(location);
	}

	@Override
	public void deleteLocationById(Long id) {
		locationRepo.deleteById(id);
	}

}
