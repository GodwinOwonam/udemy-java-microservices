package net.javaguides.organizationservice.controller;

import lombok.AllArgsConstructor;
import net.javaguides.organizationservice.dto.OrganizationDto;
import net.javaguides.organizationservice.dto.OrganizationWithoutIdDto;
import net.javaguides.organizationservice.dto.Response;
import net.javaguides.organizationservice.service.OrganizationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizations")
@AllArgsConstructor
public class OrganizationController {
    private final OrganizationService organizationService;

    /**
     * Get All the organizations
     */
    @GetMapping
    public ResponseEntity<Response> all() {
        List<OrganizationDto> organizations = organizationService.all();

        return this.sendResponse(
            true,
            "Organizations fetched successfully",
            organizations,
            HttpStatus.OK
        );
    }

    /**
     * Add an organization
     */
    @PostMapping
    public ResponseEntity<Response> create(
        @RequestBody OrganizationWithoutIdDto organizationWithoutIdDto
    ) {
        OrganizationDto organization = organizationService.create(organizationWithoutIdDto);

        return this.sendResponse(
            true,
            "Organization created successfully",
            organization,
            HttpStatus.CREATED
        );
    }

    /**
     * Get one organization
     *
     * @param id
     * @return OrganizationDto
     */
    @GetMapping("{id}")
    public ResponseEntity<Response> get(@PathVariable("id") Long id) {
        OrganizationDto organization = organizationService.get(id);

        return this.sendResponse(
            true,
            "Organization fetched successfully",
            organization,
            HttpStatus.OK
        );
    }

    /**
     * Update an organization
     */
    @PutMapping("{id}")
    public ResponseEntity<Response> update(
        @PathVariable("id") Long id,
        @RequestBody OrganizationWithoutIdDto organizationWithoutIdDto
    ) {
        OrganizationDto organization = organizationService.update(id, organizationWithoutIdDto);

        return this.sendResponse(
            true,
            "Organization updated",
            organization,
            HttpStatus.OK
        );
    }

    /**
     * Delete an organization
     */
    @DeleteMapping("{id}")
    public ResponseEntity<Response> destroy(@PathVariable Long id) {
        organizationService.destroy(id);

        return this.sendResponse(
            true,
            "Organization deleted",
            null,
            HttpStatus.OK
        );
    }

    private ResponseEntity<Response> sendResponse(
        Boolean status,
        String message,
        Object data,
        HttpStatus httpStatus
    ) {
        return new ResponseEntity<>(new Response(status, message, data), httpStatus);
    }
}
