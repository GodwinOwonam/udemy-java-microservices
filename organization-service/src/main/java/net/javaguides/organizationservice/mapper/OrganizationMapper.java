package net.javaguides.organizationservice.mapper;

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.dto.OrganizationWithoutIdDto;
import net.javaguides.organizationservice.entity.Organization;

public class OrganizationMapper {
    public static Organization mapWithoutIdToOrganization(OrganizationWithoutIdDto organizationWithoutIdDto) {
        Organization organization = new Organization();
        organization.setName(organizationWithoutIdDto.getName());
        organization.setDescription(organizationWithoutIdDto.getDescription());
        organization.setCode(organizationWithoutIdDto.getCode());
        return organization;
    }

    public static OrganizationWithoutIdDto mapOrganizationToWithoutIdDto(Organization organization) {
        return new OrganizationWithoutIdDto(
            organization.getName(),
            organization.getDescription(),
            organization.getCode()
        );
    }

    public static Organization mapToOrganization(OrganizationDto organizationDto) {
        return new Organization(
            organizationDto.getId(),
            organizationDto.getName(),
            organizationDto.getDescription(),
            organizationDto.getCode(),
            organizationDto.getCreatedAt()
        );
    }

    public static OrganizationDto mapToDto(Organization organization) {
        return new OrganizationDto(
            organization.getId(),
            organization.getName(),
            organization.getDescription(),
            organization.getCode(),
            organization.getCreatedAt()
        );
    }
}
