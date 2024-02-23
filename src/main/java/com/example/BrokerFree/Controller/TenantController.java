package com.example.BrokerFree.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.BrokerFree.Model.Tenant;
import com.example.BrokerFree.Service.TenantService;

@RestController
public class TenantController {
    @Autowired
    private TenantService tService;

    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/registerTenant")
    public ResponseEntity<?> registerTenant(@RequestBody Tenant tenant) {
        System.out.println("inside register tenant");
        return tService.registerTenant(tenant);
    }

    
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/loginTenant")
    public Tenant tenantLogin(@RequestBody Tenant t) throws Exception {
        String tempEmail = t.getTemail();
        String tempPassword = t.getTpassword();

        Tenant tenantobj = null;
        if (tempEmail != null && tempPassword != null) {
            tenantobj = tService.fetchTenantByEmailAndPassword(tempEmail, tempPassword);
        }
        if (tenantobj == null) {
            throw new Exception("Wrong credentials");
        }
        return tenantobj;
    }
    
    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping("/PassFogTenant")
    public ResponseEntity<?> forgotPassword(@RequestBody Tenant request) {
        String email = request.getTemail();
        String recoveryQuestion = request.getTpassreq();
        String recoveryAnswer = request.getTpassans();
        String newPassword = request.getTpassword();

        return tService.forgotPassword(email, recoveryQuestion, recoveryAnswer, newPassword);
    }
}
