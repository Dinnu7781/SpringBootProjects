package springboot.organizationservice.service;

import springboot.organizationservice.dto.OrganizationDto;

public interface OrgaizationService {
    OrganizationDto saveOrganization(OrganizationDto organizationDto);
    OrganizationDto getOrganizationCode(String organizationCode);
}
