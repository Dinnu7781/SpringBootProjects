package springboot.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import springboot.organizationservice.dto.OrganizationDto;
import springboot.organizationservice.entity.Organization;
import springboot.organizationservice.mapper.OrganizationMapper;
import springboot.organizationservice.repository.OrganizationRepository;
import springboot.organizationservice.service.OrgaizationService;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrgaizationService {
//    OrganizationMapper mapper;
    OrganizationRepository organizationRepository;
    @Override
    public OrganizationDto saveOrganization(OrganizationDto organizationDto) {
        Organization organization = OrganizationMapper.mapToOrganization(organizationDto);
        Organization savedOrganization = organizationRepository.save(organization);
        OrganizationDto savedOrganizationDto = OrganizationMapper.mapToOrganizationDto(savedOrganization);
        return savedOrganizationDto;
    }

    @Override
    public OrganizationDto getOrganizationCode(String organizationCode) {
        Organization organization = organizationRepository.findByOrganizationCode(organizationCode);
        OrganizationDto organizationDto = OrganizationMapper.mapToOrganizationDto(organization);
        return organizationDto;
    }
}
