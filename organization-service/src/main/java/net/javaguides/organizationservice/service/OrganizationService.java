package net.javaguides.organizationservice.service;

import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.dto.OrganizationWithoutIdDto;
import java.util.List;

public interface OrganizationService {
    OrganizationDto create(OrganizationWithoutIdDto organizationWithoutIdDto);
    OrganizationDto get(Long id);
    List<OrganizationDto> all();
    OrganizationDto update(Long id, OrganizationWithoutIdDto organizationWithoutIdDto);
    void destroy(Long id);
}
