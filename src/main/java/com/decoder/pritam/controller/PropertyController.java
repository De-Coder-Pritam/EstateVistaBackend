package com.decoder.pritam.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.decoder.pritam.model.Feature;
import com.decoder.pritam.model.Image;
import com.decoder.pritam.model.Property;
import com.decoder.pritam.model.User;
import com.decoder.pritam.model.vo.PropertyVO;
import com.decoder.pritam.service.FeatureService;
import com.decoder.pritam.service.ImageService;
import com.decoder.pritam.service.PropertyService;
import com.decoder.pritam.service.UserService;
import com.decoder.pritam.utility.ConversionUtility;
import com.decoder.pritam.utility.JwtUtil;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/properties")
public class PropertyController {
	@Autowired
	private PropertyService propertyService;
	
	@Autowired
	private FeatureService featureService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private ImageService imageService;
	
	@Autowired
	private ConversionUtility conversionUtility;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	String FOLDER_PATH = "P:\\Microservices JAVA\\Final Year Projects\\EstateVista Frontend\\assets\\images\\";
	
	@GetMapping("/all")
	public ResponseEntity<List<PropertyVO>>  showAllProperties(){
		List<Property> repoProps = propertyService.getAllProperties();
		List<PropertyVO> voProps = conversionUtility.convertPropertyToVO(repoProps);
		return ResponseEntity.status(HttpStatus.OK).body(voProps);
	}
	
	@PostMapping("/add")
    public ResponseEntity<?> addProperty(
    		@RequestHeader("Authorization") String authHeader,
    		@RequestParam("title") String title,
            @RequestParam("description") String description,
            @RequestParam("price") String price,
            
            @RequestParam("address") String address,
            @RequestParam("city") String city,
            @RequestParam("state") String state,
            @RequestParam("postalCode") String postalCode,
            @RequestParam("propertyType") String propertyType,
            @RequestParam("status") String status,
            @RequestParam("images") MultipartFile[] files,
            @RequestParam("features") List<String> features
            
    		
    		) throws IllegalStateException, IOException {
		String token = authHeader.replace("Bearer ", "");
		String username = jwtUtil.extractUsername(token);
		
		
		Optional<User> userVal = userService.getUserByUsername(username);
		User user = userVal.get();
		HashMap<String,Object > hmap = new HashMap<>();
		if(user.getRole().equalsIgnoreCase("admin")) {
			List<Image> imgs = new ArrayList<>();
			List<Property> props = user.getProperties();
			
			List<Feature> ftrs = new ArrayList<>();
			if(props == null) {
				props = new ArrayList<>();
				
			}
			
			Property p1 = new Property();
			p1.setTitle(title);
			p1.setDescription(description);
			p1.setPrice(Double.parseDouble(price));
			p1.setAddress(address);
			p1.setCity(city);
			p1.setState(state);
			p1.setPostalCode(postalCode);
			p1.setPropertyType(propertyType);
			p1.setStatus(status);
			props.add(p1);
			user.setProperties(props);
			p1.setUser(user);
			p1 = propertyService.createProperty(p1);
			for(MultipartFile file : files) {
				int c=1;
				String filePath = FOLDER_PATH+file.getOriginalFilename();
				Image img = Image
						.builder()
						.imageUrl(filePath)
						.property(p1)
						.build();
				imageService.createImage(img);
				file.transferTo(new File(filePath));
				imgs.add(img);
				
				hmap.put("img-"+c, img.getImageUrl());
				c++;
				
			}
			for(String feat : features) {
				int c = 1;
				Feature feature = Feature
						.builder()
						.featureName(feat)
						.property(p1)
						.build();
				featureService.createFeature(feature);
				ftrs.add(feature);
				hmap.put("feature-"+c, feature.getFeatureName());
				c++;
				
				
			}
			
			p1.setImages(imgs);
			p1.setFeatures(ftrs);
			userService.createUser(user);
			propertyService.createProperty(p1);
			hmap.put("propertyName", p1.getTitle());
			hmap.put("propertyDescription", p1.getDescription());
			hmap.put("created By", user.getUsername());
			
			
			 return ResponseEntity.status(HttpStatus.OK).body(hmap);
		}
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body("You're not authorised to do this operation");
		
		
       
    }
	@GetMapping("/{id}")
	public ResponseEntity<PropertyVO> showOneProperty(
			@PathVariable("id") Long propertyId
			){
		Property prop = propertyService.getPropertyById(propertyId);
		PropertyVO propVO = conversionUtility.convertToPropertyVO(prop);
		return ResponseEntity.status(HttpStatus.OK).body(propVO);
	}

}
