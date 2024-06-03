package springboot.organizationservice.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springboot.organizationservice.dto.OrganizationDto;
import springboot.organizationservice.entity.Organization;
import springboot.organizationservice.service.OrgaizationService;

@RestController
@RequestMapping("api/organization")
@AllArgsConstructor
public class OrganizationController {

    OrgaizationService orgaizationService;

    @PostMapping("createOrganization")
    ResponseEntity<OrganizationDto> saveOrganization(@RequestBody OrganizationDto organizationDto){
        OrganizationDto returnedOrganizationDto = orgaizationService.saveOrganization(organizationDto);
        return new ResponseEntity<>(returnedOrganizationDto, HttpStatus.CREATED);
    }

    @GetMapping("{organizationCode}")
    ResponseEntity<OrganizationDto> getOrganizationByCode(@PathVariable String organizationCode){
        OrganizationDto organizationDto = orgaizationService.getOrganizationCode(organizationCode);
        return new ResponseEntity<>(organizationDto, HttpStatus.OK);
    }

}
