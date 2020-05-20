package com.esah2111.oauthsresource;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



import java.security.Principal;
import java.util.ArrayList;

@RestController
public class UserController {

	@GetMapping("/me")
    @PreAuthorize("hasRole('ROLE_USER')")
    public ResponseEntity<Principal> get(final Principal principal) {
        return ResponseEntity.ok(principal);
    }
    
	@RequestMapping("/tolldata")
//	@PreAuthorize("#oauth2.hasScope('toll_read') and hasAuthority('ROLE_OPERATOR')")
	public ArrayList<TollUsage> getTollData() {
		
		TollUsage instance1 = new TollUsage("200", "station150", "B65GT1W", "2016-09-30T06:31:22");
		TollUsage instance2 = new TollUsage("201", "station119", "AHY673B", "2016-09-30T06:32:50");
		TollUsage instance3 = new TollUsage("202", "station150", "ZN2GP0", "2016-09-30T06:37:01");
		
		ArrayList<TollUsage> tolls = new ArrayList<TollUsage>();
		tolls.add(instance1);
		tolls.add(instance2);
		tolls.add(instance3);
		
		return tolls;
	}
	
		public class TollUsage {
		
		public String Id;
		public String stationId;
		public String licensePlate;
		public String timestamp;
		
		public TollUsage() {}
		
		public TollUsage(String id, String stationid, String licenseplate, String timestamp){
			this.Id = id;
			this.stationId = stationid;
			this.licensePlate = licenseplate;
			this.timestamp = timestamp;
		}
		
		
	}

}