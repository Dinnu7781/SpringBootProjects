package springboot.organizationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import springboot.organizationservice.dto.OrganizationDto;
import springboot.organizationservice.entity.Organization;

public interface OrganizationRepository extends JpaRepository<Organization,Long> {
    Organization findByOrganizationCode(String organizationCode);
}
