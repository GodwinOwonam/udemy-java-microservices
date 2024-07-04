package net.javaguides.organizationservice.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.dto.OrganizationWithoutIdDto;
import net.javaguides.organizationservice.entity.Organization;
import net.javaguides.organizationservice.mapper.OrganizationMapper;
import net.javaguides.organizationservice.repository.OrganizationRepository;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrganizationServiceImpl implements OrganizationService {
    private OrganizationRepository organizationRepository;

    @Override
    public OrganizationDto create(OrganizationWithoutIdDto organizationWithoutIdDto) {
        Organization organization = OrganizationMapper.mapWithoutIdToOrganization(organizationWithoutIdDto);
        Organization savedOrganization = organizationRepository.save(organization);

        return OrganizationMapper.mapToDto(savedOrganization);
    }

    @Override
    public OrganizationDto get(Long id) {
        Organization organization = organizationRepository.findById(id).get();

        return OrganizationMapper.mapToDto(organization);
    }

    @Override
    public List<OrganizationDto> all() {
        List<Organization> organizations = organizationRepository.findAll();

        List<OrganizationDto> organizationList = organizations.stream()
            .map(OrganizationMapper::mapToDto)
            .collect(Collectors.toList());

        return organizationList;
    }

    @Override
    public OrganizationDto update(Long id, OrganizationWithoutIdDto organizationWithoutIdDto) {
        Organization updated = organizationRepository.findById(id).get();

        updated.setName(organizationWithoutIdDto.getName());
        updated.setDescription(organizationWithoutIdDto.getDescription());
        updated.setCode(organizationWithoutIdDto.getCode());

        Organization savedOrganization = organizationRepository.save(updated);

        return OrganizationMapper.mapToDto(savedOrganization);
    }

    @Override
    public void destroy(Long id) {
        organizationRepository.deleteById(id);
    }
}
